package com.multi.designpattern;

//Factory Pattern
/*
    팩토리패턴은 객체를 생성하는 인터페이스를 정의하되, 어떤 클래스의 인스턴스를 생성할지는 서브클래스에서
    결정하도록 하는 디자인 패턴이다.
    - 객체 생성의 세부사항을 캡슐화-> 클라이언트 코드와 객체 생성 로직 분리
    - 코드의 유연성과 확장성을 높이는데 유용
    - 팩토리 패턴은 주로 단순 팩토리, 팩토리 메소드, 추상 팩토리의 세가지 주요 변형이 있다.

    백엔드 개발자 : 확장성과 유연성 중요
    users.findAll();
 */


//제품 인터페이스
interface Product{
    void use();
}

//구체적인 제품 클래스들
class ProductA implements Product{
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

class ProductB implements Product{
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

//팩토리 클래스
class SimpleFactory{
    public static Product createProduct(String type){
        if(type.equals("A")){
            return new ProductA();
        } else if(type.equals("B")){
            return new ProductB();
        }
        throw new IllegalArgumentException("UnKnown product type");
    }
}

// 사용 예
public class FactoryMain {
    public static void main(String[] args) {
        Product product = SimpleFactory.createProduct("A");
        product.use();
    }
}


