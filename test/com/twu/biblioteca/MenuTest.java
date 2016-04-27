package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void shouldShowMenuMessage() {
        assertEquals("Choose from these choices:", Menu.getMenuMessage());
    }

    @Test
    public void shouldGetOptionsMenu() {
        List<String> optionsMenu = new ArrayList<>();
        Menu menu = new Menu();
        optionsMenu.add("1 - List Books");
        optionsMenu.add("2 - Checkout Book");
        optionsMenu.add("3 - Return Book");
        optionsMenu.add("4 - Quit");
        assertEquals(optionsMenu, menu.getOptionsMenu());
    }
}
