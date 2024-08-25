package com.ssm.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ssm.constant.Constants;
import com.ssm.core.RedisTemplate;
import com.ssm.entity.SsmLoginUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Set;

public class AuthUtil  {
    public static SsmLoginUser getLoginUser(RedisTemplate redisTemplate){
        // Get the current HTTP request
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        // Retrieve the token from the request header
        String token = request.getHeader(Constants.HEAD_AUTHORIZATION);

        // Check if the token is null
        if (token == null) {
            throw new RuntimeException("User does not login!");
        }

        // Retrieve keys from Redis that match the pattern with the token
        Set<String> keys = redisTemplate.keys(Constants.TOKEN_PREFIX + "*" + token);
        if (keys == null || keys.size() == 0) {
            throw new RuntimeException("User does not login!");
        }

        // Get the first key from the set
        String tokenKey = (String) keys.toArray()[0];

        // Use the token to get the corresponding loginUser from Redis
        return redisTemplate.getObject(tokenKey, new TypeReference<>() {});
    }

}
