package com.multi.exception;

import java.io.IOException;

public class ExceptionEx4 {

    public void exceptionEx1() throws InterruptedException, IOException, CloneNotSupportedException {
        Thread.sleep(1000); //compileException
        System.in.read();
        this.clone();
    }

    public static void main(String[] args) throws IOException, InterruptedException, CloneNotSupportedException {
        ExceptionEx4 ex4 = new ExceptionEx4();
        ex4.exceptionEx1();

    }
}
