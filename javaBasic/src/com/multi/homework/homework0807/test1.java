package com.multi.homework.homework0807;

import java.util.ArrayList;
import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("홍길동", "김영희","이철수"));
        arrayList.remove("김영희");
        System.out.println("회원 목록: "+arrayList);
    }
}
