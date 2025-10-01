package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class PyramidNumber1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("값을 입력하세요:");
        int input = sc.nextInt();
        int n = input;
        for(int i = 1; i<= n; i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" "); //공백
            }
            for(int k=1;k<=i;k++){ //숫자
                System.out.print(k);
            }
            for(int l=i-1; l>=1;l--){
                System.out.print(l);
            }
            System.out.println();
        }

    }
}
