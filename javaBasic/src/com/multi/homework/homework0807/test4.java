package com.multi.homework.homework0807;

import java.util.Scanner;
import java.util.Stack;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean isCor = true;

        for(char s:str.toCharArray()){
            if(s == '('){
                stack.push(s);
            } else if(s == ')'){
                if(!stack.isEmpty()){
                    isCor = false;
                    break;
                }
                stack.pop();
            }
        }

        if(isCor && stack.isEmpty()){
            System.out.println("올바른 괄호입니다.");
        } else{
            System.out.println("잘못된 괄호입니다.");
        }
    }
}
