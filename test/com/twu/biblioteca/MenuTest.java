package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
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
        optionsMenu.add("1 - List Books");
        optionsMenu.add("2 - Checkout Book");
        optionsMenu.add("3 - Return Book");
        optionsMenu.add("4 - Quit");
        assertEquals(optionsMenu, menu.getOptionsMenu());
    }

    @Test
    public void shouldLoginWhenUserSelectOptionZeroAndUserIsNotLogged() {
        boolean menuReturn = menu.handlerMenu("0");
        when(security.isLogged()).thenReturn(false);
        verify(inputManager, times(2)).getInput();
        assertTrue(menuReturn);
    }

    @Test
    public void shouldLoginWhenUserSelectOptionZeroAndUserIsLogged() {
        boolean menuReturn = menu.handlerMenu("0");
        when(security.isLogged()).thenReturn(true);
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
    public void shouldCheckoutBookWhenUserSelectOptionTwo() {
       boolean menuReturn = menu.handlerMenu("2");
       verify(printer, times(2)).print(anyString());
       assertTrue(menuReturn);
    }

    @Test
    public void shouldReturnPersonalInfoWhenUserSelectOptionFourAndUserIsLogged(){
        when(security.isLogged()).thenReturn(true);
        boolean menuReturn = menu.handlerMenu("4");
        verify(security).getPersonalInfo();
        assertTrue(menuReturn);
    }


    // TODO: FIX-ME
    @Test
    public void shouldReturnPersonalInfoWhenUserSelectOptionFourAndUserIsNotLogged(){
        when(security.isLogged()).thenReturn(false);
        boolean menuReturn = menu.handlerMenu("4");
        when(security.getPersonalInfo()).thenReturn("ERROR; The user is not logged. Type 0 to login.");
        assertTrue(menuReturn);
    }

    @Test
    public void shouldReturnFinalMessageWhenUserSelectedOptionFive(){
        boolean menuReturn = menu.handlerMenu("5");
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
}
