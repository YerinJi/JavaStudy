package com.multi.object.abstractobj;

public class CreditCard extends Payment {
    @Override
    void pay(int amount) {
        System.out.println("신용카드로 " + amount + "원 결제");
    }
}
