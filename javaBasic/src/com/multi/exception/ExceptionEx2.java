package com.multi.exception;

import java.util.Scanner;

public class ExceptionEx2 {
    Scanner sc = new Scanner(System.in);
    //다형성, 업캐스팅, 다운캐스팅IllegalAccessException
    public void classCastExceptionExample(Object obj){ //Object obj=new String("Hello")
        if(obj instanceof String)
            System.out.println(((String)obj).charAt(0)); //downcast해서 String 메소드호출
        if(obj instanceof Integer){
            System.out.println(((Integer)obj).intValue());
        }
    }
    public void IllegalArgumentException(){
        System.out.println("Age:");
        int age = sc.nextInt();
        if(age < 0){
            throw new IllegalArgumentException("나이는 양수만 가능합니다.");
        }
        System.out.println("Age:"+age);
    }
    public static void main(String[] args) {
        ExceptionEx2 e = new ExceptionEx2();
        e.IllegalArgumentException();
//        e.classCastExceptionExample(new String("hello"));
//        e.classCastExceptionExample(5);
//        Object obj = new String("hello");

    }
}