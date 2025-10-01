package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class MultipleCounter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("정수 N을 입력해주세요: ");
        int n=sc.nextInt();
        System.out.print("정수 K를 입력해주세요: ");
        int k=sc.nextInt();
        int cnt = 0;
        int[] cntList=new int[n/k];
        for(int i=1;i<=n;i++){
            if(i%k==0){
                cntList[cnt++] = i;
            }
        }
        System.out.print("1부터 "+n +"까지의 숫자 중 " + k +"의 배수의 개수: " + cnt + "개( ");
        for(int i=0;i<cnt;i++){
            System.out.print(cntList[i] +" ");
        }
        System.out.print(")");
    }
}
