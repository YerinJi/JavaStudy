package com.multi.homework.homework0806;
// 오토박싱 : 기본형을 wrapper 객체로 자동 변환해주는 것
// 언박싱 : wrapper 객체를 기본형으로 변환해주는 것
public class Calculator {
    public int add(Integer x, Integer y) {
        return x + y;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.add(null, null);
    }
}

// NullPointerException 이 일어난다.
// Integer는 참조형 즉, 주소값을 가져야하므로 null을 가질 수 있지만, add메서드에서 객체 x와 y의 값을 가져오기 위해 .intValue()를 사용해서
// 연산을 수행하려하므로 nullPointerException이 발생한다.
// <해결 방법>
// 1. add(int x, int y) 로 수정한다. Integer -> int 로 수정
// 2. 입력 값이 null일 때의 예외 처리를 하기 위해 IllegalArgumentException(메서드의 전달 인수가 잘못된경우 예외) 를 throw 를 사용해서
// if( x == null || y==null) throw new IllegalArgumentException("null 입력 x") 이런식으로 코드를 넣어준다.
