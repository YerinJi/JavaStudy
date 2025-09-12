package com.multi.aop.aop2;

import com.multi.di.di4.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.multi.repository","com.multi.aop.aop2"})
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean(name = "pop")
    public Person getPerson(){
        return new Person();
    }
}
