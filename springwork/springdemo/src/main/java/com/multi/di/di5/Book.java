package com.multi.di.di5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//getter,setter,toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String bookName;
    private int price;
    private String author;
    private String publisher;
    //생서장 다음으로 호출되는 함수
    public void init(){
        System.out.println("init");
    }
    //종료되는 싯점에 호출...
    public void destroy(){

    }
}
