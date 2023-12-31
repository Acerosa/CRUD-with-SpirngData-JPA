package com.rr.databese1.repositories;

import com.rr.databese1.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> ageLessThan(int age);
    @Query("SELECT a from Author a where a.age > ?1")
    Iterable<Author> findAuthorsWithMoreAgeThan(int age);
}
