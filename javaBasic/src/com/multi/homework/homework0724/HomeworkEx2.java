package com.multi.homework.homework0724;

import java.util.Scanner;

public class HomeworkEx2 {

    Scanner sc = new Scanner(System.in);

    public int caculator() {
        System.out.print("두 개의 정수를 입력하세요 : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a + " " + b);
        while (true) {
            System.out.println("1. 덧셈\t2. 뺄셈\t3. 곱셈\t4. 나눗셈\t5. 종료");
            System.out.print("수행할 연산을 선택하세요 : ");
            int input = sc.nextInt();
            if (input < 1 || input > 5) {
                System.out.println("잘못된 선택입니다.");
            }
            switch (input) {
                case 1:
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case 2:
                    System.out.println(a + " - " + b + " = " + (a - b));
                    break;
                case 3:
                    System.out.println(a + " * " + b + " = " + (a * b));
                    break;
                case 4:
                    if (a == 0 || b == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                    } else {
                        System.out.println(a + " / " + b + " = " + (a / b));
                    }
                    break;
                case 5:
                    return 0;
            }
        }

    }

    public static void main(String[] args) {
        HomeworkEx2 hw = new HomeworkEx2();
        hw.caculator();

    }
}
