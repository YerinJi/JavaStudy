package com.multi.object.util;

import java.util.*;

public class UtilEx7 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); //list 고정데이터로 변환 추가, 삭제 불가능
        System.out.println(list);
//      list.add(6); //error 발생 Arrays.asList (고정형으로 변환되어서)

        //섞기
        Collections.shuffle(list);
        System.out.println(list);

        //역순
        Collections.reverse(list);
        System.out.println(list);

        //최대 최소값
        System.out.println("Max:" + Collections.max(list));
        System.out.println("Min:" + Collections.min(list));
    }
}
