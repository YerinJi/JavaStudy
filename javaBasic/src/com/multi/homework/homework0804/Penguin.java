package com.multi.homework.homework0804;

public class Penguin extends Animal implements Swimmable{
    public Penguin(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + "의 울음소리: 꽥꽥");
    }

    @Override
    public void swim() {
        System.out.println(name + "이 헤엄칩니다.");
    }
}
