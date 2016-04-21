package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private ArrayList<Book> booksAvailableExpected;

    @Before
    public void setUp(){
        this.library = new Library();
        this.booksAvailableExpected = new ArrayList<>();
        this.booksAvailableExpected.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true));
        this.booksAvailableExpected.add(new Book("Nineteen Eighty-Four", "George Orwell", 1949, true));
        this.booksAvailableExpected.add(new Book("Ulysses", "James Joyce", 1922, true));
    }

    @Test
    public void shouldAllBooksAvailable() throws Exception {
        assertEquals(this.booksAvailableExpected.toString(), this.library.getAllBooksAvailable().toString());
    }

    @Test
    public void shouldCheckoutBook(){
        assertEquals(true, this.library.checkoutBook("Ulysses"));
    }

    @Test
    public void shouldNotCheckoutBook(){
        assertEquals(false, this.library.checkoutBook("The Grapes of Wrath"));
    }

    @Test
    public void shouldReturnBook(){
        assertEquals(true, this.library.returnBook("The Grapes of Wrath"));
    }

    @Test
    public void shouldNotReturnBook(){
        assertEquals(false, this.library.returnBook("Ulysses"));
    }

}
