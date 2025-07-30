package com.multi.array;

import java.util.Arrays;

public class ArrayEx4 {

    // 1차원 행으로만 구성
    // 2차원 행과 열로 구성

    public void arrayApp1() {

        int [][] x = {{10,20,30,40},{50,60,70},{80,90,100}}; //가변배열

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.printf("%4d",x[i][j]);
            }
            System.out.println();
        }
//        for(int xx:x[0]){
//            System.out.println(xx);
//        }
        for(int []xx:x){
            for(int xxx:xx){
                System.out.printf("%4d",xxx);
            }
            System.out.println();
        }
    }

    public void arrayApp2() {
        int[] numbers = {5,2,9,1,3};
        Arrays.sort(numbers);

        for (int i:numbers){
            System.out.printf("%4d", i);
        }

//        System.out.println("Sorted Array" + Arrays.toString(numbers));
    }

    public void arrayApp3() {
        int[] numbers = {5,2,9,1,3};
        int []cp = Arrays.copyOf(numbers,numbers.length);
        System.out.println(numbers[0]);
        numbers[0] = 99;
        System.out.println(cp[0]);
    }

    public void arrayApp4() {
        int index=0;
        int[] numbers = {5,2,9,1,3};
//        for (int i=0;i<numbers.length;i++){
//            if(numbers[i]==9){
//                index=i;
//            }
//        }
//        System.out.println("index="+index);
        System.out.println(Arrays.binarySearch(numbers,9));
    }

    public static void main(String[] args) {
        ArrayEx4 arrayEx4 = new ArrayEx4();
//        arrayEx4.arrayApp1();
//        arrayEx4.arrayApp2();
        arrayEx4.arrayApp4();
    }
}
