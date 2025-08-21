package com.multi.travel;

import java.sql.*;
import java.util.*;

public class TravelDAO {
    private Connection conn;

    public TravelDAO(Connection conn) {
        this.conn = conn;
    }

//    새로운 관광지 추가
    public int createTravel(String district, String title, String description, String address, String phone) {
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

//    페이지별로 전체 목록을 보여주기
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
//    권역별 관광지 목록 보여주기
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

// keyword 검색결과를 목록으로 보여주기
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

//    데이터 수정하기
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

//    데이터 삭제하기
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
        TravelVO travelVO = new TravelVO();
        travelVO.setNo(rs.getInt("no"));
        travelVO.setDistrict(rs.getString("district"));
        travelVO.setTitle(rs.getString("title"));
        travelVO.setDescription(rs.getString("description"));
        travelVO.setAddress(rs.getString("address"));
        travelVO.setPhone(rs.getString("phone"));
        return travelVO;
    }

}
