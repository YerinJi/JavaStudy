// src/main/java/com/multi/service/MyServiceImpl.java
package com.multi.service;

import com.multi.repository.MyRepository;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    private final MyRepository myRepository;
    private String prefix = "[DEFAULT]";

    public MyServiceImpl(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String performAction(String name) {
        return prefix + " " + myRepository.getMessage(name);
    }
}

