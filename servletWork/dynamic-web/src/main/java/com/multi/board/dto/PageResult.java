package com.multi.board.dto;


import java.util.List;

public class PageResult<T> {
    private final List<T> items;
    private final int total;
    private final int page;
    private final int size;

    public PageResult(List<T> items, int total, int page, int size) {
        this.items = items;
        this.total = total;
        this.page = page;
        this.size = size;
    }

    public List<T> getItems(){return items;}
    public int getTotal(){return total;}
    public int getPage(){return page;}
    public int getSize(){return size;}
    public int getTotalPages(){return total;}
    public boolean isHasPrev(){return page>1;}
    public boolean isHasNext(){return page<total;}
}
