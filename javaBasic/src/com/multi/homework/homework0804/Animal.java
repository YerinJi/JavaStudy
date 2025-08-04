package com.multi.homework.homework0804;

public abstract class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("먹이를 먹는다.");
    }
    public abstract void makeSound();
}
