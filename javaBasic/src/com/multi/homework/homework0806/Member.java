package com.multi.homework.homework0806;

import java.util.*;

class Member {
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) //같은 객체일 경우
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
