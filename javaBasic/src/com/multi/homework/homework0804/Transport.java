package com.multi.homework.homework0804;

public abstract class Transport {
    String id;
    int capacity;

    public Transport(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public abstract boolean reserveSeat();

    public void printStatus(){
        System.out.println(id + " 남은 좌석 수: " + capacity);
    }
}
