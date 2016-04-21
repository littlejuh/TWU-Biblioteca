package com.twu.biblioteca.Util;

public class ContentPrinter {
    private static final ConsolePrinter consolePrinter = new ConsolePrinter();

    public static void print(Iterable<?> list) {
        for (Object text : list) {
            consolePrinter.print(text);
        }
    }
}