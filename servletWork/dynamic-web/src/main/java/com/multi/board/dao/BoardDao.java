package com.multi.board.dao;
import com.multi.board.dto.Board;
import com.multi.board.dto.PageRequest;
import com.multi.board.util.DB;
import java.sql.*;
import java.util.*;

public class BoardDao {

    public int count(String type, String q) throws SQLException {
        StringBuilder sql=new StringBuilder("SELECT COUNT(*) FROM board b");
        List<Object> params=new ArrayList<>();
        if(q!=null && !q.isBlank()){
            switch (type){
                case "writer": sql.append(" JOIN members m ON m.id=b.writer_id WHERE m.nickname LIKE ?"); break;
                case "content": sql.append(" WHERE b.content LIKE ?"); break;
                default: sql.append(" WHERE b.title LIKE ?");
            }
            params.add("%"+q+"%");
        }
        try(Connection c=DB.getConnection(); PreparedStatement ps=c.prepareStatement(sql.toString())){
            for(int i=0;i<params.size();i++) ps.setObject(i+1, params.get(i));
            try(ResultSet rs=ps.executeQuery()){ rs.next(); return rs.getInt(1); }
        }
    }

    public List<Board> findAll() throws SQLException {
        Connection conn= DB.getConnection();
        PreparedStatement ps=conn.prepareStatement("SELECT * FROM board");
        ResultSet rs=ps.executeQuery();
        List<Board> list=new ArrayList<>();
        while(rs.next()){
            Board board=new Board();
            board.setId(rs.getInt("id"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            list.add(board);
        }
        return list;
    }

    public Board findById(long id) throws SQLException {
        Connection conn =  DB.getConnection();
        PreparedStatement ps=conn.prepareStatement("SELECT * FROM board WHERE id = ?");
        ps.setLong(1,id);
        ResultSet rs=ps.executeQuery();
        Board board=new Board();
        while(rs.next()){
            board.setId(rs.getInt("id"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            return  board;
        }
        return null;
    }

    public void insert(Board b) throws SQLException {
        Connection conn = DB.getConnection();
        PreparedStatement ps =  conn.prepareStatement("INSERT INTO board (title,content) VALUES (?,?)");
        ps.setString(1, b.getTitle());
        ps.setString(2, b.getContent());
        ps.executeUpdate();
    }

    public void update(Board b, long writerId) throws SQLException {
        String sql="UPDATE board SET title=?, content=? WHERE id=? AND writer_id=?";
        try(Connection c=DB.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,b.getTitle());
            ps.setString(2,b.getContent());
            ps.setLong(3,b.getId());
            ps.setLong(4,writerId);
            ps.executeUpdate();
        }
    }

    public void delete(long id, long writerId) throws SQLException {
        String sql="DELETE FROM board WHERE id=? AND writer_id=?";
        try(Connection c=DB.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)){
            ps.setLong(1,id);
            ps.setLong(2,writerId);
            ps.executeUpdate();
        }
    }

    /** 조회수 + 상세를 한 트랜잭션으로 처리 */
    public Board viewAndIncrease(long id) throws SQLException {
        String up="UPDATE board SET view_cnt=view_cnt+1 WHERE id=?";
        String sel="SELECT b.id,b.title,b.content,b.writer_id,b.view_cnt,b.created_at,b.updated_at,m.nickname " +
                "FROM board b JOIN members m ON m.id=b.writer_id WHERE b.id=?";
        try(Connection c=DB.getConnection()){
            c.setAutoCommit(false);
            try(PreparedStatement ps1=c.prepareStatement(up)){
                ps1.setLong(1,id);
                ps1.executeUpdate();
            }
            Board b=null;
            try(PreparedStatement ps2=c.prepareStatement(sel)){
                ps2.setLong(1,id);
                try(ResultSet rs=ps2.executeQuery()){
                    if(rs.next()){
                        b=map(rs);
                        b.setWriterNickname(rs.getString("nickname"));
                    }
                }
            }
            c.commit(); return b;
        }
    }

    private Board map(ResultSet rs) throws SQLException {
        Board b = new Board();
        b.setId((int) rs.getLong("id"));
        b.setTitle(rs.getString("title"));
        b.setContent(rs.getString("content"));
        b.setWriterId((int) rs.getLong("writer_id"));
        b.setViewCnt(rs.getInt("view_cnt"));
        Timestamp cAt=rs.getTimestamp("created_at"), uAt=rs.getTimestamp("updated_at");
        if(cAt!=null) b.setCreatedAt(cAt.toLocalDateTime());
        if(uAt!=null) b.setUpdatedAt(uAt.toLocalDateTime());
        return b;
    }
}
