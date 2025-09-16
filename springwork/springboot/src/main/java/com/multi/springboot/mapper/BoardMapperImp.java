package com.multi.springboot.mapper;

import com.multi.springboot.model.Board;

import java.util.List;

public class BoardMapperImp implements BoardMapper {
    @Override
    public List<Board> getAllBoards() {
        return List.of();
    }

    @Override
    public Board getBoardById(int id) {
        return null;
    }

    @Override
    public void insertBoard(Board board) {

    }

    @Override
    public void updateBoard(Board board) {

    }

    @Override
    public void deleteBoard(int id) {

    }

    @Override
    public void incrementViews(int id) {

    }

    @Override
    public int count(String q, String type) {
        return 0;
    }

    @Override
    public List<Board> find(String q, String type, int offset, int limit) {
        return List.of();
    }
}
