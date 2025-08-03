package com.multi.homework.homework0801;

public class Circle extends Shape {
    double radius = 3;

    public Circle(String name , double r) {
        super.name = name;
        radius = r;
    }

    double area(){
        return 3.14*radius*radius;
    }
    double area(double r){
        return 3.14 * r * r;
    }

    @Override
    public void printInfo() {
        System.out.println(name + "의 넓이: " + area());
    }
}
