package com.multi.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MemoryMyRepository implements MyRepository {


//    public static void main(String[] args) {
//        //UpCastring,DownCastring,Polymorphism
//        MyRepository myRepository = new MemoryMyRepository();
//    }

        @Override
        public String getMessage(String name) {
            return "Hello, " + name;
        }


}