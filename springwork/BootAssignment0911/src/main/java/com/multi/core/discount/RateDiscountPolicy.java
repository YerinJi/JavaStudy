package com.multi.core.discount;

import com.multi.core.member.Grade;
import com.multi.core.member.Member;

//퍼센트 할인
public class RateDiscountPolicy implements DiscountPolicy {
    private final int rate;

    public RateDiscountPolicy(int rate) {
        this.rate = rate;
    }

    //VIP라면 할인 price * rate/100 적용한 값 return
    @Override
    public int discount(Member member, int price) {
        return (member.getGrade() == Grade.VIP) ? price * rate / 100:0;
    }

    @Override
    public String toString() {
        return "RqteDiscountPolicy{" +
                "rate=" + rate +
                '}';
    }
}
