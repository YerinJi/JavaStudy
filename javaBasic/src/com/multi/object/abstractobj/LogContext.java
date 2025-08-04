package com.multi.object.abstractobj;

public class LogContext {
    private LoggerStrategy strategy;

    LogContext(LoggerStrategy strategy) {
        this.strategy = strategy;
    }

    void execute(String msg) {
        strategy.log(msg);
    }
}
