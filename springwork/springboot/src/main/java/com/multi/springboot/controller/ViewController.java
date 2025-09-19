package com.multi.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class ViewController {

    @GetMapping("/list")
    public String view() {
        return "list"; // list.jsp 반환
    }

    @GetMapping("/add")
    public String add() {
        return "add"; // add.jsp 반환
    }

    @GetMapping("/edit{employeeid}")
    public String edit(@PathVariable int employeeid) {
        return "edit"; //edit.jsp 반환
    }
}
