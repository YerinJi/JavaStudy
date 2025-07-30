package com.multi.homework0725;

import java.util.Arrays;

public class HomeworkEx7 {

    public void input(int[] arr){
        int[] tmp = new int[arr.length];
        for(int i=1; i<arr.length; i++){
            tmp[i]=arr[i-1];
            if(i==arr.length-1){
                tmp[0]=arr[i];
            }
        }
        System.out.println(Arrays.toString(tmp));
    }

    public static void main(String[] args) {
        HomeworkEx7 h = new HomeworkEx7();
        int[] arr = {10,20,30,40};
        h.input(arr);
    }
}
