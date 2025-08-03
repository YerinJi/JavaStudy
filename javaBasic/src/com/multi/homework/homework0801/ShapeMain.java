package com.multi.homework.homework0801;

public class ShapeMain {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle("원",3);
        shapes[1] = new Rectangle("사각형", 5,4);
        shapes[2] = new Triangle("삼각형", 5, 8);

        for (Shape shape : shapes) {
            shape.printInfo();
        }
    }
}
