package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력해주세요: ");
        int n = sc.nextInt();
        int n2 = n;
        int sum = 0;
        while(n2 != 0){
            int digit =  n2 % 10;
            sum += digit * digit * digit;
            n2 /= 10;
        }
        if(sum == n){
            System.out.println("암스트롱 수입니다.");
        }
        else{
            System.out.println("암스트롱 수가 아닙니다.");
        }
    }
}
