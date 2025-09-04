package com.multi.todo.dao;

import com.multi.todo.dto.Todo;
import com.multi.todo.util.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    @Override
    public long insert(Todo t) throws SQLException {
        String sql = "INSERT INTO todo (title, description, category, priority, status, due_at) " +
                "VALUES (?,?,?,?,?,?)";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, t.getTitle());
            if (t.getDescription() == null) ps.setNull(2, Types.VARCHAR); else ps.setString(2, t.getDescription());
            if (t.getCategory() == null) ps.setNull(3, Types.VARCHAR); else ps.setString(3, t.getCategory());
            ps.setInt(4, t.getPriority());
            ps.setString(5, t.getStatus());
            if (t.getDueAt() == null) ps.setNull(6, Types.TIMESTAMP); else ps.setTimestamp(6, t.getDueAt());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getLong(1) : 0L;
            }
        }
    }

    @Override
    public int update(Todo t) throws SQLException {
        String sql = "UPDATE todo SET title=?, description=?, category=?, priority=?, status=?, due_at=? " +
                "WHERE id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, t.getTitle());
            if (t.getDescription() == null) ps.setNull(2, Types.VARCHAR); else ps.setString(2, t.getDescription());
            if (t.getCategory() == null) ps.setNull(3, Types.VARCHAR); else ps.setString(3, t.getCategory());
            ps.setInt(4, t.getPriority());
            ps.setString(5, t.getStatus());
            if (t.getDueAt() == null) ps.setNull(6, Types.TIMESTAMP); else ps.setTimestamp(6, t.getDueAt());
            ps.setLong(7, t.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(long id) throws SQLException {
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE FROM todo WHERE id=?")) {
            ps.setLong(1, id);
            return ps.executeUpdate();
        }
    }

    @Override
    public Todo findById(long id) throws SQLException {
        String sql = "SELECT id,title,description,category,priority,status,due_at,created_at,updated_at " +
                "FROM todo WHERE id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? map(rs) : null;
            }
        }
    }

    @Override
    public List<Todo> findAll(String q, String status, String category, String priority,
                              String due, String sort, String order) throws SQLException {
        StringBuilder sb = new StringBuilder(
                "SELECT id,title,description,category,priority,status,due_at,created_at,updated_at FROM todo");
        List<Object> params = new ArrayList<>();
        List<String> conds = new ArrayList<>();

        if (notBlank(q)) {
            conds.add("(title LIKE ? ESCAPE '\\\\' OR description LIKE ? ESCAPE '\\\\')");
            String like = toLike(q);
            params.add(like); params.add(like);
        }
        if (notBlank(status) && !"all".equalsIgnoreCase(status)) {
            conds.add("status = ?");
            params.add(status.toUpperCase());
        }
        if (notBlank(category)) {
            conds.add("category = ?");
            params.add(category);
        }
        if (notBlank(priority) && !"all".equalsIgnoreCase(priority)) {
            conds.add("priority = ?");
            params.add(Integer.parseInt(priority));
        }
        if (notBlank(due) && !"all".equalsIgnoreCase(due)) {
            switch (due.toLowerCase()) {
                case "overdue" -> conds.add("due_at IS NOT NULL AND due_at < NOW()");
                case "today"   -> conds.add("due_at IS NOT NULL AND due_at >= CURDATE() AND due_at < CURDATE() + INTERVAL 1 DAY");
                case "week"    -> conds.add("due_at IS NOT NULL AND due_at >= CURDATE() AND due_at < CURDATE() + INTERVAL 7 DAY");
            }
        }
        if (!conds.isEmpty()) sb.append(" WHERE ").append(String.join(" AND ", conds));

        String sortCol = switch (safe(sort)) {
            case "dueAt" -> "due_at";
            case "priority" -> "priority";
            default -> "created_at";
        };
        String dir = "asc".equalsIgnoreCase(order) ? "ASC" : "DESC";
        sb.append(" ORDER BY ").append(sortCol).append(" ").append(dir);

        // (선택) 안전 상한: 너무 많아지는 것 방지
        // sb.append(" LIMIT 1000");

        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sb.toString())) {
            int idx = 1;
            for (Object p : params) ps.setObject(idx++, p);
            try (ResultSet rs = ps.executeQuery()) {
                List<Todo> list = new ArrayList<>();
                while (rs.next()) list.add(map(rs));
                return list;
            }
        }
    }

    @Override
    public int updateStatus(long id, String nextStatus) throws SQLException {
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE todo SET status=? WHERE id=?")) {
            ps.setString(1, nextStatus);
            ps.setLong(2, id);
            return ps.executeUpdate();
        }
    }

    /* --------- helpers --------- */
    private static boolean notBlank(String s){ return s != null && !s.isBlank(); }
    private static String safe(String s){ return s==null? "" : s; }
    private static String toLike(String q){
        // %, _ 이스케이프
        String v = q.replace("\\","\\\\").replace("%","\\%").replace("_","\\_");
        return "%" + v + "%";
    }
    private static Todo map(ResultSet rs) throws SQLException {
        Todo t = new Todo();
        t.setId(rs.getLong("id"));
        t.setTitle(rs.getString("title"));
        t.setDescription(rs.getString("description"));
        t.setCategory(rs.getString("category"));
        t.setPriority(rs.getInt("priority"));
        t.setStatus(rs.getString("status"));
        t.setDueAt(rs.getTimestamp("due_at"));
        t.setCreatedAt(rs.getTimestamp("created_at"));
        t.setUpdatedAt(rs.getTimestamp("updated_at"));
        return t;
    }
}
