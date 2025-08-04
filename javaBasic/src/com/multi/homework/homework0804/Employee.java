package com.multi.homework.homework0804;

public abstract class Employee {
    String name;
    int baseSalary;

    public Employee(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
    public void printSalarySlip(){
        System.out.println(name + "님의 급여 : " + calculateSalary() + "원");
    }
}
