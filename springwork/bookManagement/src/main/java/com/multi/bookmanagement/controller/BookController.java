package com.multi.bookmanagement.controller;

import com.multi.bookmanagement.model.Book;
import com.multi.bookmanagement.service.BookService;
import com.multi.bookmanagement.support.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int size,
                       @RequestParam(required = false) String q,
                       @RequestParam(defaultValue = "titleOrAuthor") String type,
                       Model model) {
        int total = bookService.count(q, type);
        Pagination pagination = new Pagination(page, size, total, 5);

        List<Book> books = bookService.find(q,type,pagination.getOffset(), pagination.getSize());
        model.addAttribute("bookList", books);
        model.addAttribute("pagination", pagination);
        model.addAttribute("q", q==null ? "" : q);
        model.addAttribute("type", type);

        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "view";
    }

    @GetMapping("write")
    public String write(){
        return "write";
    }

    @PostMapping("/write")
    public String write(Book book){
        bookService.insertBook(book);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(Book book){
        bookService.updateBook(book);
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        bookService.deleteBook(id);
        return "redirect:/list";
    }



}
