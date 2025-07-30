package com.multi.array;

public class ArrayEx3 {

    //2차원배열 (행, 열)
    public void arrayApp1(){
        int [][]m = new int[2][3];
        //int []x = new int [5]
        //2차원배열의 이름은 행 갯수
        //열의 주소.length  열의 개수
        for (int i=0; i<m.length;i++){
            for (int j=0; j<m[i].length;j++){
                m[i][j]=(int)(Math.random()*100);
                System.out.print(m[i][j]+ " ");
            }
            System.out.println();
        }

    }

    public void arrayApp2(){
        int []xx = new int[5];

        // xx = 20; int타입의 배열이기 때문에 이렇게는 선언이 불가능하다.
        xx[0]=5;
        xx[1]=6;
        (new int[3])[0]=10;
        (new int[3])[1]=40;

        (new int[4][5])[0][1] = 20;

    }

    public static void main(String[] args) {
        ArrayEx3 m=new ArrayEx3();
        m.arrayApp1();
    }
}
