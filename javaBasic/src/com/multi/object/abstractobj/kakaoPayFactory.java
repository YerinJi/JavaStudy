package com.multi.object.abstractobj;

public class kakaoPayFactory extends PaymentFactory{
    Payment create(){
        return new Payment(){
            void pay(int amount){
                System.out.println("카카오페이로 " + amount + "원 결제");
            }
        };
    }
}
