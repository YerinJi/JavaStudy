package com.multi.di.di5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/book.xml");
        System.out.println(context.getBean("state"));
    }
}
