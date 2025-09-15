package com.multi.core.time;

import java.time.LocalDateTime;

public interface TimeProvider {
    String nowFormatted();
    LocalDateTime now();
}
