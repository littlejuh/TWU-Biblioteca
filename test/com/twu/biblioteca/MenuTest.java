package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.print.Printer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    private Library library;

    @Mock
    private Printer printer;

    @Mock
    private InputManager inputManager;

    @Mock
    private Security security;

    @InjectMocks
    private Menu menu;

    @Test
    public void shouldShowMenuMessage() {
        assertEquals("Choose from these choices:", menu.getMenuMessage());
    }

    @Test
    public void shouldGetOptionsMenu() {
        List<String> optionsMenu = new ArrayList<>();
        optionsMenu.add("0 - Login");
        optionsMenu.add("1 - List Books");
        optionsMenu.add("2 - List Movies");
        optionsMenu.add("3 - Checkout Movie");
        optionsMenu.add("4 - Return Movie");
        optionsMenu.add("5 - Checkout Book");
        optionsMenu.add("6 - Return Book");
        optionsMenu.add("7 - Personal Info");
        optionsMenu.add("8 - Quit");
        assertEquals(optionsMenu, menu.getOptionsMenu());
    }

    @Test
    public void shouldLoginWhenUserSelectOptionZeroAndUserIsNotLogged() {
        when(security.isLogged()).thenReturn(false);
        boolean menuReturn = menu.handlerMenu("0");
        verify(inputManager, times(2)).getInput();
        assertTrue(menuReturn);
    }

    @Test
    public void shouldLoginWhenUserSelectOptionZeroAndUserIsLogged() {
        when(security.isLogged()).thenReturn(true);
        boolean menuReturn = menu.handlerMenu("0");
        verify(printer).print("Your user is already logged in. Type other option.");
        assertTrue(menuReturn);
    }

    @Test
    public void shouldListAllBooksWhenUserSelectOptionOne() {
        ArrayList<Book> expected = new ArrayList<>(getBookList());
        when(library.getAllBooksAvailable()).thenReturn(expected);
        boolean menuReturn = menu.handlerMenu("1");
        verify(printer).print(expected);
        assertTrue(menuReturn);
    }

    @Test
    public void shouldListAllMoviesWhenUserSelectOptionOne() {
        ArrayList<Movie> expected = new ArrayList<>(getMovieList());
        when(library.getAllMoviesAvailable()).thenReturn(expected);
        boolean menuReturn = menu.handlerMenu("2");
        verify(printer).print(expected);
        assertTrue(menuReturn);
    }

   @Test
    public void shouldCheckoutBookWhenUserSelectOptionFourAndUserIsLogged() {
       when(security.isLogged()).thenReturn(true);
       when(library.checkoutBook(anyString())).thenReturn(true);
       boolean menuReturn = menu.handlerMenu("4");
       verify(printer, times(2)).print(anyString());
       assertTrue(menuReturn);
    }

    @Test
    public void shouldCheckoutBookWhenUserSelectOptionFourAndUserIsLoggedButBookIsNotAvailable() {
        when(security.isLogged()).thenReturn(true);
        when(library.checkoutBook(anyString())).thenReturn(false);
        boolean menuReturn = menu.handlerMenu("4");
        verify(printer, times(2)).print(anyString());
        assertTrue(menuReturn);
    }

    @Test
    public void shouldCheckoutBookWhenUserSelectOptionFourAndUserIsNotLogged() {
        when(security.isLogged()).thenReturn(false);
        boolean menuReturn = menu.handlerMenu("4");
        verify(printer).print("ERROR; The user is not logged. Type 0 to login.");
        assertTrue(menuReturn);
    }

    @Test
    public void shouldReturnPersonalInfoWhenUserSelectOptionSevenAndUserIsLogged(){
        when(security.isLogged()).thenReturn(true);
        boolean menuReturn = menu.handlerMenu("7");
        verify(security).getPersonalInfo();
        assertTrue(menuReturn);
    }

    @Test
    public void shouldReturnPersonalInfoWhenUserSelectOptionFourAndUserIsNotLogged(){
        when(security.isLogged()).thenReturn(false);
        boolean menuReturn = menu.handlerMenu("4");
        when(security.getPersonalInfo()).thenReturn("ERROR; The user is not logged. Type 0 to login.");
        assertTrue(menuReturn);
    }

    @Test
    public void shouldReturnFinalMessageWhenUserSelectedOptionEight(){
        boolean menuReturn = menu.handlerMenu("8");
        verify(printer).print("Bye!");
        assertFalse(menuReturn);
    }

    private Book getBookWith(String name) {
        return new Book(name, 2014, true, "Juliana");
    }

    private List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(getBookWith("Livro 1"));
        bookList.add(getBookWith("Livro 2"));
        return bookList;
    }

    private Movie getMovieWith(String name) {
        return new Movie(name, 2014, true, "Juliana", "1");
    }

    private List<Movie> getMovieList() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(getMovieWith("Filme 1"));
        movieList.add(getMovieWith("Filme 2"));
        return movieList;
    }
}
