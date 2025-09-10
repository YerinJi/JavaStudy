package com.multi.di.di5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "state")
@Scope(value = "singleton")
public class BookStore {
// 원래 자바의 순서는 field 다음이 생성자로 되어 있어서 b1이 초기화 되고 후에 생성자가 불려져서 b2가 나와야하지만,
    // StringBean의 순서는 생성자 --> field --> method로 되어있어서 결과적으로 b1이 불려진다.
    @Autowired
    @Qualifier(value = "b1") //field
    private Book book; //BookStore는 Book을 의존하는 설계를 하고있다.

    public BookStore() {
    }

    @Autowired
    public BookStore( Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "book=" + book +
                '}';
    }
}
