package com.multi.di.di7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigDemo.class);
        System.out.println(context.getBean("msg"));
        System.out.println(context.getBean("person1"));
    }
}
