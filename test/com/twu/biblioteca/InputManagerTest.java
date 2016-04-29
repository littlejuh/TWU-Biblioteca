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
    public void shouldGetInput() {
        String input = "any input";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputManager inputManager = new InputManager(new Scanner(System.in));
        assertThat(inputManager.getInput(), is(input));
    }

}