package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private ArrayList<Item> items;

    @Before
    public void setUp(){
        this.library = new Library();
        this.items = new ArrayList<>();
        this.setUpBooks();
        this.setUpMovies();
    }

    private void setUpBooks() {
        this.items.add(new Book("The Great Gatsby", 1925, true, "F. Scott Fitzgerald"));
        this.items.add(new Book("Nineteen Eighty-Four", 1949, true, "George Orwell"));
        this.items.add(new Book("Ulysses", 1922, true, "James Joyce"));
    }

    private void setUpMovies() {
        this.items.add(new Movie("Toy Story", 1995, true, "John Lasseter", "5"));
        this.items.add(new Movie("How to Train Your Dragon 2", 2014, true, "Dean DeBlois", ""));
        this.items.add(new Movie("Spirited Away", 1949, true, "Hayao Miyazaki", "4"));
    }

    @Test
    public void shouldAllBooksAvailable() throws Exception {
        ArrayList<Item> books = new ArrayList<>();
        for (Item item: this.items) {
            if(item instanceof Book){
                books.add(item);
            }
        }
       books.equals(this.library.getAllBooksAvailable());
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

    @Test
    public void shouldCheckoutMovie(){
        assertEquals(true, this.library.checkoutMovie("Toy Story"));
    }

    @Test
    public void shouldNotCheckoutMovie(){
        assertEquals(false, this.library.checkoutMovie("How to Train Your Dragon 2"));
    }

    @Test
    public void shouldReturnMovie(){
        assertEquals(true, this.library.returnMovie("How to Train Your Dragon 2"));
    }

    @Test
    public void shouldNotReturnMovie(){
        assertEquals(false, this.library.returnMovie("Toy Story"));
    }

}
