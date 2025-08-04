package com.multi.homework.homework0804;

import com.multi.object.abstractobj.Device;

public class DeviceMain {
    public static void main(String[] args) {
        ElectronicDevice[] device = new ElectronicDevice[3];
        device[0] = new Refrigerator("삼성");
        device[1] = new TV("LG");
        device[2] = new Speaker("APPLE");

        for(ElectronicDevice devices : device){
            devices.displayInfo();
            if(devices instanceof RemoteControllable){
                ((RemoteControllable)devices).turnOn();
            }
            if(devices instanceof RemoteControllable){
                ((RemoteControllable)devices).setVolume(101);
            }
            if(devices instanceof RemoteControllable){
                ((RemoteControllable)devices).turnOff();
            }
            devices.displayInfo();
        }

    }
}
