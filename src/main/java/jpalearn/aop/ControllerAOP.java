package jpalearn.aop;

import jpalearn.config.UserSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
@Aspect
@RequiredArgsConstructor
@Slf4j
public class ControllerAOP {
    private final UserSession userSession;

    @Around("execution(public * jpalearn.controller.*.*(..))")
    public Object aroundController(ProceedingJoinPoint joinpoint) throws Throwable {
        userSession.setLastAccessTime(LocalDateTime.now());
        log.info("{} called at {}", joinpoint.getSignature(), userSession.getLastAccessTime());
        return joinpoint.proceed();
    }
}
