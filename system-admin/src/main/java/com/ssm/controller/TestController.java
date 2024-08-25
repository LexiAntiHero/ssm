package com.ssm.controller;

import com.ssm.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Resource
    private RedisTemplate redisTemplate;
    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driverName}")
    private String driverName;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;
    @GetMapping("test")
    public String test() {
        redisTemplate.setObject("map", List.of("zs","ls"), 200L);
        System.out.println("Database URL: " + url);
        System.out.println("Database Driver: " + driverName);
        System.out.println("Database User: " + user);
        System.out.println("Database Password: " + password);
        return "Hello ssm-project!";
    }
}
