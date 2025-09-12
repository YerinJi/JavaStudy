package com.multi.aop.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //what + when + where
@Component //객체를 생성하라는 annotation
public class LoggingAspect {

//    @Before("execution(* com.multi.repository.ActionService.*(..))") //when
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Before Method"); //what(공통단코드)
//    }
//
//    @AfterReturning("execution(* com.multi.repository.ActionService.*(..))")
//    public void afterReturning(JoinPoint joinPoint) {
//        System.out.println("Afterreturning Method");
//    }
//
//    @After("execution(* com.multi.repository.ActionService.*(..))")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("After Method");
//    }
//
//    @AfterThrowing("execution(* com.multi.repository.ActionService.*(..))")
//    public void afterThrowing(JoinPoint joinPoint) {
//        System.out.println("Afterthrowing Method");
//    }

    @Around("execution(* com.multi.repository.ActionService.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Around Before Method");
        try{
            proceedingJoinPoint.proceed();
            System.out.println("Around Process");
        }catch (Throwable e){
            System.out.println("Around Exception");
            e.printStackTrace();
        }finally {
            System.out.println("Around finally After");
        }
        System.out.println("Around After Returning");
    }
}

