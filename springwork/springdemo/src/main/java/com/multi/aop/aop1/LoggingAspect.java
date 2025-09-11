package com.multi.aop.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect { //LoggingAspect
    //Aspect는 What + When + Where

    //When Before
    //* com.multi.service.MyService.*(..))이코드는 pointcut을 의미한다. pointcut은 Where를 의미
    @Before("execution(* com.multi.service.MyService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        //비즈니스 로직을 수행했을 때 관련메소드 이름 반환
        String name = joinPoint.getSignature().getName();
        if(name.equals("performAction")){
            System.out.println("logBefore PerformAction");//What(공통부분)
        }else if(name.equals("showMessage")){
            System.out.println("logBefore ShowMessage");//What(공통부분)
        }
    }
    @After("execution(* com.multi.service.MyService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("logAfter"); //What(공통부분)
    }

}
