package com.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssm.entity.SsmLoginUser;
import com.ssm.entity.SsmUser;
import com.ssm.service.SsmUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class IndexController {
    @Resource
    private SsmUserService userService;

    @PostMapping("login")
    public ResponseEntity<SsmLoginUser> login(@RequestBody @Validated SsmUser ssmUser, BindingResult bindingResult){
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        allErrors.forEach(e -> log.error("Validation failed: {}", e.getDefaultMessage()));
        if (allErrors.size() > 0) {
            return ResponseEntity.status(500).build();
        }
        SsmLoginUser ssmLoginUser= null;
        try {
            ssmLoginUser = userService.login(ssmUser.getUserName(),ssmUser.getPassword());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok().body(ssmLoginUser);
    }

    @GetMapping("logout")
    public ResponseEntity<String> logout(){
        try {
            userService.logout();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok().body("Logout successfully!");
    }

}
