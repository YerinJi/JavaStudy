package com.multi.object.abstractobj;

public class FileLogger extends LoggerStrategy {
    @Override
    void log(String msg) {
        System.out.println("파일 로그: " + msg);
    }
}
