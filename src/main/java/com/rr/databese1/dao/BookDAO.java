package com.rr.databese1.dao;

import com.rr.databese1.domain.Author;
import com.rr.databese1.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();

    void update(String isbn, Book book);

    void delete(String isbn);
}
