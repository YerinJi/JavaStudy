package com.multi.object.abstractobj;

public class Laptop extends Device{
    public Laptop(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println(name + "에서 IntelliJ 실행!");
    }
}
