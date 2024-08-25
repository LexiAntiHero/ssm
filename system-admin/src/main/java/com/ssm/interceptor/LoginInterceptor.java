package com.ssm.interceptor;

import com.ssm.configuration.CustomObjectMapper;
import com.ssm.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private CustomObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


//        ResponseEntity<String> res = ResponseEntity.status(401).body("Bad Credentials!");
//        String token = request.getHeader(Constants.HEAD_AUTHORIZATION);
//
//        if (token == null) {
//            response.setStatus(401);
//            response.getWriter().write(objectMapper.writeValueAsString(res));
//            return false;
//        }
//        String tokenKey = Constants.TOKEN_PREFIX + request.getHeader("username")+":"+token;
//        Set<String> keys = redisTemplate.keys(Constants.TOKEN_PREFIX + "*" + token);
//        if (keys== null || keys.size() == 0){
//            response.setStatus(401);
//            response.getWriter().write(objectMapper.writeValueAsString(res));
//            return false;
//        }
//        //String tokenKey = (String)keys.toArray()[0];
//
//        SsmLoginUser ssmLoginUser = redisTemplate.getObject(tokenKey, new TypeReference<>() {
//        });
//        if (ssmLoginUser == null) {
//            response.setStatus(401);
//            response.getWriter().write(objectMapper.writeValueAsString(res));
//            return false;
//        }
//
//        redisTemplate.expire(tokenKey, Constants.TOKEN_TIME);

        return true;
    }
}

