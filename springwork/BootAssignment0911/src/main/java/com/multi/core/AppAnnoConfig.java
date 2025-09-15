package com.multi.core;

import com.multi.core.discount.DiscountPolicy;
import com.multi.core.discount.FixDiscountPolicy;
import com.multi.core.discount.RateDiscountPolicy;
import com.multi.core.notify.EmailNotifier;
import com.multi.core.notify.Notifier;
import com.multi.core.notify.SmsNotifier;
import com.multi.core.time.SystemTimeProvider;
import com.multi.core.time.TimeProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Profile("anno")
@Configuration
@ComponentScan(basePackages = "com.multi.core")
@PropertySource("classpath:application.properties")
public class AppAnnoConfig {
        @Bean
        public TimeProvider timeProvider() {
            return new SystemTimeProvider("yyyy-MM-dd HH:mm:ss");
        }


        @Bean
        @Primary
        public DiscountPolicy rateDiscountPolicy(@Value("${discount.rate:10}") int rate) {
            return new RateDiscountPolicy(rate);
        }


        @Bean
        public DiscountPolicy fixDiscountPolicy(@Value("${discount.fix:1000}") int amount) {
            return new FixDiscountPolicy(amount);
        }


        @Bean @Profile("prod")
        public Notifier emailNotifier() { return new EmailNotifier(); }


        @Bean @Profile("local")
        public Notifier smsNotifier() { return new SmsNotifier(); }
}
