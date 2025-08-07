package com.multi.object.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class ListEx2 {
    public void listMethodEx1(){
        Vector<String> list1=new Vector<String>();//ArrayList와 같은 List ,동시성제어
        list1.addElement("hello");
        list1.addElement("world");
        list1.add("Spring");
//        for (Object o : list1) {
//            System.out.println(o);
//        }
//        Iterator iterator= (Iterator) list1.iterator();
//        for(;iterator.hasNext();){
//            System.out.println(iterator.next());
//        }
        Enumeration enumeration= list1.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }


//        list1.remove("hello");
//        list1.contains("hello");


    }

    public void listMethodEx2(){

    }

    public static void main(String[] args) {
        ListEx2 listEx2=new ListEx2();
        listEx2.listMethodEx1();

    }
}