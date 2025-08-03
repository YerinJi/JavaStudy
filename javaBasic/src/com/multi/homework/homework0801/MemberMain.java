package com.multi.homework.homework0801;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("김영희", 2500);
        Member silver = new SilverMember("지예린",2500);
        Member gold = new GoldMember("홍길동", 2500);
        Member platinum = new PlatinumMember("김철수", 2500);

        member.welcomeMessage();
        silver.welcomeMessage();
        gold.welcomeMessage();
        platinum.welcomeMessage();

        member.getDiscountedPrice(10000);
        silver.getDiscountedPrice(10000);
        gold.getDiscountedPrice(10000);
        platinum.getDiscountedPrice(10000);

        member.upgradePoint(3000);
        silver.upgradePoint(3000);
        gold.upgradePoint(3000);
        platinum.upgradePoint(3000);

        member.upgradePoint("여름 이벤트",1500);
        silver.upgradePoint("여름 이벤트",1500);
        gold.upgradePoint("여름 이벤트",1500);
        platinum.upgradePoint("여름 이벤트",1500);

    }
}
