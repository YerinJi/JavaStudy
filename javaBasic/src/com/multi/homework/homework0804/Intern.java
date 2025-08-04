package com.multi.homework.homework0804;

public class Intern extends Employee {

    public Intern(String name, int baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

}
