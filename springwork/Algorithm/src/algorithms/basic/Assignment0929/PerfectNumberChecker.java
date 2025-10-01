package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class PerfectNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력해주세요: ");
        int input = sc.nextInt();
        int sum = 0;
        for(int i = 1; i < input; i++){
            if(input % i == 0){
                sum += i;
            }
        }
        if(sum == input){
            System.out.println("완벽한 숫자입니다.");
        }
        else{
            System.out.println("완벽한 숫자가 아닙니다.");
        }
    }
}
