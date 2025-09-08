package com.multi.app;

import com.multi.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoDiMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/di-xml.xml");

        MyService myService = ctx.getBean("myService", MyService.class);
        System.out.println(myService.performAction("ANNO-DI"));

    }
}
