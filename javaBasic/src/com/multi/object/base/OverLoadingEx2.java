package com.multi.object.base;

public class OverLoadingEx2 {

    //인자의 순서가 달라도 가능하다
    public void print(int x){
        System.out.println("print:"+x);
    }
    public void print(long xx){
        System.out.println("print:"+xx);
    }
    public void print(int x, long xx){
        System.out.println("print int long:");
    }
    public void print(long x, int xx){
        System.out.println("print long int");
    }

    public static void main(String[] args) {
        OverLoadingEx2 o = new OverLoadingEx2();
//        o.print(100,200);
    }
}
