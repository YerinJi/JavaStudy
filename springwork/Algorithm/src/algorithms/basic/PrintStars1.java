package algorithms.basic;

import java.util.Scanner;

public class PrintStars1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, w;
        // n = 별의 총 개수
        // w = 줄바꿈 간격
        System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");
        do{
            System.out.println("n값: ");
            n = sc.nextInt();
        } while (n <= 0);

        do {
            System.out.println("w값: ");
            w = sc.nextInt();
        } while (w <= 0 || w > n);

        //n개의 *을 w개마다 줄을 바꿔 출력
        for(int i=0; i<n; i++){
            System.out.print("*");
            if(i %w == w-1)
                System.out.println();
        }
    }
}
