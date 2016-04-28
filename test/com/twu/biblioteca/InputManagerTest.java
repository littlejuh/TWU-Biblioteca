package com.twu.biblioteca;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputManagerTest {

    @Test
    @Ignore
    public void shouldGetInputPassword() {
        InputStream inputStream = new ByteArrayInputStream("abc".getBytes());
        System.setIn(inputStream);
        InputManager inputManager = new InputManager(System.console(), new Scanner(System.in));
        char[] password = new char[] {'a', 'b', 'c'};
        assertThat(inputManager.getInputPassword(), is("abc"));
    }

    @Test
    public void shouldGetInput() {
        String input = "any input";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputManager inputManager = new InputManager(System.console(), new Scanner(System.in));
        assertThat(inputManager.getInput(), is(input));
    }

}