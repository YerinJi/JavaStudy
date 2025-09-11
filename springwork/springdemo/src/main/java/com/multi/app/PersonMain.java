package com.multi.app;

import com.multi.di.di1.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/person.xml");
        //System.out.println(applicationContext.getBean("person1"));
        applicationContext.getBean("person1", Person.class).setName("태란");//Person(태란)
        System.out.println(applicationContext.getBean("person1", Person.class).getName());//성민


    }
}
