package com.multi.model.service;

import com.multi.model.bean.TravelVO;

import java.sql.SQLException;
import java.util.List;

public interface TravelService {
    List<TravelVO> getAllPage(int page, int pageSize) throws SQLException;

    List<TravelVO> getDistrictPage(String district) throws SQLException;

    List<TravelVO> searchKeyword(String keyword) throws SQLException;

    int createTravel(String district, String title, String description, String address, String phone) throws SQLException;

    int updateTravel(int no, String district, String title, String description, String address, String phone) throws SQLException;

    int deleteTravel(int no) throws SQLException;
}
