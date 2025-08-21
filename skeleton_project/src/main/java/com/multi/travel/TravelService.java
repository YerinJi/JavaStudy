package com.multi.travel;

import java.sql.SQLException;
import java.util.List;

public class TravelService {
    private TravelDAO dao = new TravelDAO();

//    1. 전체 페이지
    public List<TravelVO> getAllPage(int page, int pageSize) throws SQLException {
        return dao.findAll(page,pageSize);
    }
//    2. 권역별 전체 목록 (권역 입력)
    public List<TravelVO> getDistrictpage(String district) throws SQLException {
        return dao.searchDistrict(district);
    }
//    3. 키워드 검색 (제목/주소/설명)
    public List<TravelVO> searchKeyword(String keyword) throws SQLException {
        return dao.search(keyword);
    }
//    4. 새 관광지 등록
    public int createTravel(String district, String title, String description, String address, String phone){
        return dao.createTravel(district,title,description,address,phone);
    }
//    5. 관광지 수정
    public int updateTravel(int no, String district, String title, String description, String address, String phone)throws SQLException{
        return dao.update(no,district,title,description,address,phone);
    }
//    6. 관광지 삭제
    public int  deleteTravel(int no) throws SQLException {
        return dao.delete(no);
    }

}
