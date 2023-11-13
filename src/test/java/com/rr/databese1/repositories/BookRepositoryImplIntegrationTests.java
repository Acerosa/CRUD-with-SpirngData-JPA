package com.rr.databese1.repositories;

import com.rr.databese1.TestDataUtil;
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
public class BookRepositoryImplIntegrationTests {



    private  BookRepository underTest;
    @Autowired
    public BookRepositoryImplIntegrationTests(BookRepository underTest) {

        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreateAndRecalled(){
        Author author1 = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA(author1);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreateAndRecalled(){
        Author authorA = TestDataUtil.createTestAuthorA();

        Book bookA = TestDataUtil.createTestBookA(authorA);
        underTest.save(bookA);

        Author authorB = TestDataUtil.createTestAuthorB();

        Book bookB = TestDataUtil.createTestBookB(authorB);
        underTest.save(bookB);

        Author authorC = TestDataUtil.createTestAuthorC();

        Book bookC = TestDataUtil.createTestBookC(authorC);
        underTest.save(bookC);

        Iterable<Book> result = underTest.findAll();

        assertThat(result)
                .hasSize(3)
                .containsExactly(bookA, bookB, bookC);
    }

//    @Test
//    public void testThatBookCanBeUpdated(){
//    Author author = TestDataUtil.createTestAuthorA();
//    authorDAO.create(author);
//    Book bookA = TestDataUtil.createTestBookA();
//    bookA.setAuthorId(author.getId());
//    underTest.create(bookA);
//    bookA.setTitle("Updated Title");
//    underTest.update(bookA.getIsbn(), bookA);
//    Optional<Book> result = underTest.findOne(bookA.getIsbn());
//    assertThat(result).isPresent();
//    assertThat(result.get()).isEqualTo(bookA);
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        authorDAO.create(authorA);
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthorId(authorA.getId());
//        underTest.create(bookA);
//        underTest.delete(bookA.getIsbn());
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isEmpty();
//    }
}
