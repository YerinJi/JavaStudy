package com.multi.object.abstractobj;

public class LoginScreen extends Screen{
    void init(){
        System.out.println("로그인 UI 준비");
    }
    void render(){
        System.out.println("로그인 화면 그리기");
    }
    void cleanup(){
        System.out.println("자원 정리");
    }
}
