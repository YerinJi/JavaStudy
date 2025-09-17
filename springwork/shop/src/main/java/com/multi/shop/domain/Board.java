package com.multi.shop.domain;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Board {
    private int id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
    private int views;
}