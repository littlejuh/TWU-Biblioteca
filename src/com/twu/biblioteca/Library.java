package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final ArrayList<Item> items = new ArrayList<>();
    public Library() {
        this.setUpBooks();
        this.setUpMovies();
    }

    private void setUpBooks() {
        this.items.add(new Book("The Great Gatsby", 1925, true, "F. Scott Fitzgerald"));
        this.items.add(new Book("The Grapes of Wrath", 1940, false, "John Steinbeck"));
        this.items.add(new Book("Nineteen Eighty-Four", 1949, true, "George Orwell"));
        this.items.add(new Book("Ulysses", 1922, true, "James Joyce"));
    }

    private void setUpMovies() {
        this.items.add(new Movie("Toy Story", 1995, true, "John Lasseter", "5"));
        this.items.add(new Movie("How to Train Your Dragon 2", 2014, false, "Dean DeBlois", ""));
        this.items.add(new Movie("Spirited Away", 1949, true, "Hayao Miyazaki", "4"));
        this.items.add(new Movie("Aladdin",  1922, true, "John Musker", "3"));
    }

    public List<Item> getAllBooksAvailable() {
         List<Item> availableBooks = new ArrayList<>();
        for (Item book : this.items) {
            if(book instanceof Book && book.isAvailable()){
                    availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Item> getAllMoviesAvailable() {
        List<Item> availableMovies = new ArrayList<>();
        for (Item movie : this.items) {
            if(movie instanceof Movie && movie.isAvailable()){
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    public boolean checkoutBook(String inputName){
        for(Item book : this.items){
            if(book instanceof Book && book.getName().equals(inputName) && book.isAvailable()){
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean checkoutMovie(String inputName){
        for(Item movie : this.items){
            if(movie instanceof Movie && movie.getName().equals(inputName) && movie.isAvailable()){
                movie.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String inputName) {
        for(Item book : this.items){
            if(book instanceof Book && book.getName().equals(inputName) && !book.isAvailable()){
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnMovie(String inputName) {
        for(Item movie : this.items){
            if(movie instanceof Movie && movie.getName().equals(inputName) && !movie.isAvailable()){
                movie.setAvailable(true);
                return true;
            }
        }
        return false;
    }
}
