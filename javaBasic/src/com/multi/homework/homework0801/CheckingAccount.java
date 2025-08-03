package com.multi.homework.homework0801;

public class CheckingAccount extends Account {
    public CheckingAccount(String name, int money) {
        super.balance = money;
        super.owner = name;
    }


    @Override
    public void withdraw(int money) {
        int mm = 500;
        int total = money + mm;
        if(balance >= total){
            balance -= total;
            System.out.println(money + "원 출금 완료 (수수료 500원). 잔액 : "+balance);
        } else {
            System.out.println("잔액 부족입니다.");
        }
    }




}
