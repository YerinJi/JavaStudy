package com.multi.homework.homework0804;

public class PartTimeEmployee extends Employee implements BonusReceivable {
    double bonus;

    public PartTimeEmployee(String name, int baseSalary, double v) {
        super(name, baseSalary);
        this.bonus = 0;
    }

    @Override
    public void printSalarySlip() {
        super.printSalarySlip();
    }

    @Override
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary*0.5 + bonus;
    }
}
