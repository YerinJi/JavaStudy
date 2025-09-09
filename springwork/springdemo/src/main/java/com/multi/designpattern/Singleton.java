package com.multi.designpattern;

public class Singleton {
    //static 정적 요소
    private static Singleton instance;

    //생성자
    private Singleton() {

    }
    //필요할 때 인스턴스를 생성
    public static Singleton getInstance() {
        if (instance == null) { //싱글턴이다. == instance가 null이다.
            instance = new Singleton();
        }
        return instance;
    }
}
