package com.multi.homework.homework0804;

public class Zookeeper {


    public static void main(String[] args) {
        Animal[] animal = new Animal[3];
        animal[0] = new Lion("사자", 15);
        animal[1] = new Penguin("펭귄",16);
        animal[2] = new Dolphin("돌고래",20);

        for(Animal a:animal){
            System.out.println("이름 : " + a.name + ", 나이 : " + a.age);
            a.makeSound();
            if(a instanceof Swimmable){
                ((Swimmable) a).swim();
            } else if(a instanceof Walkable){
                ((Walkable) a).walk();
            }
        }
    }
}
