package com.multi.homework.homework0804;

public class ReservationSystem {
    Transport[] transports = new Transport[3];
    int count = 0;

    public void addTransport(Transport t) {
        transports[count] = t;
        count++;
    }

    // 사용자 ID로 비행기 온라인 예약
    public void reserveFlightOnline(String userId) {
        for(Transport t : transports){
            if(t instanceof OnlineReservable){
                if(((OnlineReservable) t).reserveOnline(userId)){
                    return;
                }
            }
        }
    }

    public void printAllStatus() {
        for(Transport t : transports){
            if(t != null){
                t.printStatus();
            }

        }
    }

    public void reserveBusSeat(String id) {
        for(Transport t : transports){
            if(t.id == "버스"){
                t.reserveSeat();
            }
        }
    }
    public void reserveTrainSeat(String id) {
        for(Transport t : transports){
            if(t.id == "기차"){
                t.reserveSeat();
            }
        }
    }
}
