package com.multi.homework.homework0805;

public class Ex4 {

    public static void main(String[] args) {
        try{
            int[] arr = {10, 20, 30};
            int result = arr[5] / 0;
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("배열 인덱스 오류");
        }
    }
}
