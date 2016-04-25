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
}
