package com.rr.databese1.dao.impl;

import com.rr.databese1.TestDataUtil;
import com.rr.databese1.domain.Author;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private AuthorDAOPImpl underTest;

//    @Test
//    public void testThatCreateAuthorGeneratesCorrectSql() {
//        Author author = TestDataUtil.createTestAuthorA();
//
//        underTest.create(author);
//
//        verify(jdbcTemplate).update(
//                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
//                eq(1L), eq("Abigail Rose"), eq(80)
//        );
//    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql() {
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDAOPImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }
    @Test
    public void testThatFindManyGeneratesCorrectSQL(){
        underTest.find();

        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<AuthorDAOPImpl.AuthorRowMapper>any());
    }

    @Test
    public void testThatUpdateGeneratesCorrectSQL(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.update(author.getId(), author);

        verify(jdbcTemplate).update(
                "UPDATE authors SET  id = ?, name = ? , age = ? WHERE id = ?",
                2L, "Yuval Noah Harari", 47, 2L
        );
    }
}

