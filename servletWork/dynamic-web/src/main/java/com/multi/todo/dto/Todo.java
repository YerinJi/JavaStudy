package com.multi.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private long id;
    private String title;
    private String description;
    private String category;
    private int priority;       // 1~5
    private String status;      // TODO/DOING/DONE
    private Timestamp dueAt;    // nullable
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
