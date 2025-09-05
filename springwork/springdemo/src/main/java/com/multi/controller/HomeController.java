package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("msg", "Spring Legacy (XML) running!");
        return "home"; // /WEB-INF/views/home.jsp
    }
    @GetMapping({"/message"})
    public String message(Model model){
        model.addAttribute("msg", "Hello Spring");
        return "show";
    }
}

