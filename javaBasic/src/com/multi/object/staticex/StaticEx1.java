package com.multi.object.staticex;

public class StaticEx1 {
    int inum;
    static int sNum;
    public void increment(){
        int localNum=0;
        localNum++; //지역변수 증가
        this.inum++;
        StaticEx1.sNum++; //클래스 로딩시 단 한번만 생성
        System.out.println("localNum:"+localNum + " inum:"+inum + " sNum:"+sNum);
    }
    public static void main(String[] args) {
        StaticEx1 s1 = new StaticEx1();
        s1.increment();
        s1.increment();
    }
}
