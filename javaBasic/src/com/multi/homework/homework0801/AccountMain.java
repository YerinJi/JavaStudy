package com.multi.homework.homework0801;

public class AccountMain {
    public static void main(String[] args) {
        Account[] accounts = new Account[2];
        accounts[0] = new SavingAccount("지예린",5000);
        accounts[1] = new CheckingAccount("홍길동",9000);

        accounts[0].withdraw(500);
        accounts[0].deposit(2000);

        accounts[1].withdraw(900);
        accounts[1].deposit(3500);

        System.out.println("--- 최종 잔액 ---");
        for(Account account:accounts){
            account.printBalance();
        }
    }
}
