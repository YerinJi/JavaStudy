package com.multi.object.lang;

public class StringApp1 {
    private int value;
    public StringApp1(int value) {
        this.value = value;
        int x;
    }

    public int strValue(int data){
        data++;
        data*=4;
        this.value=data;
        return data;
    }

    public static void main(String[] args) {
        String str1= new String("hello");
        StringApp1 s1 = new StringApp1(1000);
        s1.strValue(100);

        System.out.println(str1.length());

    }
}
