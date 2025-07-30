package com.multi.homework0725;

public class HomeworkEx10 {

    public void sorted(int[] arr) {
        int tmp;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]>arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        HomeworkEx10 obj = new HomeworkEx10();
        int[] arr = {4,2,5,1,3};
        obj.sorted(arr);

    }
}
