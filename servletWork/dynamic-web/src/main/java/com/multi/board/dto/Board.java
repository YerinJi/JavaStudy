package com.multi.board.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private int id;
    private String title;
    private String content;
    private int writerId;
    private String writerNickname;
    private int viewCnt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
