package com.multi.todo.service;

import com.multi.todo.dto.Todo;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface TodoService {
    List<Todo> list(
            String q, String status, String category, String priority,
            String due, String sort, String order
    ) throws SQLException;

    Todo view(long id) throws SQLException;

    long write(String title, String description, String category,
               int priority, String status, Timestamp dueAt) throws SQLException;

    boolean edit(long id, String title, String description, String category,
                 int priority, String status, Timestamp dueAt) throws SQLException;

    boolean toggleStatus(long id) throws SQLException;

    boolean delete(long id) throws SQLException;
}
