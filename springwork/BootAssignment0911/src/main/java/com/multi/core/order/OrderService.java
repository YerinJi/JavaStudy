package com.multi.core.order;

import com.multi.core.discount.DiscountPolicy;
import com.multi.core.member.Member;
import com.multi.core.notify.Notifier;
import com.multi.core.time.TimeProvider;

import java.util.List;
import java.util.Map;

//주문생성 시 할인 적용
//XML DI 실습용
// 의도적 세터 주입
// List/Map 컬렉션 주입
public class OrderService {
    private DiscountPolicy discountPolicy;
    private TimeProvider timeProvider;
    private List<Notifier> notifiers;
    private Map<String, Notifier> notifierMap;

    public OrderService() {
    }

    public int CreateOrder(Member member, int price){
        int sale = discountPolicy.discount(member, price);
        String msg = String.format("주문 생성 %s / 원가 %d, 할인 %d, 시각:%s", member.getName(), price, sale,timeProvider.nowFormatted());
        if(notifiers != null){
            notifiers.forEach(n -> n.send(msg)); //알림발송
        }
        return price - sale;
    }

    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void setTimeProvider(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void setNotifiers(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void setNotifierMap(Map<String, Notifier> notifierMap) {
        this.notifierMap = notifierMap;
    }
}
