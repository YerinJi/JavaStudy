package com.multi.springboot.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Board {
    private int id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
    private int views;
    public String getCreatedAtStr() {
        return (createdAt == null)
                ? ""
                : createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
