package com.multi.homework.homework0804;

public class Flight extends Transport implements OnlineReservable {
    public Flight(String id, int capacity) {
        super(id, capacity);
    }

    @Override
    public boolean reserveOnline(String userId) {
        System.out.println(userId + "님 온라인 예약이 진행됩니다.");
        reserveSeat();
        return false;
    }

    @Override
    public boolean reserveSeat() {
        if(capacity > 0){
            capacity--;
            System.out.println(id + " 비행기 좌석 예약 완료");
            return true;
        } else{
            System.out.println(id + " 비행기 좌석 매진");
        }
        return false;
    }

}
