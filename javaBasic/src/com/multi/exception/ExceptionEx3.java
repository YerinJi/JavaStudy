package com.multi.exception;

import java.io.IOException;

//try, catch, finally
//CompileException
//
public class ExceptionEx3 implements Cloneable{

    public Object getData(){
        return "10000";
    }

    public void interruptedException(){
        for(int i=1;i<=1000; i++){
            if(i%5==0) System.out.println();
            try{
                Thread.sleep(1000); //interruptedException
                System.out.println("입력:");
                System.out.println((char) System.in.read()); //IOException
                this.clone(); //this는 ExceptionEx3
            }catch(InterruptedException e){
                e.printStackTrace();

            }catch(IOException e){
                System.out.println(e.getMessage());
            }catch(CloneNotSupportedException e){
                e.printStackTrace();
            }
            System.out.print(i+"\t");

        }
    }
    public static void main(String[] args) {
        ExceptionEx3 ex = new ExceptionEx3();
        ex.interruptedException();

    }
}
