package com.multi.homework0724;

import java.util.Scanner;

public class HomeworkEx4 {

    public String findValue(){
        int random = 88;
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        boolean answer = false;
        while(!answer){
            System.out.print("숫자를 추측해보세요 (1~100) : ");
            int n = sc.nextInt();
            if(n > random) {
                System.out.println("더 작은 수 입니다.");
                cnt++;
            } else if(n < random){
                System.out.println("더 큰 수 입니다.");
                cnt++;
            } else{
                cnt++;
                System.out.println("정답입니다! 시도 횟수: "+cnt+"회");
                answer = true;
            }

        }
        return "";
    }

    public static void main(String[] args) {
        HomeworkEx4 h = new HomeworkEx4();
        h.findValue();

    }
}
