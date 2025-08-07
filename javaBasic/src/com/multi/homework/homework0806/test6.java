package com.multi.homework.homework0806;

import java.util.*;

public class test6 {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        TreeSet<String> treeSet = new TreeSet<>(data);
        System.out.println(treeSet);
        Map<String, Integer> map = new LinkedHashMap<>();
        int cnt = 3;
        for(String str : treeSet){
            map.put(str, cnt--);
        }
        System.out.println(map);


    }
}
