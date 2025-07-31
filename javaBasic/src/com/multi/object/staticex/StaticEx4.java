package com.multi.object.staticex;

public class StaticEx4 {
    private int value;
    private int num;
    private String str;
    static private double count;

    public void increment(){
        this.count++;
    }
    public void message(){
        System.out.println(this.count);
    }

    public static void main(String[] args) {
        StaticEx4 staticEx4 = new StaticEx4();
        StaticEx4 staticEx5 = new StaticEx4();
        staticEx4.increment();
        staticEx5.increment();
        staticEx5.increment();
        staticEx4.message();
        staticEx5.message();
    }
}
