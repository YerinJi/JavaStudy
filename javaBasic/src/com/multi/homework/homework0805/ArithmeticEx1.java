package com.multi.homework.homework0805;

import java.util.Scanner;

public class ArithmeticEx1 {
    Scanner sc = new Scanner(System.in);
    public void arithmeticExceptionEx1(){
        try{
            System.out.print("첫 번째 정수 입력: ");
            int a = sc.nextInt();
            System.out.print("두 번째 정수 입력: ");
            int b = sc.nextInt();
            System.out.println(a/b);
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }finally{
            System.out.println("계산 종료");
        }
    }


    public static void main(String[] args) {
        ArithmeticEx1 ae = new ArithmeticEx1();
        ae.arithmeticExceptionEx1();
    }
}
