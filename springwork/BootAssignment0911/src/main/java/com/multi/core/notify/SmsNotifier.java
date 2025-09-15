package com.multi.core.notify;

public class SmsNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("SMS : " + message);
    }

    @Override
    public String getChannel() {
        return "SMS";
    }
}
