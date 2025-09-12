package com.multi.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("msg", "Spring Legacy (XML) running!");
        return "home"; // /WEB-INF/views/home.jsp
    }
    @GetMapping("/message")
    public String msg(Model model){
        model.addAttribute("msg", "hi....");
        return "hi";
    }

    @GetMapping("/edutest")
    public String edutest(Model model){
        //비즈니스 로직 수행부분
        return "edutest";
    }

}

