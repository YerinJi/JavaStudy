package com.multi.object.staticex;

public class StaticEx3 {
    private int value;
    private static StaticEx3 staticEx3 = null;
    private StaticEx3() {

    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static StaticEx3 getStaticEx3() {
        if(staticEx3 == null) { //싱글턴
            staticEx3 = new StaticEx3();
        }
        return staticEx3;
    }

}
