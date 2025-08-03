package com.multi.object.inheritance1;

public class Father extends GrandFather {
    private String action;
    public void sayFather(){
        System.out.println("sayFather");
    }

    @Override
    public void sayGrandFather() {
        System.out.println("sayGrandFather Father");
    }
}
