package com.multi.di.di7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//조립기.....
@Configuration
@ComponentScan(basePackages = {"com.multi.di.di7"})
@ImportResource({"/spring/person.xml"})
public class ConfigDemo {

    @Bean
    public StateServer getStateServer(){
        return new StateServer("www.naver.com",5000,"account","1234");
    }
    @Bean(name = "msg")
    public Message getMessage(){
        Message message=new Message();
        message.setMsg("hello");
        return message;
    }


}