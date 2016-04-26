package com.twu.biblioteca.Util;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ConsolePrinterTest {

    @Test
    public void shouldPrintCorrectly() throws IOException {
        String expected = "Hello World!";
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        ConsolePrinter.print(expected);
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertTrue(allWrittenLines.contains("Hello World!"));
    }
}
