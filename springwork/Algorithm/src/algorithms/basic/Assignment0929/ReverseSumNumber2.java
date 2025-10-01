package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class ReverseSumNumber2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("첫번째 정수를 입력해주세요: ");
        int a = sc.nextInt();
        System.out.print("두번째 정수를 입력해주세요: ");
        int b = sc.nextInt();
        int reverseA = 0;
        int reverseB = 0;
        while(a != 0 && b !=0){
            int digitA = a%10;
            int digitB = b%10;
            reverseA = reverseA * 10 + digitA;
            reverseB = reverseB * 10 + digitB;
            a=a/10;
            b=b/10;
        }
        System.out.println(reverseA + " + "+ reverseB + " = " + (reverseA + reverseB));

    }
}
