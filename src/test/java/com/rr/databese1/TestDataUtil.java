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

    public static Book createTestBookA() {
        return Book.builder().
                isbn("978-1-2345-6789-4")
                .title("Sapiens")
                .authorId(2L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder().
                isbn("978-1-2345-6789-7")
                .title("Who Rules the World?")
                .authorId(3L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder().
                isbn("978-1-2345-6789-2")
                .title("Zahir")
                .authorId(4L)
                .build();
    }
}
