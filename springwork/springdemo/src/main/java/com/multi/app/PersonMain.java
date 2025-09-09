package com.multi.app;

import com.multi.di.di1.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/person.xml");
        System.out.println(ctx.getBean("person1"));
        ctx.getBean("person1",Person.class).setName("예린");
        System.out.println(ctx.getBean("person1",Person.class).getName());

    }
}
