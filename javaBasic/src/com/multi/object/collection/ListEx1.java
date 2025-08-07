package com.multi.object.collection;

import java.util.ArrayList;

public class ListEx1 {
    //ArrayList
    public void listExMethod1(){
        ArrayList<String> list1 =  new ArrayList<String>();
        list1.add("Html");
        list1.add("Java");
        list1.add("Python");
        list1.add("Ruby");
        System.out.println(list1.toString()); //요소값들이 하나의 문자열 출력
        System.out.println(list1.size()); //nodeCount
//        System.out.println(list1.get(0));
//        for(int i=0;i<list1.size();i++){
//            System.out.println(list1.get(i));//요소
//        }
//        for(String str:list1){
//            System.out.println(str);
//        }
//        iterator는 반복자
        System.out.println(list1.iterator().next());
    }

    public static void main(String[] args) {
        ListEx1 list = new ListEx1();
        list.listExMethod1();


    }
}
