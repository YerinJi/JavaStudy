package com.multi.homework.homework0807;

import java.util.HashMap;
import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("김철수",85);
        map.put("이영희",92);
        map.put("박민수",78);

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(map.containsKey(str)){
            System.out.println(str + ": "+map.get(str));
        }
        System.out.println("전체목록: " + map);
    }
}
