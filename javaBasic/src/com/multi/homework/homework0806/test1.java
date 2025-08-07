package com.multi.homework.homework0806;

public class test1 {
    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println(a == b); // true
        System.out.println(c == d); // false
        System.out.println(a.equals(b)); // true
        System.out.println(c.equals(d)); // true

        // Integer의 캐싱 범위 : -128 ~ 127
        // 캐싱범위를 벗어나지 않은 객체는 같은 값이면 같은 주소를 참조한다.
        // 하지만, 범위를 벗어난 객체는 새로운 객체를 만들어 각각 다른 주소를 참조하므로 c == d가 false가 나왔다.
        // ==는 주소값이 같은지를 확인하는 것이고, .equals는 가지고 있는 값이 같은지를 확인하는 것이다.

    }
}
