package com.twu.biblioteca.Util;

public class ContentPrinter {

    public static void print(Iterable<?> list) {
        for (Object text : list) {
            ConsolePrinter.print(text);
        }
    }
}