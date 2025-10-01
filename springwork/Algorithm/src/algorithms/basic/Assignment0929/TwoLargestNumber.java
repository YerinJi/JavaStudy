package algorithms.basic.Assignment0929;

import java.util.Scanner;

public class TwoLargestNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("5개의 정수를 입력해주세요");
        int[] list =new int[5];
        for(int i=0;i<5;i++){
            list[i]=sc.nextInt();
        }
        for(int j=0;j<4;j++){
            for(int i=j;i<list.length;i++){
                if(list[i]>list[j]){
                    int temp =  list[i];
                    list[i]=list[j];
                    list[j]=temp;
                }
            }
        }
        System.out.println("최대값: " + list[0] +", 두 번째 최대값: " + list[1]);
    }
}
