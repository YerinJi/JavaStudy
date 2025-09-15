package com.multi.springboot.controller;

import com.multi.springboot.model.Board;
import com.multi.springboot.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class boardController {
    private final BoardService boardService;

    public boardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boardList", boardService.getAllBoards());
        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        boardService.incrementViews(id);
        model.addAttribute("board",boardService.getBoardById(id));
        return "view";
    }


    @GetMapping("write")
    public String writeForm(){
        return "write";
    }

    @PostMapping("/write")
    public String write(Board board){
        boardService.insertBoard(board);
        return "redirect:/list";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.getBoardById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Board board){
        boardService.updateBoard(board);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        boardService.deleteBoard(id);
        return "redirect:/list";
    }
}
