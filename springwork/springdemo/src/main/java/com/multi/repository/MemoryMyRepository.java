package com.multi.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MemoryMyRepository implements MyRepository {

//    public static void main(String[] args) {
//        //업캐스팅, 다형성
//        MyRepository myRepository = new MemoryMyRepository();
//    }


    @Override
    public String getMessage(String name) {
        return "Hello, " + name;
    }
}
