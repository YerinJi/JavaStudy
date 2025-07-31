package com.multi.homework.homework0731;

public class BankAccount {
    private int money;

    public BankAccount(int money) {
        this.money = money;
    }

    public void deposit(int money) {
        this.money += money;
    }
    public void withdraw(int money){
        this.money -= money;
    }

    public static void main(String[] args) {
        BankAccount[] account1 = {new BankAccount(20000),
        new BankAccount(30000),
        new BankAccount(40000),};
        account1[0].withdraw(5000);
        account1[1].deposit(5000);
        int sumMoney = 0;
        for (BankAccount account : account1) {
            sumMoney += account.money;
        }
        System.out.println("계좌 잔액 합계: " + sumMoney + "원");


    }
}
