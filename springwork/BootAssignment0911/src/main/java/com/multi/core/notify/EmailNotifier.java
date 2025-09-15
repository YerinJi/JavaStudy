package com.multi.core.notify;

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("EMAIL : " + message);
    }

    @Override
    public String getChannel() {
        return "Email";
    }
}
