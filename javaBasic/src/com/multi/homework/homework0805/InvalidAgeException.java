package com.multi.homework.homework0805;

import java.util.Scanner;

public class InvalidAgeException extends Exception{

    public InvalidAgeException() {
        super("유효하지 않은 나이입니다:");
    }

    public static void main(String[] args) {
        InvalidAgeException ie = new InvalidAgeException();
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 입력: ");
        int age = sc.nextInt();
        if(age < 0){
            try{
                throw new InvalidAgeException();
            }catch(Exception e){
                ie.printStackTrace();
            }
        }

    }
}
