package com.multi.homework.homework0807;

import java.util.Scanner;
import java.util.Vector;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<String> vector = new Vector<>();
        for(int i=0; i< 3; i++){
            String s = sc.nextLine();
            vector.add(s);
        }
        System.out.println("\n전체 게시글 목록:");
        for(int i=0; i< vector.size(); i++){
            System.out.println(i +". " + vector.get(i));
        }

    }
}
