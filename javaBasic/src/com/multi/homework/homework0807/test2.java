package com.multi.homework.homework0807;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> hashSet = new HashSet<>();
        while(true){
            int n = sc.nextInt();
            if(n < 0)
                break;
            hashSet.add(n);
        }

        List<Integer> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        System.out.println(list);

    }
}
