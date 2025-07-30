package com.multi.operator;

//연산자 최우선 () . []
public class OperatorEx2 { //클래스(설계도, 사용자 정의 자료형)
    public int parentheses(int x, int y, int k) {
        System.out.println("parentheses");
//        if(++x == --y)
//            return x+y*k;
//        else
//            return (x+y)*k;
        return ++x == --y ? x + y * k : (x + y) * k;
    }

    public void unaryOperator(int x, int y, int k) {
        // +,-,++,--,!,~
        int r = ++x + -y-- + ++k;
        System.out.println(!(-r != -k));

    }

    public String arithemeticOperator(int x, int y, int k) { //산술
        if (x++ != --y) {
            return "Java";
        } else if (x % y == 0) {
            return "Spring";
        }
        return "default";
    }

    public void logicalOperator(int x, int y, int k, int z, int i) {
        //&, | 비트 논리연산자
        //&&, || 일반 논리연산자
        //boolean isState = ++x > y-- && ++k == z-- && i-- == 5;
        boolean isState = ++x > y-- || ++k == z-- && i-- == 5;
        //x=2, y=1, k=3, z=4, i=5
        System.out.printf("isState = %b , x=%d, y=%d, k=%d, z=%d, i=%d", isState, x, y, k, z, i);
    }

    public static void main(String[] args) {
        OperatorEx2 o = new OperatorEx2();
        o.logicalOperator(1, 2, 3, 4, 5);
//        String s = o.arithemeticOperator(2, 2, 3);
//        System.out.println(s);
//        o.unaryOperator(1,2,3);
//        int rs = o.parentheses(1,2,3);
//        System.out.println("rs = "+rs);

    }
}
