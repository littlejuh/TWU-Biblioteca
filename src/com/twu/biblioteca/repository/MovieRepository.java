package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class MovieRepository {

    private final List<Movie> movies;

    public MovieRepository() {
        this.movies = create();
    }

    public List<Movie> getAvailable() {
        List<Movie> moviesAvailable = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                moviesAvailable.add(movie);
            }
        }
        return moviesAvailable;
    }

    private List<Movie> create() {
        return newArrayList(new Movie("Toy Story", 1995, true, "John Lasseter", "5"),
                new Movie("How to Train Your Dragon 2", 2014, false, "Dean DeBlois", ""),
                new Movie("Spirited Away", 1949, true, "Hayao Miyazaki", "4"),
                new Movie("Aladdin", 1922, true, "John Musker", "3"));
    }

    public Movie getByName(String name) {
        for (Movie movie : this.movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    public void updateAvailableStatus(Movie movie) {
        if (movie.isAvailable()) {
            movie.setAvailable(false);
        } else {
            movie.setAvailable(true);
        }
    }
}
