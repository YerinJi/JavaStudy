package com.multi.object.base;

public class PersonMain {

    public static void main(String[] args) {
        new Person().name = "hellohello"; //private로 속성을 정의한 외부 속성은 가져올수없음.
    }
}
