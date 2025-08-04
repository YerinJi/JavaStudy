package com.multi.homework.homework0804;

public class TV extends ElectronicDevice implements RemoteControllable{
    int volume;
    public TV(String brand) {
        super(brand);
        this.volume = 0;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    @Override
    public void turnOn() {
        super.power = true;
        System.out.println("TV ON");
    }

    @Override
    public void turnOff() {
        super.power = false;
        System.out.println("TV OFF");
    }

    @Override
    public void setVolume(int volume) {
        if(volume<0 || volume>100){
            System.out.println("볼륨 범위는 0~100입니다.");
            return;
        }
        this.volume = volume;
        System.out.println(brand + " TV 볼륨 : " + volume);

    }
}
