package com.multi.homework.homework0806;

import java.util.List;
//리팩토링 : 동작은 동일하게 유지하면서, 코드 구조를 개선하는 작업
public class test5 {
    public static String joinWords(List<String> words){
        StringBuilder sb = new StringBuilder();
//        String result = ""; String은 final 변수 이기 때문에 += 연산으로 word를 추가할때마다 새로운 String객체를 생성한다.
//        StringBuilder는 새로운 객체를 사용하지않고 누적시켜 추가하기 때문에 메모리를 감소시킬수있다.

        for(String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
