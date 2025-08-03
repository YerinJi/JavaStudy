package com.multi.homework.homework0801;

public class Triangle extends Shape {
    int  base = 15;
    int height = 10;

    public Triangle(String name, int base, int height) {
        super.name = name;
        this.base = base;
        this.height = height;
    }

    int area(){
        return (base * height) /2;
    }

    int area(int b, int h){
        return ( b * h)/2;
    }


    @Override
    public void printInfo() {
        System.out.println(name + "의 넓이: " + area());
    }
}
