package com.multi.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.multi.aop.service.SampleService;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AopApplication.class, args);

        SampleService sampleService = ctx.getBean(SampleService.class);
        sampleService.greet("World");
        sampleService.calc(2, 3);
        try {
            sampleService.fail();
        } catch (Exception e) {
            System.out.println("main caught: " + e.getMessage());
        }

    }
}
