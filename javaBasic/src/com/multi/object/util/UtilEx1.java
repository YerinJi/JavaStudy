package com.multi.object.util;
//util과 관련된 Class
//String, StringBuffer, StringBuilder
//Object( 기능은 모든 객체의 공통기능이다. )
//Collection, Thread
public class UtilEx1{

    public void stringMaker1(){
//        String str = new String(new StringBuffer())
        byte []byteValue = {65,66,67,68,69};
        String strByte = new String(byteValue);
        System.out.println(strByte);
    }

    public void stringMaker2(){
        String str1 = new String("abcdefg");
        System.out.println(str1.charAt(0));
        System.out.println(str1.equals("ABCD"));
        System.out.println(str1.indexOf(97));
        System.out.println(str1.codePointAt(0));

    }

    public static void main(String[] args) {
        UtilEx1 obj = new UtilEx1();
        obj.stringMaker2();
    }
}
