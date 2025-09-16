package com.multi.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Aspect @Component
public class LoggingAspect {
    @Before("execution(* com.multi..SampleService.*(..))")
    public void before(JoinPoint jp){ System.out.println("[B] " + jp.getSignature()); }

    @AfterReturning(pointcut="execution(* com.multi..SampleService.*(..))", returning="ret")
    public void afterReturning(JoinPoint jp, Object ret){
        System.out.println("[AR] " + jp.getSignature() + " => " + ret);
    }

    @AfterThrowing(pointcut="execution(* com.multi..SampleService.*(..))", throwing="ex")
    public void afterThrowing(JoinPoint jp, Throwable ex){
        System.out.println("[AT] " + jp.getSignature() + " !! " + ex.getClass().getSimpleName());
    }

    @After("execution(* com.multi..SampleService.*(..))")
    public void after(JoinPoint jp){ System.out.println("[A] " + jp.getSignature()); }
}

