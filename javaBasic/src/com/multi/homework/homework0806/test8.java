package com.multi.homework.homework0806;

import java.util.*;

public class test8 {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kim", 85);
        scores.put("Lee", 95);
        scores.put("Park", 90);

        TreeMap<String, Integer> treeMap = new TreeMap<>((Map) scores.entrySet());
        treeMap.putAll(scores);
        System.out.println(treeMap);





    }
}
