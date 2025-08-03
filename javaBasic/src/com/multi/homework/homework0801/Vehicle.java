package com.multi.homework.homework0801;

public class Vehicle {
    String brand;
    int year;
    public void startEngine(){
        System.out.println("시동을 걸었습니다.");
    }

    public void startEngine(String keycode){
        System.out.println(keycode + "키로 시동을 걸었습니다.");
    }
    public void startEngine(String name, int time){
        System.out.println(name + "님이 " + time + "시에 시동을 걸었습니다.");
    }


    public void printInfo(){
        System.out.println("브랜드 : " + brand + ", 년식: " + year);
    }
}
