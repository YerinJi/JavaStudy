package com.multi.homework.homework0731;

public class Student {
    public String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void main(String[] args) {
        Student s = new Student("민수",90);
        System.out.println("이름: " + s.getName() +", 점수: " + s.getScore());
    }
}
