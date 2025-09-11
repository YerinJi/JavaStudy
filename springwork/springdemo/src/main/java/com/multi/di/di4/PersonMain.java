package com.multi.di.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class PersonMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/persondi.xml");
        PersonCollection pCollection  =((PersonCollection)applicationContext.getBean("pCollection"));
        //System.out.println(pCollection.getMap());
        Iterator<Integer>iter= pCollection.getMap().keySet().iterator();
        while(iter.hasNext()){

            System.out.println(pCollection.getMap().get(iter.next()));
        }
    }
}
