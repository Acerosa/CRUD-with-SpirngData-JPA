package com.rr.databese1.dao;

import com.rr.databese1.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDAO {
void create(Author author);

    Optional <Author> findOne(long l);
    List<Author> find();

    void update(long id, Author author);

    void delete(Long id);
}
