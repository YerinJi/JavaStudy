package com.multi.object.abstractobj;

public class ConsoleLogger extends LoggerStrategy {
    void log(String msg) {
        System.out.println("콘솔 로그: " + msg);
    }
}
