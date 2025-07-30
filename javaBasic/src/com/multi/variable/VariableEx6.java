package com.multi.variable;

public class VariableEx6 {

    public void intValue(int count){
        for(int i =0; i<=count; i++){
            if(i%7==0)
                System.out.println();
            System.out.print(i + "\t");
        }
    }
    public void byteValue(byte x, byte y){

    }

    public static void main(String[] args) {
        VariableEx6 v = new VariableEx6();
        v.intValue(20);
        v.byteValue((byte) 5,(byte)7);
    }
}
