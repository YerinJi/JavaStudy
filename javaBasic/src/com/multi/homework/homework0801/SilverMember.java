package com.multi.homework.homework0801;

public class SilverMember extends Member{

    public SilverMember(String name, int p) {
        super.name = name;
        super.point = p;
    }

    public void upgradePoint(int amount) {
        int bonus = (int)(amount * 1.2);
        point += bonus;
        System.out.println(name + "님(실버)의 포인트가 " + bonus + "만큼 증가. 현재 포인트: " + point);
    }
    public void upgradePoint(String event, int amount) {
        int bonus = (int)(amount * 2);
        point += bonus;
        System.out.println(event + "혜택 지급!" +name + "님(실버)의 포인트가 " + bonus + "만큼 증가. 현재 포인트: " + point);
    }
    @Override
    public int getDiscountedPrice(int price) {
        return (int)(price*0.95);
    }

    @Override
    public void welcomeMessage() {
        System.out.println("Silver 등급 " + name + "님 환영합니다.");
    }
}
