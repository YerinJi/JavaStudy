package com.multi.springboot.controller;

import com.multi.springboot.model.Board;
import com.multi.springboot.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable int id) {
        boardService.incrementViews(id);
        return boardService.getBoardById(id);
    }

    @PostMapping
    public void insertBoard(@RequestBody Board board) {
        boardService.insertBoard(board);
    }

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable int id, @RequestBody Board board) {
        board.setId(id);

        boardService.updateBoard(board);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
    }
}
