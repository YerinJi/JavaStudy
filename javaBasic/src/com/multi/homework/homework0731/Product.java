package com.multi.homework.homework0731;

import java.util.Scanner;

public class Product {
    Scanner sc = new Scanner(System.in);
    private String pname;
    private int price;;

    public void ProductAdd(Product[] arr){
        for(int i=0;i<3;i++){
            arr[i] = new Product();
            System.out.println("상품명을 입력해주세요: ");
            arr[i].setPname(sc.nextLine());
            System.out.println(arr[i].pname + "의 가격을 입력해주세요: ");
            arr[i].setPrice(sc.nextInt());
            sc.nextLine(); //sc.nextInt는 \n을 버리지 않기 때문에 다음 상품명이 스킵되는 문제가 발생하기 때문에 이 코드를 써주었다.
        }
    }

    public void print(Product[] arr){
        for(int i=0; i<3; i++){
            System.out.println("상품명: " + arr[i].getPname() + ", 가격: "+ arr[i].getPrice());
        }
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Product p = new Product();
        Product[] arr =  new Product[3];
        p.ProductAdd(arr);
        p.print(arr);


    }
}
