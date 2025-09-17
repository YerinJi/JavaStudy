package com.multi.bookmanagement.service;

import com.multi.bookmanagement.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    int count(String q, String type);
    List<Book> find(String q, String type, int offset, int limit);
}
