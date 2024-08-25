package com.ssm.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.ssm.configuration.CustomObjectMapper;
import com.ssm.constant.Constants;
import com.ssm.core.RedisTemplate;
import com.ssm.dao.SsmUserDao;
import com.ssm.entity.SsmLoginUser;
import com.ssm.entity.SsmMenu;
import com.ssm.entity.SsmRole;
import com.ssm.entity.SsmUser;
import com.ssm.exception.PasswordIncorrectException;
import com.ssm.exception.UserNotFoundException;
import com.ssm.service.SsmUserService;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * User Information Table(SsmUser)表服务实现类
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@Service("ssmUserService")
@Slf4j
public class SsmUserServiceImpl implements SsmUserService {
    @Resource
    private SsmUserDao ssmUserDao;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private CustomObjectMapper objectMapper;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SsmUser queryById(Long userId) {
        return this.ssmUserDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param ssmUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SsmUser> queryByPage(SsmUser ssmUser, PageRequest pageRequest) {
        long total = this.ssmUserDao.count(ssmUser);
        return new PageImpl<>(this.ssmUserDao.queryAllByLimit(ssmUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @Override
    public SsmUser insert(SsmUser ssmUser) {
        this.ssmUserDao.insert(ssmUser);
        return ssmUser;
    }

    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @Override
    public SsmUser update(SsmUser ssmUser) {
        this.ssmUserDao.update(ssmUser);
        return this.queryById(ssmUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.ssmUserDao.deleteById(userId) > 0;
    }

    @Override
    public SsmLoginUser login(String userName, String password) throws JsonProcessingException {
        // 1. Log in and use the username to query the user. If not found, the account does not exist
        SsmUser ssmUser = ssmUserDao.queryByUserName(userName);
        if (ssmUser == null) throw new UserNotFoundException("Login operation: [" + userName + "] user does not exist");

// 2. If the user is found, compare the passwords. If the password is incorrect, login fails
        if (!password.equals(ssmUser.getPassword())) {
            log.info("Login operation: [" + userName + "] incorrect password");
            throw new PasswordIncorrectException("Login operation: [" + userName + "] incorrect password");
        }
        System.out.println(ssmUser.getPassword());
        System.out.println(ssmUser.getUserName());

// 3. If verification is successful

// (1) Generate a token
        String token = UUID.randomUUID().toString();

        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        System.out.println(request);
        System.out.println("a");
        UserAgent userAgent = new UserAgent(request.getHeader("User-Agent"));
        System.out.println("b");
// Get location from IP address
        ResponseEntity<String> result = restTemplate.getForEntity("https://whois.pconline.com.cn/ipJson.jsp?ip=" + request.getRemoteHost() + "&json=true", String.class);
        String body = result.getBody();
        Map<String, String> map = objectMapper.readValue(body, new TypeReference<>() {});

        String location = map.get("addr") + map.get("pro") + map.get("city") + map.get("region");

// (2) Encapsulate a SsmLoginUser and store it in Redis
        SsmLoginUser ssmLoginUser = SsmLoginUser.builder()
                .userId(ssmUser.getUserId())
                .token(token)
                .ipaddr(request.getRemoteAddr())
                .loginTime(new Date())
                .os(userAgent.getOperatingSystem().getName())
                .browser(userAgent.getBrowser().getName())
                .loginLocation(location)
                .ssmUser(ssmUser)
                .build();

// Key processing: token:username:uuid
// 1. Generate a key prefix based on the username token:username:
       String keyPrefix = Constants.TOKEN_PREFIX + userName + ":";
// 2. Query data with the prefix token:username:
       Set<String> keys = redisTemplate.keys(keyPrefix + "*");
// 3. Delete the old data
       keys.forEach(key -> redisTemplate.remove(key));
// 4. Add the new data to Redis
       redisTemplate.setObject(keyPrefix + token, ssmLoginUser, Constants.TOKEN_TIME);

        return ssmLoginUser;

    }

    @Override
    public void logout() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader(Constants.HEAD_AUTHORIZATION);
        redisTemplate.remove(Constants.TOKEN_PREFIX +"SSM_admin:"+ token);
    }

    @Override
    public HashMap<String, List<String>> getInfo() {
        SsmLoginUser loginUser = getLoginUser();

        SsmUser info = ssmUserDao.getInfo(loginUser.getUserId());

        List<String> roleTags = info.getSsmRoles().stream().map(SsmRole::getRoleTag).collect(Collectors.toList());
        redisTemplate.setObject(Constants.ROLE_PREFIX + loginUser.getToken(),roleTags,Constants.TOKEN_TIME);
        List<String> perms = new ArrayList<>();
        info.getSsmRoles().stream().map(SsmRole::getSsmMenus).forEach(menus -> {
            perms.addAll(menus.stream().map(SsmMenu::getPerms).collect(Collectors.toList()));
        });

        redisTemplate.setObject(Constants.PERM_PREFIX + loginUser.getToken(), perms,Constants.TOKEN_TIME);

        HashMap<String, List<String>> data = new HashMap<>();
        data.put("roles", roleTags);
        data.put("perms", perms);

        return  data;
    }

    private SsmLoginUser getLoginUser(){
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader(Constants.HEAD_AUTHORIZATION);

        if (token == null) {
            throw new RuntimeException("User does not login!");
        }
        //String tokenKey = Constants.TOKEN_PREFIX + request.getHeader("username")+":"+token;
        Set<String> keys = redisTemplate.keys(Constants.TOKEN_PREFIX + "*" + token);
        if (keys== null || keys.size() == 0){
            throw new RuntimeException("User does not login!");
        }
        String tokenKey = (String)keys.toArray()[0];
        // 3、使用token去redis中查看，有没有对应的loginUser
        return redisTemplate.getObject(tokenKey, new TypeReference<>() {
        });
    }
}
