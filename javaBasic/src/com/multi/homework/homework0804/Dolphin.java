package com.multi.homework.homework0804;

public class Dolphin extends Animal implements Swimmable{
    public Dolphin(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + "의 울음소리 ");
    }

    @Override
    public void swim() {
        System.out.println(name + "가 헤엄칩니다.");
    }
}
