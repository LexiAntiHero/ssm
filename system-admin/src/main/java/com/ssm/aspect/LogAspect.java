package com.ssm.aspect;

import com.ssm.annotation.Log;
import com.ssm.core.RedisTemplate;
import com.ssm.entity.SsmOperLog;
import com.ssm.service.SsmOperLogService;
import com.ssm.util.AuthUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class LogAspect implements BeanFactoryAware {
    @Resource
    private SsmOperLogService ssmOperLogService;

    @Resource
    RedisTemplate redisTemplate;

//    @Resource
//    ExecutorService executorService;
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @AfterReturning("@annotation(operLog)")
    public void AfterReturning(JoinPoint joinPoint, Log operLog) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        LogAspect logAspect = beanFactory.getBean(this.getClass());
        SsmOperLog ssmOperLog = createOperLog(joinPoint, request, operLog, null);

        logAspect.logHandler(ssmOperLog);
        log.info("{},do Operations:[{}]",ssmOperLog.getOperName(),ssmOperLog.getTitle());
    }
    @AfterThrowing(value = "@annotation(operLog)", throwing = "exception")
    public void AfterThrowing(JoinPoint joinPoint, Log operLog, Exception exception) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        LogAspect logAspect = beanFactory.getBean(this.getClass());
        SsmOperLog ssmOperLog = createOperLog(joinPoint, request, operLog, exception);

        logAspect.logHandler(ssmOperLog);
        log.error("{},do Operations:[{}]",ssmOperLog.getOperName(),ssmOperLog.getTitle(),exception);
    }
    @Async("ssm-logger")
    public void logHandler( SsmOperLog ssmOperLog) {

        ssmOperLogService.insert(ssmOperLog);



    }

    private SsmOperLog createOperLog(JoinPoint joinPoint, HttpServletRequest request, Log log, Exception exception) {
        SsmOperLog ssmOperLog = new SsmOperLog();
        ssmOperLog.setTitle(log.title());
        ssmOperLog.setBusinessType(log.businessType());
        if (exception != null) {
            ssmOperLog.setErrormsg(exception.getMessage().length() > 1000 ? exception.getMessage().substring(0,1000) : exception.getMessage());
            ssmOperLog.setStatus(500);
        } else {
            ssmOperLog.setStatus(200);
        }

        ssmOperLog.setOperIp(request.getRemoteAddr());
        ssmOperLog.setRequestMethod(request.getMethod());
        if (AuthUtil.getLoginUser(redisTemplate) != null && AuthUtil.getLoginUser(redisTemplate).getSsmUser() != null) {
            ssmOperLog.setOperName(AuthUtil.getLoginUser(redisTemplate).getSsmUser().getUserName());
        }
        ssmOperLog.setOperUrl(request.getRequestURI());

        String methodName = joinPoint.getSignature().getName();
        ssmOperLog.setMethod(methodName);
        ssmOperLog.setOpertime(new Date());
        return ssmOperLog;
    }


}
