package com.multi.model.dao;

import com.multi.model.bean.TravelVO;

import java.sql.SQLException;
import java.util.List;

public interface TravelDao {
    int createTravel(String district, String title, String description, String address, String phone) throws SQLException;

    List<TravelVO> findAll(int page, int pageSize) throws SQLException;

    List<TravelVO> searchDistrict(String district) throws SQLException;

    List<TravelVO> search(String keyword) throws SQLException;

    int update(int no, String district, String title, String description, String address, String phone) throws SQLException;

    int delete(int no) throws SQLException;
}
