package com.multi.model.service;

import com.multi.model.bean.TravelVO;
import com.multi.model.dao.TravelDao;
import com.multi.model.dao.TravelDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TravelServiceImpl implements TravelService {
    private final TravelDao dao;

    public TravelServiceImpl(Connection conn) {
        this.dao = new TravelDaoImpl(conn);
    }

    @Override
    public List<TravelVO> getAllPage(int page, int pageSize) throws SQLException {
        return dao.findAll(page, pageSize);
    }

    @Override
    public List<TravelVO> getDistrictPage(String district) throws SQLException {
        return dao.searchDistrict(district);
    }

    @Override
    public List<TravelVO> searchKeyword(String keyword) throws SQLException {
        return dao.search(keyword);
    }

    @Override
    public int createTravel(String district, String title, String description, String address, String phone) throws SQLException {
        return dao.createTravel(district, title, description, address, phone);
    }

    @Override
    public int updateTravel(int no, String district, String title, String description, String address, String phone) throws SQLException {
        return dao.update(no, district, title, description, address, phone);
    }

    @Override
    public int deleteTravel(int no) throws SQLException {
        return dao.delete(no);
    }
}
