package com.multi.object.inheritance2;

public class SuperClass extends Object{
    private int superClassValue;
    public SuperClass(){

    }
    public SuperClass(int superClassValue){
        this.superClassValue = superClassValue;
    }

    @Override
    public String toString() {
        return super.toString() + String.valueOf(superClassValue);
    }
}
