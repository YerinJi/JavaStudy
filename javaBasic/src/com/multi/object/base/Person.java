package com.multi.object.base;

public class Person {
    public String name; //속성, 데이터, 필드
    private int age;

    public static void main(String[] args) {
//        int x=100; //지역변수, 기본형
//        boolean y= x<100;
//
//        int []m = new int[5];
        Person p1 =  new Person();
        Person p2 =  new Person();

        p1.name = "Java";
        p2.name="C";
        new Person().age=50;
        System.out.println(new Person().age); //0 new 쓸때마다 객체가 새로 생성되기 때문
    }
}
