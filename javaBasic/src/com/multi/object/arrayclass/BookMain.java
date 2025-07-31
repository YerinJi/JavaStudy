package com.multi.object.arrayclass;

public class BookMain {





    public static void main(String[] args) {
        Book []book = {new Book(1,"java다","저자1","출판사1"),
                new Book(2,"HTML이다","저자2","출판사2"),
                new Book(3,"SPRING이다","저자3","출판사3"),
                new Book(4,"DOCKER다","저자4","출판사4")
        };

        for(Book b:book){
            System.out.println(b); //b는 book 객체 4개 .toString()생략되어있음.
        }
    }
}
