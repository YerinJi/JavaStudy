package com.multi.aop.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //what + when + where
@Component //객체를 생성하라는 annotation
public class LoggingAspect {

    @Before("execution(* com.multi.repository.ActionService.*(..))") //when
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before Method"); //what(공통단코드)
    }

}

