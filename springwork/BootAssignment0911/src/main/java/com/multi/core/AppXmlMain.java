package com.multi.core;

import com.multi.core.member.Grade;
import com.multi.core.member.Member;
import com.multi.core.order.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//XML 컨테이너 실행
public class AppXmlMain {
    public static void main(String[] args) {
        try(var ctx = new ClassPathXmlApplicationContext("spring/app-context.xml")){
            var os = ctx.getBean("orderService", OrderService.class);
            var vip = new Member(1L, "지예린", Grade.VIP);
            var basic = new Member(2L, "김철수", Grade.BASIC);

            int payVip = os.CreateOrder(vip, 10000);
            int payBasic = os.CreateOrder(basic, 10000);

            System.out.println("결제금액(VIP) : " + payVip);
            System.out.println("결제금액(Basic) : " + payBasic);
        }
    }
}
