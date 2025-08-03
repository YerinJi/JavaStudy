package com.multi.homework.homework0801;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Hyundai",2025);
        vehicles[1] = new Bus("kia",2024);
        vehicles[2] = new Motorcycle("multi",2022);

        for (Vehicle vehicle : vehicles) {
            vehicle.printInfo();
            vehicle.startEngine();
            vehicle.startEngine("key123");
            vehicle.startEngine("지예린",8);
            System.out.println();
        }
    }
}
