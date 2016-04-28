package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class BookRepository {

    private final List<Book> books;

    public BookRepository() {
        this.books = create();
    }

    public List<Book> getAvailable() {
        List<Book> booksAvailable = new ArrayList<>();
        for (Book book: books) {
            if(book.isAvailable()){
                booksAvailable.add(book);
            }
        }
        return booksAvailable;
    }

    private List<Book> create() {
        return newArrayList(new Book("The Great Gatsby", 1925, true, "F. Scott Fitzgerald"),
                new Book("Nineteen Eighty-Four", 1949, true, "George Orwell"),
                new Book("The Grapes of Wrath", 1940, false, "John Steinbeck"),
                new Book("Ulysses", 1922, true, "James Joyce"));
    }

    public Book getByName(String name) {
        for (Book book: this.books) {
            if(book.getName().equals(name)){
                return book;
            }
        }
         return null;
    }

    public void updateAvailableStatus(Book book) {
        if(book.isAvailable()){
            book.setAvailable(false);
        }else{
            book.setAvailable(true);
        }
    }
}
