package com.multi.board.service;

import com.multi.board.dto.Member;

public interface MemberService {
    Member join(String username, String rawPassword, String nickname);
    Member login(String username, String rawPassword);
    Member findById(long id);
}
