package com.multi.homework.homework0724;

import java.util.Scanner;

public class HomeworkEx1 {

    Scanner sc = new Scanner(System.in);
    public void grade(){
        System.out.print("점수를 입력하세요: ");
        int score = sc.nextInt();
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : (score >= 60) ? "D" : (score >= 0)  ? "F" : "0~100사이의 점수를 입력해주세요.";
        System.out.println("당신의 등급은 " + grade + "입니다.");
    }

    public static void main(String[] args) {
        HomeworkEx1 hw = new HomeworkEx1();
        hw.grade();
    }
}
