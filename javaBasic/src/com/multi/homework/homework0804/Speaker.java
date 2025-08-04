package com.multi.homework.homework0804;

public class Speaker extends ElectronicDevice implements RemoteControllable{
    int volume;
    public Speaker(String brand) {
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
        System.out.println("Speaker ON");
    }

    @Override
    public void turnOff() {
        super.power = false;
        System.out.println("Speaker OFF");
    }

    @Override
    public void setVolume(int volume) {
        if(volume<0 || volume>100){
            System.out.println("볼륨 범위는 0~100입니다.");
            return;
        }
        this.volume = volume;
        System.out.println(brand + " Speaker 볼륨 : " + volume);
    }
}
