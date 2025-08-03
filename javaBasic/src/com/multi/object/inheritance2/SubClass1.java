package com.multi.object.inheritance2;
//객체를 유기적으로 연결 한 것을 상속이라한다.

public class SubClass1 extends SuperClass {
    private int subClassValue;
    public SubClass1(){
        subClassValue = 1;
    }
    public SubClass1(int superClassValue, int subClassValue1) {
//        this.superClassValue=100; 부모가 private 처리하면 접근 불가
        super(superClassValue);
        this.subClassValue = subClassValue;

    }

    @Override
    public String toString() {
//        return toString() + " " + String.valueOf(subClassValue); 무한루프
        return super.toString() + " " + String.valueOf(subClassValue);
    }
}
