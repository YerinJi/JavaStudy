package com.multi.board.dao;
import com.multi.board.dto.Member;
import com.multi.board.util.DB;
import java.sql.*;

public class MemberDao {
    public boolean existsByUsername(String username) throws SQLException {
        String sql="SELECT 1 FROM members WHERE username=?";
        try (Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, username); try(ResultSet rs=ps.executeQuery()){ return rs.next(); }
        }
    }
    public long insert(Member m) throws SQLException {
        String sql="INSERT INTO members(username,password,nickname) VALUES(?,?,?)";
        try (Connection c=DB.getConnection();
             PreparedStatement ps=c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,m.getUsername()); ps.setString(2,m.getPassword()); ps.setString(3,m.getNickname());
            ps.executeUpdate(); try(ResultSet k=ps.getGeneratedKeys()){ return k.next()? k.getLong(1):0L; }
        }
    }
    public Member findByUsername(String username) throws SQLException {
        String sql="SELECT id,username,password,nickname,created_at FROM members WHERE username=?";
        try (Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, username); try(ResultSet rs=ps.executeQuery()){
                if(!rs.next()) return null; Member m=new Member();
                m.setId(rs.getLong("id")); m.setUsername(rs.getString("username"));
                m.setPassword(rs.getString("password")); m.setNickname(rs.getString("nickname"));
                Timestamp t=rs.getTimestamp("created_at"); if(t!=null) m.setCreatedAt(t.toLocalDateTime()); return m;
            }
        }
    }
    public Member findById(long id) throws SQLException {
        String sql="SELECT id,username,password,nickname,created_at FROM members WHERE id=?";
        try (Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setLong(1, id); try(ResultSet rs=ps.executeQuery()){
                if(!rs.next()) return null; Member m=new Member();
                m.setId(rs.getLong("id")); m.setUsername(rs.getString("username"));
                m.setPassword(rs.getString("password")); m.setNickname(rs.getString("nickname"));
                Timestamp t=rs.getTimestamp("created_at"); if(t!=null) m.setCreatedAt(t.toLocalDateTime()); return m;
            }
        }
    }
}
