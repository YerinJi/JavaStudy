package com.multi.homework.homework0801;

public class Motorcycle extends Vehicle {
    public Motorcycle(String name, int year) {
        super.brand = name;
        super.year = year;
    }

    @Override
    public void printInfo(){
        System.out.println("브랜드 : " + brand + ", 년식: " + year);
    }
}
