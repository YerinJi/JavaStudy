package com.multi.homework.homework0731;

public class Calculator {

    public Calculator(int a, int b) {
        System.out.println(a + " + " + b + " = " + add(a, b));
        System.out.println(a + " - " + b + " = " + subtract(a, b));
    }

    public int add(int a, int b){
        return a+b;
    }
    public int subtract(int a, int b){
        return a-b;
    }
    public void print(){

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(10,5);
    }
}
