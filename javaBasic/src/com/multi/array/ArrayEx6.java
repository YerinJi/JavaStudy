package com.multi.array;

public class ArrayEx6 {

    public void createArray() {
        int[] m = new int[10]; //5개의 메모리생성
        for (int i = 0; i < m.length; i++) {
            m[i] = (int) (Math.random() * 100); //난수 발생
        }
        disp(m);
        System.out.println("최댓값:"+maxProcess(m));
        System.out.println("최솟값:"+minProcess(m));
        System.out.println("평균"+getAvg(m)+"이상갯수:"+getAvgMoreCount(m));
    }

    public void disp(int[] x) {
        for (int i : x) {
            System.out.printf("%5d", i);
        }
        System.out.println();
    }

    //최댓값,최솟값,평균값,평균값 이상인 갯수
    public int maxProcess(int[] data) {
        int max = data[0];
        for (int i = 0; i < data.length; i++) {//전체data탐색
            if (max < data[i]) {
                max = data[i];
            }//if
        }//for
        return max;
    }

    public int minProcess(int[] data) {
        int min = data[0];
        for (int i = 0; i < data.length; i++) {//전체data탐색
            if (min > data[i]) {
                min = data[i];
            }//if
        }//for
        return min;
    }

    public double getAvg(int []data) {
        int total=0;
        for (int i = 0; i < data.length; i++) {
            total+=data[i];
        }
        return total/(double)data.length;
    }
    public int getAvgMoreCount(int []data) {
        double avg=getAvg(data);
        int cnt=0;
        for (int i = 0; i < data.length; i++) {
            if(data[i]>avg)cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        ArrayEx6 arrayEx6 = new ArrayEx6();
        arrayEx6.createArray();
    }
}
