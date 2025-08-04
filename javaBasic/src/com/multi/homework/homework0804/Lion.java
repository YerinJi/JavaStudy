package com.multi.homework.homework0804;

public class Lion extends Animal implements Walkable{
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + "의 울음소리: 어흥 ");
    }

    @Override
    public void walk() {
        System.out.println(name + "가 걸어갑니다.");
    }
}
