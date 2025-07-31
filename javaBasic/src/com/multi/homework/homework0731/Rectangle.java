package com.multi.homework.homework0731;

public class Rectangle {
    private int width;
    private int height;

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int rec(){
        return width*height;
    }
    public void print(){
        System.out.println("가로: "+width+", 세로: " + height +",넓이: " + rec());
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setSize(10, 5);
        rectangle.print();
    }
}
