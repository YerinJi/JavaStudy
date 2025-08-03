package com.multi.homework.homework0801;

public class Account {
    int balance;
    String owner;

    public void deposit(int money){
        balance += money;
        System.out.println(money + "원 입금 완료. 잔액 : " + balance);
    }

    public void deposit(int money, String date){
        balance += money;
        System.out.println(date + "에 "+money + "원 입금 완료. 잔액 :");
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", owner='" + owner + '\'' +
                '}';
    }

    public void withdraw(int money){
        if(balance >= money){
            balance -= money;
            System.out.println(money + "원 출금 완료. 잔액 : " + balance);
        } else{
            System.out.println("잔액 부족입니다.");
        }
    }

    public void printBalance(){
        System.out.println(owner + "님의 계좌 총 잔액 : " + balance);
    }
}
