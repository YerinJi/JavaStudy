package com.multi.board.service;

import com.multi.board.dto.Board;
import com.multi.board.dto.PageRequest;
import com.multi.board.dto.PageResult;

public interface BoardService {
    PageResult<Board> list(PageRequest pr, String type, String q);
    Board view(long id); // 조회수 + 상세
    long write(String title, String content, long writerId);
    void edit(long id, String title, String content, long loginMemberId);
    void remove(long id, long loginMemberId);
}
