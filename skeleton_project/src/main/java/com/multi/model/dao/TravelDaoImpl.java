package com.multi.model.dao;

import com.multi.model.bean.TravelVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelDaoImpl implements TravelDao{
    private final Connection conn;

    public TravelDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int createTravel(String district, String title, String description, String address, String phone) throws SQLException {
        String query = "INSERT INTO travel(district,title,description,address,phone) VALUES (?,?,?,?,?)";
        try( PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, district);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, address);
            ps.setString(5, phone);
            int rows = ps.executeUpdate();
            return rows;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<TravelVO> findAll(int page, int pageSize) throws SQLException {
        String query = "SELECT * FROM travel ORDER BY no ASC LIMIT ? OFFSET ?";
        int offset = (page - 1) * pageSize;

        List<TravelVO> travels = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    travels.add(allRow(rs));
                }
            }
        }
        return travels;
    }

    @Override
    public List<TravelVO> searchDistrict(String district) throws SQLException {
        String query = "SELECT * FROM travel WHERE district LIKE ?";

        List<TravelVO> travels = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, district);
            try (ResultSet rs = ps.executeQuery()){

                while (rs.next()){
                    travels.add(allRow(rs));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return travels;
    }

    @Override
    public List<TravelVO> search(String keyword) throws SQLException {
        String like = "%" + keyword + "%";
        String query = "SELECT * FROM travel " +
                "WHERE title LIKE ? OR description LIKE ? OR address LIKE ? ";
        try (PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1, like);
            ps.setString(2, like);
            ps.setString(3, like);
            try (ResultSet rs = ps.executeQuery()){
                List<TravelVO> travels = new ArrayList<>();
                while (rs.next()) travels.add(allRow(rs));
                return travels;
            }
        }
    }

    @Override
    public int update(int no, String district, String title, String description, String address, String phone) throws SQLException {
        String query = "UPDATE travel SET district=?, title=?, description=?, address=?, phone=? WHERE no=?";
        try(PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, district);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setInt(6, no);
            return ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int no) throws SQLException {
        String sql = "DELETE FROM travel WHERE no=?";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, no);
            return ps.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private TravelVO allRow(ResultSet rs) throws SQLException {
        TravelVO v = new TravelVO();
        v.setNo(rs.getInt("no"));
        v.setDistrict(rs.getString("district"));
        v.setTitle(rs.getString("title"));
        v.setDescription(rs.getString("description"));
        v.setAddress(rs.getString("address"));
        v.setPhone(rs.getString("phone"));
        return v;
    }
}
