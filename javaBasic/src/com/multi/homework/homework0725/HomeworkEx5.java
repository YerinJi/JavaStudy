package com.multi.homework.homework0725;

public class HomeworkEx5 {

    public void avg(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        System.out.println("평균: " + (double)sum/arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30};
        HomeworkEx5 h = new HomeworkEx5();
        h.avg(arr);
    }
}
