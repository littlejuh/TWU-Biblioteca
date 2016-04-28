package com.twu.biblioteca.model;

public class Book {

    private final  String name;
    private final int year;
    private boolean available;
    private final String author;

    public Book(String name, int year, boolean available, String author){
        this.name = name;
        this.year = year;
        this.available = available;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return this.available;
    }


    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        return name != null ? name.equals(book.name) : book.name == null;

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", available=" + available +
                ", author='" + author + '\'' +
                '}';
    }
}
