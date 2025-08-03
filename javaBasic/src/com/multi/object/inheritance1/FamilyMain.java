package com.multi.object.inheritance1;

public class FamilyMain {
    public static void main(String[] args) {
        //GrandFather, Father, Me
//        Me me = new Me();
//        me.sayMe();
//        me.sayFather();
//        me.sayGrandFather();
//        GrandFather gf = (GrandFather) new Father(); //UpCasting

//        ((Father)gf) //다운캐스팅
//        ((Father)gf).sayFather(); //DownCasting

//        Father father = (Father) new GrandFather();
//        father.sayFather(); //class cast 예외 오류남.

        GrandFather gf = new Father();
        gf.sayGrandFather();


    }
}
