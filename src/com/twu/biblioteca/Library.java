package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.List;

public class Library {
    private BookRepository bookRepository;
    private MovieRepository movieRepository;

    public Library(BookRepository bookRepository, MovieRepository movieRepository) {
        this.bookRepository = bookRepository;
        this.movieRepository = movieRepository;
    }


    public List<Book> getAllBooksAvailable() {
        return bookRepository.getAvailable();
    }

    public List<Movie> getAllMoviesAvailable() {
        return movieRepository.getAvailable();
    }


    public boolean checkoutBook(String inputName){
        Book book = bookRepository.getByName(inputName);
        if(bookRepository.getAvailable().contains(book)){
            bookRepository.updateAvailableStatus(book);
            return true;
        }
        return false;
    }

    public boolean checkoutMovie(String inputName){
       Movie movie = movieRepository.getByName(inputName);
        if(movieRepository.getAvailable().contains(movie)){
            movieRepository.updateAvailableStatus(movie);
            return true;
        }
        return false;
    }

    public boolean returnBook(String inputName) {
        Book book = bookRepository.getByName(inputName);

        if(!bookRepository.getAvailable().contains(book) && book != null){
            bookRepository.updateAvailableStatus(book);
            return true;
        }
        return false;
    }

    public boolean returnMovie(String inputName) {
        Movie movie = movieRepository.getByName(inputName);
        if(!movieRepository.getAvailable().contains(movie) && movie != null){
            movieRepository.updateAvailableStatus(movie);
            return true;
        }
        return false;
    }
}
