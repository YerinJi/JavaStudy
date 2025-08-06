package com.multi.object.util;

public class UtilEx2 {
    //String, StringBuffter, StringBuilder 차이점
    public void stringExecute1(){
        String str1="abc";
        String imsi=str1;
        str1+= "def"; //String은 final이라 수정이 불가능하기 때문에 새로운 메모리에 abcdef를 만든다.
        System.out.println(str1==imsi); //false final이라서?
    }
    public void stringExecute2(){
        StringBuffer sb = new StringBuffer("abc");
        StringBuffer imsi = sb;

        sb.append(89)
                .append("jkjk")
                .append("ooo");

        sb.deleteCharAt(0);
        System.out.println(sb);
//        System.out.println(sb==imsi); //true
    }

    public void stringExecute3(){
        StringBuilder sb = new  StringBuilder("abc");
        sb.append("def").append("g");
        System.out.println(sb);
        sb.deleteCharAt(0);
        System.out.println(sb);
    }

    public void stringExecute4(){
//        String string = new String("abc");
//        System.out.println(string.charAt(0));
//
//        StringBuffer sb = new StringBuffer("abc");
//        System.out.println(sb.charAt(0));
//
//        StringBuilder sb2 = new StringBuilder("abc");
//        System.out.println(sb2.charAt(0));

        CharSequence cs = new String("");
        cs.charAt(0);
        cs=new StringBuilder("abc");
        cs.charAt(0);
        cs=new StringBuilder("def");

    }

    public static void main(String[] args) {
        UtilEx2 utilEx2 = new UtilEx2();
        utilEx2.stringExecute4();
    }
}
