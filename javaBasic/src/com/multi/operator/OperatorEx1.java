package com.multi.operator;

//변수.연산자,제어문, 배열
public class OperatorEx1 {
    //연산자 --> 계산을 목적으로 사용되는 기호
    //최우선[] . () 단항 ++ -- - + ! ~ 산술 쉬프트 관계 논리 삼항 대입 콤마
    public void firstOperator(int x, int y, int k) {
        System.out.println(x > y ? x + y * k : (x + y) * k);

    }

    public void logicalOperator(int x, int y, int k, int z) {
        boolean isState = ++x > y-- && k++ == 3 && z++ == 3;
        System.out.println();
        System.out.println(isState);
        System.out.println();
    }

    public static void main(String[] args) {
        OperatorEx1 operatorEx1 = new OperatorEx1();
//        operatorEx1.firstOperator(1, 2, 3);
        operatorEx1.logicalOperator(1, 2, 3, 4);
    }
}
