package com.multi.homework.homework0804;

public class FullTimeEmployee extends Employee implements BonusReceivable {
    double bonus;
    public FullTimeEmployee(String name, int baseSalary) {
        super(name, baseSalary);
        this.bonus = 0;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void printSalarySlip() {
        super.printSalarySlip();
    }

    @Override
    public void setBonus(double bonus) {
        this.bonus = (int) bonus;
    }
}
