package com.twu.biblioteca.repository;

import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieRepositoryTest {
    private MovieRepository repository;

    @Before
    public void setUp() {
        this.repository = new MovieRepository();
    }

    @Test
    public void shouldGetAvailableMovies() {
        List<Movie> expectedMovies = newArrayList(new Movie("Toy Story", 1995, true, "John Lasseter", "5"),
                new Movie("Spirited Away", 1949, true, "Hayao Miyazaki", "4"),
                new Movie("Aladdin", 1922, true, "John Musker", "3"));

        assertThat(repository.getAvailable(), is(expectedMovies));
    }

    @Test
    public void shouldGetMovieByName() {
        Movie expectedMovie = new Movie("Toy Story", 1995, true, "John Lasseter", "5");
        assertThat(repository.getByName("Toy Story"), is(expectedMovie));
    }

    @Test
    public void shouldReturnNullWhenNotFoundMovieByName() {
        assertNull(repository.getByName("Test Name Movie"));
    }

    @Test
    public void shouldMakeMovieAvailable() {
        Movie expectedMovie = new Movie("Toy Story", 1995, false, "John Lasseter", "5");
        repository.updateAvailableStatus(expectedMovie);
        assertTrue(expectedMovie.isAvailable());
    }

    @Test
    public void shouldMakeMovieUnavailable() {
        Movie expectedMovie = new Movie("Toy Story", 1995, true, "John Lasseter", "5");
        repository.updateAvailableStatus(expectedMovie);
        assertFalse(expectedMovie.isAvailable());
    }
}
