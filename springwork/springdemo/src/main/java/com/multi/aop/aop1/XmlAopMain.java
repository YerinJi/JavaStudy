package com.multi.aop.aop1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.multi.service.MyService;

public class XmlAopMain {
    public static void main(String[] args) {
        //applicationContext는 xmlDom을 의미한다.
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/aop1.xml");
        System.out.println(applicationContext);

        //MyService는 핵심코드이다.
        MyService myService = applicationContext.getBean(MyService.class);
        //핵심코드를 콜하면 aop에 지정한 곳으로 전처리, 후처리가 진행된다.
        System.out.println(myService.performAction("XML"));
        myService.showMessage(); //비즈니스 로직 수행
    }
}
