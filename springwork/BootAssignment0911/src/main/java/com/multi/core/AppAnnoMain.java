package com.multi.core;

import com.multi.core.member.Grade;
import com.multi.core.member.Member;
import com.multi.core.order.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppAnnoMain {
    public static void main(String[] args) {
        try (var ctx = new ClassPathXmlApplicationContext("spring/app-context.xml")) {
            var orderService = ctx.getBean("orderService", OrderService.class);


            var m1 = new Member(1L, "지예린", Grade.VIP);
            var m2 = new Member(2L, "김철수", Grade.BASIC);


            int pay1 = orderService.CreateOrder(m1,10000);
            int pay2 = orderService.CreateOrder(m2, 10000);


            System.out.println("결제금액(VIP) = " + pay1);
            System.out.println("결제금액(BASIC) = " + pay2);
        }
    }
}
