package com.twu.biblioteca.print;

public class Printer {


    public void print(String text) {
        System.out.println(text);
    }

    public void print(Iterable<?> list) {
        for (Object text : list) {
            print(text.toString());
        }
    }
}
