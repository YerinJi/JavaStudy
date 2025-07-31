package com.multi.object.staticex;

public class StaticEx3Main {


    public static void main(String[] args) {
//        new StaticEx3(); 생성자의 접근제한자가 private인 경우 생성불가
        StaticEx3.getStaticEx3().setValue(100);
        System.out.println(StaticEx3.getStaticEx3().getValue());


    }

}
