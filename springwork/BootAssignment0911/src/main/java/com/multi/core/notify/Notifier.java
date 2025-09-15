package com.multi.core.notify;

public interface Notifier {
    void send(String message);
    String getChannel();
}
