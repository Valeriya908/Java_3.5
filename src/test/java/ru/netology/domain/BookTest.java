package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book first = new Book(1, "Pride and Prejudice", 500, "Jane Austen");

    @Test
    void shouldMatchesBookWithRightNameSearch() {

        boolean res = this.first.matches("Pride and Prejudice");

        assertTrue(res);
    }

    @Test
    void shouldMatchesBookWithWrongNameSearch() {

        boolean res = this.first.matches("The Green Mile");

        assertFalse(res);
    }

    @Test
    void shouldMatchesBookWithRightAuthorSearch() {

        boolean res = this.first.matches("Jane Austen");

        assertTrue(res);
    }

    @Test
    void shouldMatchesBookWithWrongAuthorSearch() {

        boolean res = this.first.matches("Stephen King");

        assertFalse(res);
    }
}