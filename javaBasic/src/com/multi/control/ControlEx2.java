package com.multi.control;

public class ControlEx2 {
    //if, if else, if elseif else, for, while, do~while, break, continue, return

    public void loopEx1(){
//        for(int i=1;i<=9;i++){
//            System.out.println("지예린");
//        }
//        for(int i=1;i<=9;i++); //세미콜론은 종료의 의미
//        System.out.println("ㅇㅇ");
        for(int i=1;i<=9;i++)
            System.out.println("dd");
        System.out.println("ddd");
    }

    public void loopEx2(){
//        for(int i=1; i<=9; i++){
//            for(int j=2; j<=9; j++){
//                System.out.print(j+"*"+i + "="+(i*j)+"\t");
//            }
//            System.out.println();
//        }

//        int i = 1;
//        while(i<=9){
//            for(int j=2; j<=9; j++){
//                System.out.print(j+"*"+i + "="+(i*j)+"\t");
//            }
//            System.out.println();
//            i++;
//        }

//        int i =1;
//        do{
//            for(int j=2; j<=9; j++){
//                System.out.print(j+"*"+i + "="+(i*j)+"\t");
//            }
//            System.out.println();
//            i++;
//
//        }while(i<=9);
    }

    public void loopEx3(){
        int i = 1;
        while(i<=9){
            int j = 2;
            while(j<=9){
                System.out.print(j+"*"+i + "="+(i*j)+"\t");
                j++;
            }
            i++;
            System.out.println();
        }
    }

    public void loopEx4(){
        int i = 1;
        do{
            int j = 2;
            do{
                System.out.print(j+"*"+i + "="+(i*j)+"\t");
                j++;
            }while(j<=9);
            i++;
            System.out.println();
        }while(i<=9);
    }

    public static void main(String[] args) {
        ControlEx2 c = new ControlEx2();
        c.loopEx4();
    }
}
