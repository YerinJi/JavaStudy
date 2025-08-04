package com.multi.homework.homework0804;

public class EmployeeMain {
    public static void main(String[] args) {
        HRSystem hr = new HRSystem();
        hr.addEmployee(new FullTimeEmployee("Alice", 3000));
        hr.addEmployee(new PartTimeEmployee("Bob", 2000, 0.5));
        hr.addEmployee(new Intern("Charlie", 1000));

        System.out.println("=== 보너스 지급 전 ===");
        hr.printAllSalary();
        System.out.println("총 급여: " + hr.calculateTotalSalary());

        hr.BonusOX(500);

        System.out.println("\n=== 보너스 지급 후 ===");
        hr.printAllSalary();
        System.out.println("총 급여: " + hr.calculateTotalSalary());

    }
}
