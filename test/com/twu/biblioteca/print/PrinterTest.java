package com.twu.biblioteca.print;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class PrinterTest {
    private Printer printer = new Printer();

    @Test
    public void shouldPrintCorrectly() throws IOException {
        String expected = "Hello World!";
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        printer.print(expected);
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertTrue(allWrittenLines.contains("Hello World!"));
    }

    @Test
    public void shouldPrintContentCorrectly() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Hello");
        expected.add("World");
        expected.add("!");
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        printer.print(expected);
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertTrue(allWrittenLines.contains("Hello\n" + "World\n" + "!\n"));
    }
}
