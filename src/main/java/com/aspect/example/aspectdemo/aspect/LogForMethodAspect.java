package com.aspect.example.aspectdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/at-aspectj.html
@Aspect
@Component
public class LogForMethodAspect {

    @Pointcut("@annotation(com.aspect.example.aspectdemo.annotation.LogForMethod)")
    public void logForMethod() {
    }

    @Around("logForMethod()")
    public Object around(ProceedingJoinPoint thisJointPoint) {
        try {
            System.out.println("[Around] before method.");
            return thisJointPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("[Around] after method.");
        }

    }

    @Before("logForMethod()")
    public void beforeAdvice() {
        System.out.println("[Before] Advice method.");
    }

    @After("logForMethod()")
    public void afterAdvice() {
        System.out.println("[After] Advice method.");
    }
}
