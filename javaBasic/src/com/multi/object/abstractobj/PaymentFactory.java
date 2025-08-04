package com.multi.object.abstractobj;

public abstract class PaymentFactory {
    abstract Payment create();

    void process(int amount){
        Payment p = create();
        p.pay(amount);
    }
}
