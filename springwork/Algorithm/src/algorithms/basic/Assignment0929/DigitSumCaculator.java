package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class DigitSumCaculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("정수를 입력해주세요: ");
        int n=sc.nextInt();
        int digit = 0;
        while(n != 0){
            digit += n%10;

            if(n / 10 == 0)
                System.out.print(n%10);
            else
                System.out.print(n%10 + " + ");
            n/=10;

        }
        System.out.println(" = " + digit);
    }
}
