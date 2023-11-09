package com.rr.databese1.dao.impl;

import com.rr.databese1.TestDataUtil;
import com.rr.databese1.dao.AuthorDAO;
import com.rr.databese1.domain.Author;
import com.rr.databese1.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookDaoImplIntegrationTests {

    private AuthorDAO authorDAO;

    private  BookDAOImpl underTest;
    @Autowired
    public BookDaoImplIntegrationTests(AuthorDAO author, BookDAOImpl underTest) {
        this.authorDAO = author;
        this.underTest = underTest;
    }

//    @Test
//    public void testThatBookCanBeCreateAndRecalled(){
//        Author author1 = TestDataUtil.createTestAuthor();
//        authorDAO.create(author1);
//        Book book = TestDataUtil.createTestBook();
//        underTest.create(book);
//        book.setAuthorId(author1.getId());
//        Optional<Book> result = underTest.findOne(book.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }

    @Test
    public void testThatMultipleBooksCanBeCreateAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthorA();
        authorDAO.create(authorA);
        Book bookA = TestDataUtil.createTestBookA();
        underTest.create(bookA);
        bookA.setAuthorId(authorA.getId());
        Author authorB = TestDataUtil.createTestAuthorB();
        authorDAO.create(authorB);
        Book bookB = TestDataUtil.createTestBookB();
        underTest.create(bookB);
        bookB.setAuthorId(authorB.getId());
        Author authorC = TestDataUtil.createTestAuthorC();
        authorDAO.create(authorC);
        Book bookC = TestDataUtil.createTestBookC();
        underTest.create(bookC);
        bookC.setAuthorId(authorC.getId());
        List<Book> result = underTest.find();

        assertThat(result)
                .hasSize(3)
                .containsExactly(bookA, bookB, bookC);
    }

    @Test
    public void testThatBookCanBeUpdated(){
    Author author = TestDataUtil.createTestAuthorA();
    authorDAO.create(author);
    Book bookA = TestDataUtil.createTestBookA();
    bookA.setAuthorId(author.getId());
    underTest.create(bookA);
    bookA.setTitle("Updated Title");
    underTest.update(bookA.getIsbn(), bookA);
    Optional<Book> result = underTest.findOne(bookA.getIsbn());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(bookA);
    }
}
