package com.multi.homework0725;

public class HomeworkEx3 {

    public void search(int[] arr, int x){
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==x){
                cnt++;
            }
        }
        System.out.println("배열에서 " +x +"의 개수는 "+cnt +"입니다.");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 2};
        HomeworkEx3 homeworkEx3 = new HomeworkEx3();
        homeworkEx3.search(arr, 2);
    }
}
