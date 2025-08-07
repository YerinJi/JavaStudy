package com.multi.object.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx1 {
    public void mapMethodEx1(){
        HashMap<Integer, String> hashMap = new HashMap<Integer,String>();
        hashMap.put(1,"지예린");
        hashMap.put(2,"김철수");
        hashMap.put(3,"정윤찬");
        hashMap.put(4,"지아린");

        Set<Integer> set =  hashMap.keySet();
        Iterator<Integer> iterator = set.iterator();
//        while(iterator.hasNext()){
//            int key=iterator.next();
//            System.out.println(key+":"+hashMap.get(key));
//        }

        Iterator<Map.Entry<Integer,String>>iter = hashMap.entrySet().iterator();


//        System.out.println(hashMap); //toString 호출되어 문자열로 반환
//        String name = String.valueOf(hashMap.get(2).startsWith("지")).charAt(0)=='t'?"지예린":"아무나";
//        System.out.println(name);
    }

    public static void main(String[] args) {
        MapEx1 mapEx1 = new MapEx1();
        mapEx1.mapMethodEx1();
    }
}
