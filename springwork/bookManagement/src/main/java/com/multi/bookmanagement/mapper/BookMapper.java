package com.multi.bookmanagement.mapper;

import com.multi.bookmanagement.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);

    int count(@Param("q") String q, @Param("type") String type);

    List<Book> find(@Param("q") String q,
                    @Param("type") String type,
                    @Param("offset") int offset,
                    @Param("limit") int limit);
}
