package com.multi.variable;

public class VariableEx4 {
    //인스턴스 메소드, 메모리에 올라가 있지 않음 , new를 사용해야 메모리에 만듬
    public void byteValue(){
        byte byteGab = 10;
        System.out.println("byteValueMethod Call");
    }
    public void shortValue(){
        //byteGab=20; 메소드 안에서는 지역변수로 접근 불가
        System.out.println("shortValueMethod Call");
    }
    public static void main(String[] args) {
        int i=10;
        VariableEx4 a = new VariableEx4();
        a.byteValue();
        a.shortValue();
    }
}
