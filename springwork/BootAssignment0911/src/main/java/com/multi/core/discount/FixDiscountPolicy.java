package com.multi.core.discount;

import com.multi.core.member.Grade;
import com.multi.core.member.Member;

//고정 금액 기반 할인 1000원
public class FixDiscountPolicy implements DiscountPolicy {
    private final int amount;

    public FixDiscountPolicy(int amount) {
        this.amount = amount;
    }

    @Override
    public int discount(Member member, int price) {
        return (member.getGrade() == Grade.VIP) ? amount : 0;
    }

    @Override
    public String toString() {
        return "FixDiscountPolicy{" +
                "amount=" + amount +
                '}';
    }
}
