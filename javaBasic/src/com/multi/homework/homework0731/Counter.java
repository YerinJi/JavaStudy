package com.multi.homework.homework0731;

public class Counter {
    static int count;

    public Counter() {
        count++;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        System.out.println("총 객체 수: " + count);
    }
}
