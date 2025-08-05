package com.multi.homework.homework0805;

public class NullpointerEx1 {

    public static void main(String[] args) {
        try{
            String str = null;
            str.length();
        }catch(NullPointerException e){
            System.out.println("문자열이 null입니다.");
        }
    }
}
