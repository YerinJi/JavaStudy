package com.multi.object.abstractobj;

public class DeviceMain {
    public static void main(String[] args) {
        Device myLaptop = new Laptop("삼성 노트북");
        myLaptop.boot();
        myLaptop.run();
    }
}
