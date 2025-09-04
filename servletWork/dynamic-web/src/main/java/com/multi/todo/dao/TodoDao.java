package com.multi.todo.dao;

import com.multi.todo.dto.Todo;
import java.sql.SQLException;
import java.util.List;

public interface TodoDao {
    long insert(Todo t) throws SQLException;
    int  update(Todo t) throws SQLException;
    int  delete(long id) throws SQLException;

    Todo findById(long id) throws SQLException;

    List<Todo> findAll(
            String q, String status, String category, String priority,
            String due, String sort, String order
    ) throws SQLException;

    int  updateStatus(long id, String nextStatus) throws SQLException;
}
