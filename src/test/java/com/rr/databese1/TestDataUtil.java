package com.rr.databese1;

import com.rr.databese1.domain.Author;
import com.rr.databese1.domain.Book;

public final class TestDataUtil {

    private TestDataUtil(){}

//    public static Author createTestAuthor() {
//        return Author.builder().
//                id(1L)
//                .name("Teresa Rosa")
//                .age(60)
//                .build();
//    }

    public static Author createTestAuthorA() {
        return Author.builder().
                id(2L)
                .name("Yuval Noah Harari")
                .age(47)
                .build();
    }


    public static Author createTestAuthorB() {
        return Author.builder().
                id(3L)
                .name("Noam Chomsky")
                .age(94)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder().
                id(4L)
                .name("Paulo Coelho")
                .age(76)
                .build();
    }

//    public static Book createTestBook() {
//        return Book.builder().
//                isbn("978-1-2345-6789-0")
//                .title("The Shadow in the Attic")
//                .authorId(1L)
//                .build();
//    }

    public static Book createTestBookA(final Author author) {
        return Book.builder().
                isbn("978-1-2345-6789-4")
                .title("Sapiens")
                .author(author)
                .build();
    }

    public static Book createTestBookB(Author author) {
        return Book.builder().
                isbn("978-1-2345-6789-7")
                .title("Who Rules the World?")
                .author(author)
                .build();
    }

    public static Book createTestBookC(Author author) {
        return Book.builder().
                isbn("978-1-2345-6789-2")
                .title("Zahir")
                .author(author)
                .build();
    }
}
