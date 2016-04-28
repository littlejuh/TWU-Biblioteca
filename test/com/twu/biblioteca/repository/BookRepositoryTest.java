package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BookRepositoryTest {

    private BookRepository repository;

    @Before
    public void setUp(){
       this.repository = new BookRepository();
    }

    @Test
    public void shouldGetAvailableBooks() {
        List<Book> expectedBooks = newArrayList(
                new Book("The Great Gatsby", 1925, true, "F. Scott Fitzgerald"),
                new Book("Nineteen Eighty-Four", 1949, true, "George Orwell"),
                new Book("Ulysses", 1922, true, "James Joyce"));

        assertThat(repository.getAvailable(), is(expectedBooks));
    }

    @Test
    public void shouldGetBookByName() {
        Book expectedBook = new Book("The Great Gatsby", 1925, true, "F. Scott Fitzgerald");
        assertThat(repository.getByName("The Great Gatsby"), is(expectedBook));
    }

    @Test
    public void shouldReturnNullWhenNotFoundBookByName(){
        assertNull(repository.getByName("Test Name Book"));
    }

    @Test
    public void shouldMakeBookAvailable(){
        Book expectedBook = new Book("The Great Gatsby", 1925, false, "F. Scott Fitzgerald");
        repository.updateAvailableStatus(expectedBook);
        assertTrue(expectedBook.isAvailable());
    }

    @Test
    public void shouldMakeBookUnavailable(){
        Book expectedBook = new Book("The Great Gatsby", 1925, true, "F. Scott Fitzgerald");
        repository.updateAvailableStatus(expectedBook);
        assertFalse(expectedBook.isAvailable());
    }
}