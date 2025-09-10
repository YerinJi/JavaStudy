package com.multi.app;

import com.multi.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDiMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/di-xml.xml");
        MyService  myService =  applicationContext.getBean("myService",MyService.class);
        System.out.println(myService.performAction("XML-DI"));


    }
}
