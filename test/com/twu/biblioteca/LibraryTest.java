package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
    @Mock
    private BookRepository bookRepository;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private Library library;

    @Test
    public void shouldGetAllBooksAvailable(){
        library.getAllBooksAvailable();
        verify(bookRepository).getAvailable();
    }

    @Test
    public void shouldGetAllMoviesAvailable(){
        library.getAllMoviesAvailable();
        verify(movieRepository).getAvailable();
    }

    @Test
    public void shouldCheckoutBook(){
        Book book = new Book("Ulysses", 1922, true, "James Joyce");
        when(bookRepository.getAvailable()).thenReturn(newArrayList(book));
        when(bookRepository.getByName("Ulysses")).thenReturn(book);
        assertTrue(library.checkoutBook("Ulysses"));
    }

    @Test
    public void shouldNotCheckoutBook(){
        Book book = new Book("Ulysses", 1922, false, "James Joyce");
        when(bookRepository.getAvailable()).thenReturn(new ArrayList<Book>());
        when(bookRepository.getByName("Ulysses")).thenReturn(book);
        assertFalse(library.checkoutBook("Ulysses"));
    }

    @Test
    public void shouldNotCheckoutNonExistentBook(){
        Book book = new Book("Ulysses", 1922, false, "James Joyce");
        when(bookRepository.getAvailable()).thenReturn(newArrayList(book));
        when(bookRepository.getByName("NonExistentBook")).thenReturn(null);
        assertFalse(library.checkoutBook("NonExistentBook"));
    }

    @Test
    public void shouldReturnBook(){
        Book book = new Book("Ulysses", 1922, false, "James Joyce");
        when(bookRepository.getAvailable()).thenReturn(new ArrayList<Book>());
        when(bookRepository.getByName("Ulysses")).thenReturn(book);
        assertTrue(library.returnBook("Ulysses"));
    }

    @Test
    public void shouldNotReturnAvailableBook(){
        Book book = new Book("Ulysses", 1922, true, "James Joyce");
        when(bookRepository.getAvailable()).thenReturn(newArrayList(book));
        when(bookRepository.getByName("Ulysses")).thenReturn(book);
        assertFalse(library.returnBook("Ulysses"));
    }

    @Test
    public void shouldNotReturnNonExistentBook(){
        Book book = new Book("Ulysses", 1922, true, "James Joyce");
        when(bookRepository.getAvailable()).thenReturn(newArrayList(book));
        when(bookRepository.getByName("NonExistentBook")).thenReturn(null);
        assertFalse(library.returnBook("NonExistentBook"));
    }

    @Test
    public void shouldCheckoutMovie(){
        Movie movie = new Movie("Toy Story", 1995, true, "John Lasseter", "5");
        when(movieRepository.getAvailable()).thenReturn(newArrayList(movie));
        when(movieRepository.getByName("Toy Story")).thenReturn(movie);
        assertTrue(library.checkoutMovie("Toy Story"));
    }

    @Test
    public void shouldNotCheckoutNonExistentMovie(){
        Movie movie = new Movie("Toy Story", 1995, true, "John Lasseter", "5");
        when(movieRepository.getAvailable()).thenReturn(newArrayList(movie));
        when(movieRepository.getByName("NonExistentMovie")).thenReturn(null);
        assertFalse(library.checkoutMovie("NonExistentMovie"));
    }

    @Test
    public void shouldNotCheckoutMovie(){
        Movie movie = new Movie("Toy Story", 1995, true, "John Lasseter", "5");
        when(movieRepository.getAvailable()).thenReturn(new ArrayList<Movie>());
        when(movieRepository.getByName("Toy Story")).thenReturn(movie);
        assertFalse(library.checkoutMovie("Toy Story"));
    }

    @Test
    public void shouldReturnMovie(){
        Movie movie = new Movie("Toy Story", 1995, false, "John Lasseter", "5");
        when(movieRepository.getAvailable()).thenReturn(new ArrayList<Movie>());
        when(movieRepository.getByName("Toy Story")).thenReturn(movie);
        assertTrue(library.returnMovie("Toy Story"));
    }

    @Test
    public void shouldNotReturnAvailableMovie(){
        Movie movie = new Movie("Toy Story", 1995, false, "John Lasseter", "5");
        when(movieRepository.getAvailable()).thenReturn(newArrayList(movie));
        when(movieRepository.getByName("Toy Story")).thenReturn(movie);
        assertFalse(library.returnMovie("Toy Story"));
    }

    @Test
    public void shouldNotReturnNonExistentMovie(){
        Movie movie = new Movie("Toy Story", 1995, false, "John Lasseter", "5");
        when(movieRepository.getAvailable()).thenReturn(newArrayList(movie));
        when(movieRepository.getByName("NonExistentMovie")).thenReturn(null);
        assertFalse(library.returnMovie("NonExistentMovie"));
    }

}
