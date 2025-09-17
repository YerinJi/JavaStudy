package com.multi.springboot.controller;

import com.multi.springboot.model.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello(){
        return "hello Springboot";
    }
    @GetMapping("/user")
    public UserDTO getUser(){
        return new UserDTO(100,"지예린","yerin@mail.com");
    }
}
