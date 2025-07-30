package com.multi.homework0725;

import java.util.Arrays;

public class HomeworkEx2 {

    public void print(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max) max = arr[i];
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]<min) min = arr[i];
        }
        System.out.println("최댓값 : " + max + ", 최솟값 : " + min);
    }

    public static void main(String[] args) {
        HomeworkEx2 homeworkEx2 = new HomeworkEx2();
        int[] arr = {10,20,3,55,6};
        homeworkEx2.print(arr);

    }
}
