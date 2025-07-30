package com.multi.homework.homework0725;

public class HomeworkEx8 {

    public void twoPrint(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                System.out.print(arr[i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        HomeworkEx8 obj = new HomeworkEx8();
        int[] arr = {1,2,3,4,5,6};
        obj.twoPrint(arr);

    }
}
