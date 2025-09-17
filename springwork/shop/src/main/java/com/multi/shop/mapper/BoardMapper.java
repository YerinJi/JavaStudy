package com.multi.shop.mapper;


import com.multi.shop.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> findAll();
    void save(Board board);
    Board findById(int id);
    void update(Board board);
    void delete(int id);
}