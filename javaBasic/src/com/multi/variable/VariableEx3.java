package com.multi.variable;

public class VariableEx3 {
    public static void main(String[] args) {
        System.out.println("Byte Min~Max" + Byte.MIN_VALUE + "~" + Byte.MAX_VALUE);
        System.out.println("Character Min~Max" + Character.MIN_VALUE + "~" + Character.MAX_VALUE);
        System.out.println("Double Min~Max" + Double.MIN_VALUE + "~" + Double.MIN_VALUE);
        System.out.println("Float Min~Max" + Float.MIN_VALUE + "~" + Float.MAX_VALUE);
        System.out.println("Integer Min~Max" + Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
        System.out.println("Long Min~Max" + Long.MIN_VALUE + "~" + Long.MAX_VALUE);
        System.out.println("Short Min~Max" + Short.MIN_VALUE + "~" + Short.MAX_VALUE);

        byte byteValue=5;
        short shortValue=50;
        //  byteValue = shortValue; 큰 바이트에서 작은 바이트로 이동 불가...
        shortValue = byteValue;

        //변수 ( 지역변수, 인스턴스변수, 정적변수(Static) )
    }
}
