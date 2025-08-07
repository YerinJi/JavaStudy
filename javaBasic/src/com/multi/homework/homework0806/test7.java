package com.multi.homework.homework0806;

import java.util.HashSet;
import java.util.Set;
/// hashCode() : 객체의 해시값 반환
/// equals() : 실제 내용이 같은지 확인
public class test7 {
    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();
        set.add(new Member("Tom", 10));
        set.add(new Member("Tom", 10));
        System.out.println(set.size()); // ?
    }
    //new Member로 새로운 객체를 생성했기 때문에 둘이 같지(==) 않다고 인식한다.
    //만약 이 코드에서 중복 제거를 하려면 Member 클래스에서 equals()와 hashCode() 재정의가 필요하다.
}
