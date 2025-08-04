package com.multi.homework.homework0804;

public class HRSystem {
    Employee[] employees = new Employee[5];
    int count = 0;

    public void addEmployee(Employee employee) {
        if(count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("직원 수용 한도가 초가되었습니다.");
        }
    }

    public double calculateTotalSalary() {
        double total = 0;
        for(Employee e:employees){
            if( e != null ) {
                total += e.calculateSalary();
            }

        }
        return total;
    }

    public void BonusOX(double bonus){
        for(Employee e:employees){
            if(e instanceof BonusReceivable){
                ((BonusReceivable) e).setBonus(bonus);
            }
        }
    }

    public void printAllSalary(){
        for(Employee e:employees){
           if(e instanceof BonusReceivable){
               e.printSalarySlip();
           }
        }
    }
}
