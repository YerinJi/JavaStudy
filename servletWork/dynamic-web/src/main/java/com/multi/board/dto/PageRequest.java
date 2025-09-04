package com.multi.board.dto;


public class PageRequest {
    private final int page;
    private final int size;
    public PageRequest(int page, int size) {
        this.page = page < 1 ? 1 : page;
        this.size = (size < 1 || size > 100) ? 10 : size;
    }
    public int getPage(){ return page; }
    public int getSize(){ return size; }
    public int getOffset(){ return (page-1)*size; }
}
