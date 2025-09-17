package com.multi.bookmanagement.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private LocalDateTime createdAt;
    public String getCreatedAtString() {
        return (createdAt == null) ? "": createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

}
