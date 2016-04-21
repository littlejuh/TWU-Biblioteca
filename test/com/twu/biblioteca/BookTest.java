package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void setUp(){
         this.book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true);
    }
    @Test
    public void testToString() throws Exception {
        assertEquals("Title: The Great Gatsby | Author: F. Scott Fitzgerald | Year published: 1925", book.toString());
    }
}
