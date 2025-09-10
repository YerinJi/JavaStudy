package com.multi.di.di5;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/*
선언부가 메소드보다 우선순위가  높아서 나중인 book1이 출력된다.
 */
@Component(value="bookstore2")
public class BookStore2 {

    @Resource(name = "book2")
    private Book book; //선언부

    public BookStore2() {
    }

    public BookStore2(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    @Resource(name = "book1")
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookStore2{" +
                "book=" + book +
                '}';
    }
}
