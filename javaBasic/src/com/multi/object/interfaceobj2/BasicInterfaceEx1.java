package com.multi.object.interfaceobj2;

public interface BasicInterfaceEx1 {
    //interface는 속성이 상수
    public int publicData=100;
    public static void say(){
        System.out.println("인터페이스에서 static method는 가능합니다.");
    }
    //jdk 8.0부터 가능하다.
    public default void show(){
        System.out.println("show Method");
    }

}
