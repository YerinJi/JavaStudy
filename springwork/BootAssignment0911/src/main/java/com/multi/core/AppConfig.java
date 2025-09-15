package com.multi.core;

import com.multi.core.discount.DiscountPolicy;
import com.multi.core.discount.RateDiscountPolicy;
import com.multi.core.notify.EmailNotifier;
import com.multi.core.notify.Notifier;
import com.multi.core.notify.SmsNotifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Profile("xml")
@Configuration
@ComponentScan(basePackages = "com.multi.core")
public class AppConfig {

    @Bean
    @Primary
    DiscountPolicy rateDiscountPolicy(@Value("${discount.rate:10}") int rate) {
        return new RateDiscountPolicy(rate);
    }

    @Bean
    @Profile("prod")
    Notifier emailNotifier() { return new EmailNotifier(); }

    @Bean
    @Profile("local")
    Notifier smsNotifier() { return new SmsNotifier(); }
}


