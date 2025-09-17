package com.multi.shop.service;


import com.multi.shop.domain.Board;
import com.multi.shop.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    @Override
    public void save(Board board) {
        boardMapper.save(board);
    }

    @Override
    public Board findById(int id) {
        return boardMapper.findById(id);
    }

    @Override
    public void update(Board board) {
        boardMapper.update(board);
    }

    @Override
    public void delete(int id) {
        boardMapper.delete(id);
    }
}