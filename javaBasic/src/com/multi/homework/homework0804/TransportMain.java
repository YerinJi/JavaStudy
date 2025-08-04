package com.multi.homework.homework0804;

public class TransportMain {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();

        system.addTransport(new Bus("버스", 2));
        system.addTransport(new Train("기차", 3));
        system.addTransport(new Flight("비행기", 2));

        System.out.println("--좌석 현황--");
        system.printAllStatus();

        System.out.println("\n--온라인 비행기 예약--");
        system.reserveFlightOnline("yerin6428");
        System.out.println("\n--버스 예약--");
        system.reserveBusSeat("hello12");
        system.reserveTrainSeat("hihi");
        System.out.println("\n--좌석 현황--");
        system.printAllStatus();
    }
}
