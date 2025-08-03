package com.multi.homework.homework0801;

public class GoldMember extends Member{

    public GoldMember(String name, int point) {
        super.name = name;
        super.point = point;
    }

    public void upgradePoint(int amount) {
        int bonus = (int)(amount * 1.5);
        point += bonus;
        System.out.println(name + "님(골드)의 포인트가 " + bonus + "만큼 증가. 현재 포인트: " + point);
    }
    public void upgradePoint(String event, int amount) {
        int bonus = (int)(amount * 2);
        point += bonus;
        System.out.println(event + "혜택 지급!" +name + "님(골드)의 포인트가 " + bonus + "만큼 증가. 현재 포인트: " + point);
    }
    @Override
    public int getDiscountedPrice(int price) {
        return (int)(price*0.75);
    }
    @Override
    public void welcomeMessage() {
        System.out.println("Gold 등급 " + name + "님 환영합니다.");
    }
}
