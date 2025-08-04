package com.multi.homework.homework0804;

public abstract class ElectronicDevice {
    String brand;
    boolean power;

    public ElectronicDevice(String brand) {
        this.brand = brand;
        this.power = false;
    }

    public void displayInfo(){
        if(power == true){
            System.out.println(brand + ": 전원이 켜져있습니다.");
        } else{
            System.out.println(brand + ": 전원이 꺼져있습니다.");
        }
    }

}
