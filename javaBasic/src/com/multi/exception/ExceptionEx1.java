package com.multi.exception;
//Exception은 예외 (CompileRunTime)
public class ExceptionEx1 {
    public void nullPointerExceptionExample1(String str){
//        String str = null;
        str = str.charAt(0) != 'A'? null: str;
        System.out.println(str.startsWith("Ajax"));
    }

    public void ArrayIndexOutOfBoundsExceptionExample1(){
        int []m = new int[5];
        for(int i=0;i<=5;i++){
            try{ // 도전코드...
                m[i]=i;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("ArrayIndexOutOfBoundsException~~~");
                e.printStackTrace();
//               printStackTrace로 인한 메세지
//                java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
//	                at com.multi.exception.ExceptionEx1.ArrayIndexOutOfBoundsExceptionExample1(ExceptionEx1.java:14)
//	                at com.multi.exception.ExceptionEx1.main(ExceptionEx1.java:25)
            } finally{ //무조건 실행되는 코드
                System.out.println("finally~~~");
            }

        }
    }

    public void arithmeticExceptionExample1(){
        int []m = new int[5];
        int result = 0;
        for(int i=0;i<=5;i++){
            try{
                m[i]=(int)Math.random()*100;
                result= 100/m[i];
            } catch(ArithmeticException e){

            }catch(NullPointerException e){

            } catch(ArrayIndexOutOfBoundsException e){

            } catch(Exception e){

            } catch(Throwable e){

            }

        }
    }


    public static void main(String[] args) {
        ExceptionEx1 obj = new ExceptionEx1();
//        obj.nullPointerExceptionExample1("SpringLesson");
//        obj.ArrayIndexOutOfBoundsExceptionExample1();
        obj.arithmeticExceptionExample1();
    }
}
