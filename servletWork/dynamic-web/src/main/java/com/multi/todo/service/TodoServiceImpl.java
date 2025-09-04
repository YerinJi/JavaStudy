package com.multi.todo.service;

import com.multi.todo.dao.TodoDao;
import com.multi.todo.dao.TodoDaoImpl;
import com.multi.todo.dto.Todo;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class TodoServiceImpl implements TodoService {

    private final TodoDao dao;

    public TodoServiceImpl() { this.dao = new TodoDaoImpl(); }
    public TodoServiceImpl(TodoDao dao) { this.dao = dao; }

    @Override
    public List<Todo> list(String q, String status, String category, String priority,
                           String due, String sort, String order) throws SQLException {
        return dao.findAll(q, status, category, priority, due, sort, order);
    }

    @Override
    public Todo view(long id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public long write(String title, String description, String category,
                      int priority, String status, Timestamp dueAt) throws SQLException {
        Todo t = new Todo();
        t.setTitle(title);
        t.setDescription(description);
        t.setCategory(category);
        t.setPriority(priority);
        t.setStatus(status);
        t.setDueAt(dueAt);
        return dao.insert(t);
    }

    @Override
    public boolean edit(long id, String title, String description, String category,
                        int priority, String status, Timestamp dueAt) throws SQLException {
        Todo t = new Todo();
        t.setId(id);
        t.setTitle(title);
        t.setDescription(description);
        t.setCategory(category);
        t.setPriority(priority);
        t.setStatus(status);
        t.setDueAt(dueAt);
        return dao.update(t) > 0;
    }

    @Override
    public boolean toggleStatus(long id) throws SQLException {
        Todo cur = dao.findById(id);
        if (cur == null) return false;
        String next = switch (cur.getStatus() == null ? "TODO" : cur.getStatus().toUpperCase()) {
            case "TODO" -> "DOING";
            case "DOING" -> "DONE";
            case "DONE" -> "TODO";
            default -> "TODO";
        };
        return dao.updateStatus(id, next) > 0;
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return dao.delete(id) > 0;
    }
}
