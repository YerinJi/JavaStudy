package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class GeometricSumCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 항(A), 공비(R), 항의 개수(N)를 입력해주세요");
        System.out.print("첫 번째 항(A) : ");
        int a = sc.nextInt();
        System.out.print("공비(R) : ");
        int r = sc.nextInt();
        System.out.print("항의 개수(N) : ");
        int n = sc.nextInt();
        int sum = a;
        System.out.print(a + " + ");
        for(int i=1;i<n;i++){
            int t = 1;
             for(int j=1;j<=i;j++){
                 t *= r;
             }
             sum += a*t;
             if(i==n-1){
                 System.out.print(t + " = "+sum);
             } else{
                 System.out.print(t + " + ");
             }

        }
    }
}
