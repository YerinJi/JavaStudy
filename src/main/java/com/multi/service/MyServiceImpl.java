package com.multi.service;

import com.multi.repository.MyRepository;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    private final MyRepository myRepository;
    // XML DI에서 property로 오버라이드 하는 포인트
    private String prefix = "[DEFAULT]";

    //생성자
    public MyServiceImpl(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public String getPrefix() {
        return prefix;
    }

    //XML DI에서 prefix 설정해보는 setter
    public void setPrefix(String prefix){
        this.prefix = prefix;
    }

    @Override
    public String performAction(String name) {
        return prefix + " " + myRepository.getMessage(name);
    }
}
