package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void setUp(){
         this.book = new Book("The Great Gatsby", 1925, true, "F. Scott Fitzgerald");
    }

    @Test
    public void shouldReturnBookName(){
        assertEquals("The Great Gatsby", this.book.getName());
    }
}
