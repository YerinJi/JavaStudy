package com.multi.object.collection;

import java.util.HashSet;
import java.util.Iterator;

//Set는
public class SetEx1 {
    public void setMethodEx1(){
        String []data = {"Java","Html","Css","Java","Sprint","Css"};
        HashSet<String> set1 = new HashSet<String>();
        HashSet<String> set2 = new HashSet<String>();
        for(int i=0;i<data.length;i++){
            if(!set1.add(data[i])){//데이터가 중복되면
                set2.add(data[i]); //중복된 데이터만 add
            }
        }
//        System.out.println(set1);
//        System.out.println(set2);
        Iterator<String> iterator = set1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        SetEx1 setEx1 = new SetEx1();
        setEx1.setMethodEx1();
    }
}
