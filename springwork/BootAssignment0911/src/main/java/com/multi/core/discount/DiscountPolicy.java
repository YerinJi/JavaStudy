package com.multi.core.discount;

import com.multi.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
