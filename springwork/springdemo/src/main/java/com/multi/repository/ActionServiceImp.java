package com.multi.repository;

import org.springframework.stereotype.Service;

@Service //service는 곧 비즈니스이다.
public class ActionServiceImp implements ActionService {

    @Override
    public void showMessage() {
        System.out.println("showMessage 비즈니스 로직 수행");
    }

    @Override
    public void makeProcess() {
        System.out.println("makeProcess 비즈니스 로직 수행");
    }
}
