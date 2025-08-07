package com.multi.homework.homework0806;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class test4 {
    public static String transform(String input){
        //.trim() 문자열 좌우 공백제거
        StringBuilder sb = new StringBuilder(input.trim());
        sb.reverse();

        Set<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < sb.length(); i++){
            char c= sb.charAt(i);
            if(set.add(c)){ //set은 중복값을 가질수없다. c가 추가된다면 true로, if문 실행
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String abc = transform(" banana ");
        System.out.println(abc);
    }
}
