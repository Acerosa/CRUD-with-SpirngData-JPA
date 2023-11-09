package com.rr.databese1.dao.impl;

import com.rr.databese1.TestDataUtil;
import com.rr.databese1.domain.Author;
import com.rr.databese1.domain.Book;
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
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BookDAOImpl underTest;

//    @Test
//    public void testThatCreateAuthorGeneratesCorrectSQL(){
//        Book book = TestDataUtil.createTestBook();
//        underTest.create(book);
//
//        verify(jdbcTemplate).update(eq("INSERT IN TO books (isbn, title, author_id) VALUES (?, ?, ?)"),
//                eq("978-1-2345-6789-0"),
//                eq("The Shadow in the Attic"),
//                eq(1L)
//        );
//    }

    @Test
    public void testThatFindOneGeneratedCorrectSQL(){
        underTest.findOne("978-1-2345-6789-0");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ?;"),
                ArgumentMatchers.<BookDAOImpl.BookRowMapper>any(),
                eq("978-1-2345-6789-0")
        );
    }

    @Test
    public void testThatFindGeneratedCorrectSQL(){
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDAOImpl.BookRowMapper>any());
    }

    @Test
    public void testThatUpdateGeneratesCorrectSQL(){
        Book book = TestDataUtil.createTestBookA();
        underTest.update("978-1-2345-6789-4", book);

        verify(jdbcTemplate).update(
                "UPDATE books SET  isbn = ?, title = ? , author_id = ? WHERE isbn = ?",
                "978-1-2345-6789-4", "Sapiens", 2L, "978-1-2345-6789-4"
        );
    }
}


