package com.multi.shop.service;

import com.multi.shop.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> findAll();
    void save(Board board);
    Board findById(int id);
    void update(Board board);
    void delete(int id);
}