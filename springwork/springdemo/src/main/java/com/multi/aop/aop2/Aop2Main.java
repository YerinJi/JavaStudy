package com.multi.aop.aop2;

import com.multi.repository.ActionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aop2Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
//        System.out.println(context.getBean("actionServiceImp")); //비즈니스 로직 수행을 하기위한 객체
        ActionService actionService = context.getBean("actionServiceImp", ActionService.class);
        actionService.showMessage(); //비즈니스로직 수행
        System.out.println(context.getBean("pop"));
    }
}
