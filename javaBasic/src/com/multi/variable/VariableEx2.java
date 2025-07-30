package com.multi.variable;
//ctrl+alt+l (정렬)

public class VariableEx2 {
    public static void main(String[] args) {
        //기본형 byte<short<int<long <flot<double
        byte byteValue = 10;// -128~ 127
        System.out.println("byteValue");//"byteValue
        System.out.println(byteValue);//10 <stack>

        short shortValue;//0~65536 (-32768~32767)
        shortValue = 32767;

        int intValue = Integer.MAX_VALUE;
        System.out.println("intValue=" + intValue);

        long longValue = Long.MAX_VALUE;
        System.out.println("longValue=" + longValue);

        float floatValue = (float) 10.5;//형변환
        double doubleValue = 10.5;
        char charValue = 'A';
        System.out.println(charValue);
        System.out.println((int) charValue);

        charValue = 48;
        System.out.println(charValue);
    }
}
