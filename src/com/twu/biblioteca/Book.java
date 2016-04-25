package com.twu.biblioteca;

public class Book extends Item {
    private String author;

    public Book(String name, int year, boolean available, String author){
        super(name, year, available);
        this.author = author;
    }

}
