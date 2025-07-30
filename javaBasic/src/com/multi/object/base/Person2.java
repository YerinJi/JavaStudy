package com.multi.object.base;

public class Person2 {
    private String name;
    private int age;
    private String address;

    public void setName(Person2 this, String name) {
        System.out.println("this="+this);
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public static void main(String[] args) {
        Person2 p1 = new Person2(); //메모리 힙에 name|age|address 가 만들어진다.
        Person2 p2 = new Person2(); //name|age|address
        System.out.println("p1=" + p1);
        System.out.println("p2=" + p2);
        p1.setName("지예린");
        p2.setName("김태희");

    }
}
