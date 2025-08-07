package com.multi.homework.homework0806;

public class test3 {

    public static String buildString(int count){
        String result = "";
        for(int i = 0; i < count; i++) {
            result += "a";
        }
        return result;
    }
    public static String buildStringBuffer(int count){
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < count; i++) {
            result.append("a");
        }
        return result.toString();
    }
    public static String buildStringBuilder(int count){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < count; i++) {
            result.append("a");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int count = 1000000;
        long start, end;

        start = System.nanoTime();
        buildString(count);
        end = System.nanoTime();
        System.out.println("String: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        buildStringBuffer(count);
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        buildStringBuilder(count);
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start) / 1_000_000 + " ms");
    }
    //String이 제일 느리고, StringBuffer가 그 다음 StringBuilder가 제일 빨리 실행되었다.
    //String < StringBuffer < StringBuilder
    // 느림 -> 빠름
}
