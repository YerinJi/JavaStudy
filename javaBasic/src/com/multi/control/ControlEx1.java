package com.multi.control;

public class ControlEx1 {
    public void controlEx1(int x, int y, int k) {
//        if(x > 50){
//            if(y > 70){
//                if(k>88){
//
//                } else {
//
//                }
//            }else{
//
//            }
//        }else{
//
//        }
        if (x >= 90 && y > 90) {
            //조건
        } else {

        }
        if (x < 90 || y < 90 || k < 90) {

        }
    }

    public void controlEx2(int x, int y, int k, int z) {
        if (x >= 10 || y >= 20 || k >= 50 || z >= 60) {
            System.out.println("조건충분");
        }
    }

    public void controlEx3(int data) {
        if (data >= 40 || data >= 60 || data >= 70 || data >= 80) { //if(data>=40)
            System.out.println("조건만족");
        }
        if (data >= 40 && data >= 60 && data >= 70 && data >= 80) { //if(data>=80)
            System.out.println("조건만족");
        }
    }

    public static void main(String[] args) {
        ControlEx1 c = new ControlEx1();
//        c.controlEx1(50, 70, 88);
//        c.controlEx2(50, 70, 88, 99);
    }
}
