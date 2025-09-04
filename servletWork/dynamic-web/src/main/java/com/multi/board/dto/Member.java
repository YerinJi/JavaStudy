package com.multi.board.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private LocalDateTime createdAt;
}
