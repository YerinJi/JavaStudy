package algorithms.basic;

import java.util.Scanner;

public class NumberPyramid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("층수를 입력하세요");
        int n=in.nextInt();
        for(int i=1;i<=n;i++){ //행
            for(int j=1;j<=n-i;j++){//열 공백
                System.out.print(" ");
            }
            for(int k=1;k<=(2*i-1);k++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}