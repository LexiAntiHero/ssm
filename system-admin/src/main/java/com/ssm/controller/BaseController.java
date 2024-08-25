package com.ssm.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ssm.constant.Constants;
import com.ssm.core.RedisTemplate;
import com.ssm.entity.SsmLoginUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Set;

public class BaseController {
    @Resource
    RedisTemplate redisTemplate;

    protected  SsmLoginUser getLoginUser(){
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
        return redisTemplate.getObject(tokenKey, new TypeReference<>() {
        });
    }
}
