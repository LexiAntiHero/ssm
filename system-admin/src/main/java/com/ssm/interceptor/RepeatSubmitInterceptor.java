package com.ssm.interceptor;

import com.ssm.annotation.Repeat;
import com.ssm.configuration.CustomObjectMapper;
import com.ssm.constant.Constants;
import com.ssm.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class RepeatSubmitInterceptor implements HandlerInterceptor {
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private CustomObjectMapper customObjectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            // Get the controller method
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // Check if the method has the annotation to prevent repeated submissions
            Repeat annotation = method.getAnnotation(Repeat.class);
            if (annotation != null) {
                if (this.isRepeatSubmit(request, annotation)) {
                    // If it's confirmed as a repeated submission, respond with a failure message
                    ResponseEntity<String> body = ResponseEntity.status(500).body("You have submitted the same request multiple times!");
                    response.setStatus(500);
                    response.setContentType("application/json;charset=utf-8");
                    response.getWriter().write(customObjectMapper.writeValueAsString(body));
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public boolean isRepeatSubmit(HttpServletRequest request, Repeat annotation) throws IOException {
        // Get the list of parameters and serialize them
        String nowParams = customObjectMapper.writeValueAsString(request.getParameterMap());

        // Request URL (used as the cache key)
        String url = request.getRequestURI();

        // Unique identifier (use the request URL if there's no token in the headers)
        String token = request.getHeader(Constants.HEAD_AUTHORIZATION);

        // Get the body data

        // Unique key (specified key + URL + token)
        String cacheRepeatKey = Constants.REPEAT_SUBMIT_KEY + token + ":" + url;
        // If the key does not exist in Redis, it means this request is a repeated submission
        String preParams = redisTemplate.get(cacheRepeatKey);

        if (preParams != null && preParams.equals(nowParams)) {
            return true;
        }
        // Otherwise, store it in Redis, and make sure to set an expiration time
        redisTemplate.set(cacheRepeatKey, nowParams, annotation.value());
        return false;
    }
}

