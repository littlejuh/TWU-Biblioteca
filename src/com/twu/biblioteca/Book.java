package com.twu.biblioteca;

public class Book {
    private final  String name;
    private final String author;
    private final int year;
    private boolean available;

    public Book(String name, String author, int year, boolean available){
        this.name = name;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public String toString() {
        return "Title: "+ this.name + " | " + "Author: " + this.author + " | " + "Year published: " + this.year;
    }

    public String getName() {
        return this.name;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
