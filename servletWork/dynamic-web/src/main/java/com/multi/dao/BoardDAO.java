package com.multi.dao;

import com.multi.config.MyBatisUtil;
import com.multi.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardDAO {
    public List<BoardDTO> getAllBoards() {
        try (SqlSession s = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return s.selectList("com.multi.dao.BoardDAO.getAllBoards");
        }
    }
    public BoardDTO getBoardById(int id) {
        try (SqlSession s = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return s.selectOne("com.multi.dao.BoardDAO.getBoardById", id);
        }
    }
    public int insertBoard(BoardDTO b) {
        try (SqlSession s = MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            return s.insert("com.multi.dao.BoardDAO.insertBoard", b);
        }
    }
    public int updateBoard(BoardDTO b) {
        try (SqlSession s = MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            return s.update("com.multi.dao.BoardDAO.updateBoard", b);
        }
    }
    public int deleteBoard(int id) {
        try (SqlSession s = MyBatisUtil.getSqlSessionFactory().openSession(true)) {
            return s.delete("com.multi.dao.BoardDAO.deleteBoard", id);
        }
    }
}

