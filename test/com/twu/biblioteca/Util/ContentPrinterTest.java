package com.twu.biblioteca.Util;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class ContentPrinterTest {

    @Test
    public void shouldPrintContentCorrectly() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Hello");
        expected.add("World");
        expected.add("!");
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        ContentPrinter.print(expected);
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertTrue(allWrittenLines.contains("Hello\n" + "World\n" + "!\n"));
    }
}
