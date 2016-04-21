package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    public Library() {
        this.setUpBooks();
    }

    private void setUpBooks() {
        this.books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true));
        this.books.add(new Book("The Grapes of Wrath", "John Steinbeck", 1940, false));
        this.books.add(new Book("Nineteen Eighty-Four", "George Orwell", 1949, true));
        this.books.add(new Book("Ulysses", "James Joyce", 1922, true));
    }

    public List<Book> getAllBooksAvailable() {
         List<Book> availableBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public boolean checkoutBook(String inputName){
        for(Book book : this.books){
            if(book.getName().equals(inputName) && book.isAvailable()){
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String inputName) {
        for(Book book : this.books){
            if(book.getName().equals(inputName) && !book.isAvailable()){
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }
}
