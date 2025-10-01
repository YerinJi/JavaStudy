package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class ConditionalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요: ");
        int n = sc.nextInt();
        int[] list=new int[n];
        int cnt = 0;
        int sum = 0;
        for(int i = 1; i< n; i++){
            if(i%3==0 || i%5==0){
                list[cnt]=i;
                sum+=i;
                cnt++;
            }

        }
        for(int i=0;i<=cnt;i++){
            if(i == cnt-1){
                System.out.print(list[i] + " = "+sum);
                break;
            }
            System.out.print(list[i] + " + ");
        }

    }
}
