package com.multi.homework0725;

import java.util.Arrays;

public class HomeworkEx6 {

    public void sorted(int[] arr){
        Arrays.sort(arr);
        int idx = 0;
        int[] tmp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            boolean isInner = false;
            for(int j = 0; j < idx; j++){
                if(arr[i] == tmp[j]){
                    isInner = true;
                    break;
                }
            }
            if(!isInner){
                tmp[idx++] = arr[i];
            }
        }
        int[] result = new int[idx];
        for(int i=0; i<idx; i++){
            result[i] = tmp[i];
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,3,4,1};
        HomeworkEx6 h = new HomeworkEx6();
        h.sorted(arr);
    }
}
