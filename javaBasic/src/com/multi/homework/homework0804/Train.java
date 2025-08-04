package com.multi.homework.homework0804;

public class Train extends Transport  {
    public Train(String id, int capacity) {
        super(id, capacity);
    }


    @Override
    public boolean reserveSeat() {
        if(capacity > 0){
            capacity--;
            System.out.println(id + " 기차 좌석 예약 완료");
            return true;
        } else{
            System.out.println(id + " 기차 좌석 매진");
        }
        return false;
    }
}
