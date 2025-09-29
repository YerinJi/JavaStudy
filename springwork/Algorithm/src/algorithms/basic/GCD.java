package algorithms.basic;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("First number:");
        int a = in.nextInt();//12
        System.out.println("Second number:");
        int b = in.nextInt();//18
        while(b!=0){      //
            int temp=b;      //temp=b=18
            b=a%b;          //b=a%b  12%18=12
            a=temp;         //a=temp  18
        }//while
        System.out.println("최대공약수:"+a);

    }
}
//1회전
//int temp=b;      //temp=b=18
//b=a%b;          //b=a%b  12%18=12
//a=temp;         //a=temp  18
//2회전
//int temp=b;   temp=b  12
//b=a%b;    a%b====>18%12===>6
//a=temp;  a====12
//(a,b)=(12,6)
//3회전
//int temp=b;  temp=6
//b=a%b;  12%6  =0
//a=temp;  6
//(a,b) (6,0)