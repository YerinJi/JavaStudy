package com.multi.object.util;

import java.util.Arrays;

public class UtilEx6 {
    public static void main(String[] args) {
        int[] numbers = {3, 1, 4, 1, 5};

        // 정렬
        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));

        // 이진 검색
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("Index of 4: " + index);

        // 배열 복사
        int[] copied = Arrays.copyOf(numbers, 7); // 길이 7로 복사
        System.out.println("Copied: " + Arrays.toString(copied));
    }
}
