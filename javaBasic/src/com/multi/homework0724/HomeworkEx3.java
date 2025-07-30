package com.multi.homework0724;

import java.util.Scanner;

public class HomeworkEx3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수 입력 :");
        int n = sc.nextInt();
        int m = (n+1) / 2;
        for (int i = 1; i <= m; i++) {
            for(int j = 1; j <= m-i; j++){
                System.out.print(" ");
            }
            for(int j =1; j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < m; i++) {
            for(int j = 1; j <= i; j++){
                System.out.print(" ");
            }
            for(int k =1; k<=n-(i*2) ;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
