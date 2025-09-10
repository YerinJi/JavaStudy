package com.multi.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

}

