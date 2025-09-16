package com.multi.aop.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public String greet(String name) {
        return "Hello " + name;
    }
    public int calc(int a, int b) {
        return a + b;
    }
    public void fail(){
        throw new IllegalStateException("boom");
    }
}
