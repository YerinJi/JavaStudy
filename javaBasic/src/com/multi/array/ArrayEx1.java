package com.multi.array;

import java.util.Scanner;

//배열이란? 같은 기억장소의 모임
public class ArrayEx1 {
    Scanner sc = new Scanner(System.in);
    public void arrayCreateEx1() {
        String str = null;
        do {
            System.out.println("Node Count?");
            int count = sc.nextInt();
            int[] m = new int[count];

            for (int i = 0; i < m.length; i++) {
                if (i % 5 == 0) System.out.println();
                System.out.printf("%d\t", m[i]);
            }
            System.out.println("계속하겠습니까? yes|no");
            str = sc.next();
        }while(str.equals("yes"));
//        for(int i=0; i<m.length; i++){
//            System.out.println(i + "번째 배열에 넣을 값:");
//            m[i] = sc.nextInt();
//        }
//
//        for (int i=0; i<m.length; i++)
//            System.out.printf("%d\t",m[i]);
    }

    public static void main(String[] args) {
        ArrayEx1 a = new ArrayEx1();
        a.arrayCreateEx1();

    }
}
