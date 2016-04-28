package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    private Movie movie;

    @Before
    public void setUp(){
        this.movie = new Movie("Toy Story", 1995, true, "John Lasseter", "5");
    }

    @Test
    public void shouldReturnMovieName(){
        assertEquals("Toy Story", this.movie.getName());
    }

}
