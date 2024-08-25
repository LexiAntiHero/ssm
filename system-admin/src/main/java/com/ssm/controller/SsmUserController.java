package com.ssm.controller;

import com.ssm.annotation.HasPermission;
import com.ssm.annotation.HasRole;
import com.ssm.annotation.Log;
import com.ssm.entity.SsmUser;
import com.ssm.service.SsmUserService;
import com.ssm.ssmEnum.DeleteFlagEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * User Information Table(SsmUser)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@RestController
@RequestMapping("ssmUser")
public class SsmUserController extends BaseController {

    @Resource
    private SsmUserService ssmUserService;


    @GetMapping
    @Log(title = "Search user", businessType = "User operation")
    public ResponseEntity<Page<SsmUser>> queryByPage(SsmUser ssmUser) {
        //int i = 1/0;
        return ResponseEntity.ok(this.ssmUserService.queryByPage(ssmUser,PageRequest.of(ssmUser.getPage(),ssmUser.getSize())));
    }

    @GetMapping("getInfo")
    public ResponseEntity<HashMap<String, List<String>>> getInfo() {
        return ResponseEntity.ok(this.ssmUserService.getInfo());
    }


    @GetMapping("{id}")
    @HasPermission("system:user:query")
    public ResponseEntity<SsmUser> queryById(@PathVariable("id") Long id) {
//        SsmLoginUser loginUser = getLoginUser();
//        List<String> hasPerms = redisTemplate.getObject(Constants.PERM_PREFIX + loginUser.getToken(),  new TypeReference<>(){});
//        if (!hasPerms.contains("system:user:query")) {
//            throw new RuntimeException("YOU DO NOT HAVE THE PERMIT TO ACCESS!");
//        }
        return ResponseEntity.ok(this.ssmUserService.queryById(id));
    }


    @PostMapping
    @HasRole({"admin","hr"})
    @Log(title = "Create user", businessType = "User operation")
    public ResponseEntity<SsmUser> add(@RequestBody SsmUser ssmUser, HttpServletRequest request) {
        ssmUser.setLoginIp(request.getRemoteHost());
        ssmUser.setCreateTime(new Date());
        ssmUser.setCreateBy(getLoginUser().getSsmUser().getUserName());
        ssmUser.setStatus("0");
        ssmUser.setDelFlag(DeleteFlagEnum.NO.getValue());
        return ResponseEntity.ok(this.ssmUserService.insert(ssmUser));
    }


    @PutMapping
    public ResponseEntity<SsmUser> edit(@RequestBody SsmUser ssmUser) {
        return ResponseEntity.ok(this.ssmUserService.update(ssmUser));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(this.ssmUserService.deleteById(id));
    }

}

