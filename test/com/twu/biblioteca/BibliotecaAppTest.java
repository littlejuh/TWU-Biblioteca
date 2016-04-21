package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void shouldShowWelcomeMessage() {
        assertEquals("Welcome to Bangalore Public Library!", BibliotecaApp.getWelcomeMessage());
    }
    @Test
    public void shouldShowMenuMessage() {
        assertEquals("Choose from these choices:", BibliotecaApp.getMenuMessage());
    }

    @Test
    public void shouldGetOptionsMenu() {
        List<String> optionsMenu = new ArrayList<>();
        optionsMenu.add("1 - List Books");
        optionsMenu.add("2 - Checkout Book");
        optionsMenu.add("3 - Return Book");
        optionsMenu.add("4 - Quit");
        assertEquals(optionsMenu, BibliotecaApp.getOptionsMenu());
    }
}
