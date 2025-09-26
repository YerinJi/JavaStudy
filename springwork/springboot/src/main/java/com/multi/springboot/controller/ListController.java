package com.multi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @GetMapping("/board")
    public String boardPage() {
        // list.jsp를 반환
        return "board";
    }

}
