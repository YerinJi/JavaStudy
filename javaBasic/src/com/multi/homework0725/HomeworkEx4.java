package com.multi.homework0725;

public class HomeworkEx4 {

    public void reverse(int[] arr){
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        HomeworkEx4 h = new HomeworkEx4();
        h.reverse(arr);

    }
}
