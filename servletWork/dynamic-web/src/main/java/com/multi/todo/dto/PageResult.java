package com.multi.todo.dto;

import java.util.List;

public class PageResult<T> {
    private List<T> items;
    private int total; //전체 개수
    private int page; //현재 페이지
    private int size; // 페이지 크기
    private int totalPages; //총 페이지 수
}
