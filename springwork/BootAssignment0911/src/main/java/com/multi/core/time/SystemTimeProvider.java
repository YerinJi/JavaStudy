package com.multi.core.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemTimeProvider implements TimeProvider {
    private final DateTimeFormatter nowTime;

    public SystemTimeProvider(String pattern) {
        this.nowTime = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public String nowFormatted() {
        return now().format(nowTime);
    }

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
