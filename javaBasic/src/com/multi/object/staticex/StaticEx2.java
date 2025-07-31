package com.multi.object.staticex;

public class StaticEx2 {
    static final int value = 99;
    int data;
    public void message(){
        int data=0;
        //this.value = 88; final변수는 상수이다 그러므로 error가 난다
        System.out.println(data);
//        value++;
        this.data = 66;
        this.data = 88;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

    }
}
