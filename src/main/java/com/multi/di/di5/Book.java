package com.multi.di.di5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//getter, setter, toString
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String bookName;
    private int price;
    private String author;
    private String publisher;
    //생성자 다음으로 호출되는 함수
    public void init(){
        System.out.println("init");
    }
    public void destroy(){
        System.out.println("destroy");
    }
}
