package com.multi.homework.homework0801;

public class Member {
    String name;
    int point;

    public Member() {
    }

    public Member(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public void upgradePoint(int amount) {
        int bonus = amount;
        point += bonus;
        System.out.println(name + "님의 포인트가 " + bonus + "만큼 증가. 현재 포인트: " + point);
    }

    public void upgradePoint(String event, int amount) {
        int bonus = amount * 2;
        point += bonus;
        System.out.println(event + "혜택 지급!" +name + "님의 포인트가 " + bonus + "만큼 증가. 현재 포인트: " + point);
    }

    public int getDiscountedPrice(int price){
        return  price;
    }

    public void welcomeMessage(){
        System.out.println("환영합니다.");
    }

}
