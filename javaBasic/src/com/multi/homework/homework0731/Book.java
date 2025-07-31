package com.multi.homework.homework0731;

public class Book {
    private String title;
    private String author;
    private int price;

    public Book() {
        this.title = "자바의 정석";
        this.author = "남궁성";
        this.price = 30000;
    }

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public String printInfo(){
        return "제목: " + this.title + ", 저자: " + this.author + ", 가격: " + this.price+"원";
    }

    public static void main(String[] args) {
        Book b =  new Book();
        System.out.println(b.printInfo());
    }
}
