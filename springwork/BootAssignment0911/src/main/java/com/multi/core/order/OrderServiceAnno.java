package com.multi.core.order;

import com.multi.core.discount.DiscountPolicy;
import com.multi.core.member.Member;
import com.multi.core.notify.Notifier;
import com.multi.core.time.TimeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//annotation 기반 DI 실습
// 핵심 의존성 생성자 주입
// 컬렉션은 세터 주입
// @Primary / @Qualifier는 구성 클래스에서 제어
@Service
@Scope("singleton")
public class OrderServiceAnno {
    private final DiscountPolicy discountPolicy;
    private final TimeProvider timeProvider;

    private List<Notifier> notifiers;
    private Map<String, Notifier> notifierMap;

    @Autowired
    public OrderServiceAnno(DiscountPolicy discountPolicy, TimeProvider timeProvider) {
        this.discountPolicy = discountPolicy;
        this.timeProvider = timeProvider;
    }

    @Autowired(required = false)
    public void setNotifiers(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    @Autowired(required = false)
    public void setNotifierMap(Map<String, Notifier> notifierMap) {
        this.notifierMap = notifierMap;
    }

    public int createOrder(Member member, int price){
        int dc = discountPolicy.discount(member, price);
        String msg = String.format("[ANNOTATION] 주문: %s / %d -> 할인 %d / %s",
                member.getName(), price, dc, timeProvider.nowFormatted());
        if (notifiers != null) notifiers.forEach(n -> n.send(msg));
        return price - dc;
    }
}
