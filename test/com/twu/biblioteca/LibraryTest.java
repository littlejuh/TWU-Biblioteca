package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private ArrayList<Item> itemsAvailableExpected;

    @Before
    public void setUp(){
        this.library = new Library();
        this.itemsAvailableExpected = new ArrayList<>();
        this.itemsAvailableExpected.add(new Book("The Great Gatsby", 1925, true, "F. Scott Fitzgerald"));
        this.itemsAvailableExpected.add(new Book("Nineteen Eighty-Four", 1949, true, "George Orwell"));
        this.itemsAvailableExpected.add(new Book("Ulysses", 1922, true, "James Joyce"));
    }

    @Test
    public void shouldAllBooksAvailable() throws Exception {
        assertEquals(this.itemsAvailableExpected.toString(), this.library.getAllBooksAvailable().toString());
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
