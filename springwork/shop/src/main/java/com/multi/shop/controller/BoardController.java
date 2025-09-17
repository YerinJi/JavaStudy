package com.multi.shop.controller;



import com.multi.shop.domain.Board;
import com.multi.shop.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "board/list";
    }

    @GetMapping("/board/new")
    public String newForm() {
        return "board/new";
    }

    @PostMapping("/board")
    public String create(Board board) {
        boardService.save(board);
        return "redirect:/list";
    }

    @GetMapping("/board")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "board/view";
    }

    @GetMapping("/board/edit")
    public String editForm(@RequestParam int id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "board/edit";
    }

    @PostMapping("/board/update")
    public String update(Board board) {
        boardService.update(board);
        return "redirect:/list";
    }

    @PostMapping("/board/delete")
    public String delete(@RequestParam int id) {
        boardService.delete(id);
        return "redirect:/list";
    }
}
