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
    public void shouldReturnFinalMessageWhenUserSelectedOptionFour(){
        boolean menuReturn = menu.handlerMenu("4");
        verify(printer).print("Bye!");
        assertFalse(menuReturn);
    }

    private Book getBookWith(String name) {
        return new Book(name, 2014, true, "Juliana");
    }

    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(getBookWith("Livro 1"));
        bookList.add(getBookWith("Livro 2"));
        return bookList;
    }
}
