package com.multi.bookmanagement.service;

import com.multi.bookmanagement.mapper.BookMapper;
import com.multi.bookmanagement.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public void insertBook(Book book) {
        bookMapper.insertBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public int count(String q, String type) {
        return bookMapper.count(q, type);
    }

    @Override
    public List<com.multi.bookmanagement.model.Book> find(String q, String type, int offset, int limit) {
        return bookMapper.find(q, type, offset, limit);
    }
}
