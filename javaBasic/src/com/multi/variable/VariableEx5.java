package com.multi.variable;
//JAVA는 객체지향언어

public class VariableEx5 {

    short value; //인스턴스 변수, 멤버변수 heap이라는 곳에 할당
    boolean isCheck;
    static int staticData;
    //속성 + 기능
    public void sayMethod(){ //method
        int localSay = 100; //지역변수 stack에 저장
    }
    public void eatMehthod(){
        isCheck = true;
    }

    public static void main(String[] args) {
        VariableEx5 v = new VariableEx5();
        v.value = 99;
//        value = 99; 접근불가
        staticData = 45;
    }
}
