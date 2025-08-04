package com.multi.object.abstractobj;

public abstract class Device {
    String name;
    public Device(String name){
        this.name = name;
    }

    void boot(){
        System.out.println(name + " 부팅 중...");
    }
    abstract void run(); //추상 메서드
}
