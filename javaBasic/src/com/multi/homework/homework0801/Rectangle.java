package com.multi.homework.homework0801;

public class Rectangle extends Shape {
    int width = 10;
    int height = 20;

    public Rectangle(String name, int width, int height) {
        super.name = name;
        this.width = width;
        this.height = height;
    }

    int area(){
        return width*height;
    }

    int area(int w, int h){
        return w*h;
    }


    @Override
    public void printInfo() {
        System.out.println(name + "의 넓이: " + area());
    }
}
