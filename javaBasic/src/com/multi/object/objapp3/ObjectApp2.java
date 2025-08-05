package com.multi.object.objapp3;

//langPage(String, Double, Integer, Float)
public class ObjectApp2 {

    public void wrapperClassMethod1(){
//        int i = 100;
//        Integer ii= new Integer(100);
//        System.out.println(i);
//        System.out.println(ii.intValue());

        long longValue = 10;
        Long longValue2 = longValue; //내부적으로 Long객체를 생성해서 그 주소값을 대입
        long i = new Long(99); //내부적으로 new Long(99)생성하고 그다음에 여기서 99를 추출해서 long i에 대입
        System.out.println(i);
        System.out.println(longValue2);
    }

    public static void main(String[] args) {
        ObjectApp2 obj = new ObjectApp2();
        obj.wrapperClassMethod1();
    }


}
