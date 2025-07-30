package com.multi.homework0725;

public class HomeworkEx9 {

    public void middlePrint(int[] arr) {
        int idx = arr.length/2;
        System.out.println(arr[idx]);
    }

    public static void main(String[] args) {
        HomeworkEx9 obj = new HomeworkEx9();
        int[] arr = {5,1,9};
        obj.middlePrint(arr);

    }
}
