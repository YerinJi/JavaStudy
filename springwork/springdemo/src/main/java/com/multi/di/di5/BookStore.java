package com.multi.di.di5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "state")
@Scope(value = "singleton")
public class BookStore {

    //원래 자바의 순서는 Field 다음이  생성자로 되어 있어서 b1이 di되고 후에 생성자가 불려져서 b2가 나와야 하지만
    //StringBean의 순서는  생성자--->Field---->Method로 되어있어서  결과적으로
    @Autowired
    @Qualifier("b1")//field
    private  Book book;//BookStore는 Book을 의존하는 설계...

    public BookStore() {
    }
    @Autowired
    public BookStore(@Qualifier("b2") Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "book=" + book +
                '}';
    }
}
