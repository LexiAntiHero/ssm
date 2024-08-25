package com.ssm.aspect;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ssm.annotation.HasPermission;
import com.ssm.annotation.HasRole;
import com.ssm.constant.Constants;
import com.ssm.core.RedisTemplate;
import com.ssm.exception.PermissionNeedHasException;
import com.ssm.exception.RoleNeedHasException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Component
@Aspect
public class PermissionAspect  {
    @Resource
    private RedisTemplate redisTemplate;

    @Before("@annotation(hasRole)")
    public void roleBefore(JoinPoint joinPoint, HasRole hasRole){
        String[] needRoles = hasRole.value();
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader(Constants.HEAD_AUTHORIZATION);
        List<String> hasRoles = redisTemplate.getObject(Constants.ROLE_PREFIX + token, new TypeReference<>() {
        });
        boolean flag = false;
        for (String needRole : needRoles) {
            if (hasRoles.contains(needRole)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw  new RoleNeedHasException("DO NOT HAVE THE PERMISSION TO ACCESS!");
        }
    }

    @Before("@annotation(hasPermission)")
    public void roleBefore(JoinPoint joinPoint, HasPermission hasPermission){
        String[] needPermissions = hasPermission.value();
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader(Constants.HEAD_AUTHORIZATION);
        List<String> hasPermissions = redisTemplate.getObject(Constants.PERM_PREFIX + token, new TypeReference<>() {
        });
        boolean flag = false;
        for (String needRole : needPermissions) {
            if (hasPermissions.contains(needRole)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw  new PermissionNeedHasException("DO NOT HAVE THE PERMISSION TO ACCESS!");
        }
    }
}
