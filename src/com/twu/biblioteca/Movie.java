package com.twu.biblioteca;

public class Movie extends Item{
    private final  String director;
    private final String rating;

    public Movie(String name, int year, boolean available, String director, String rating){
        super(name, year, available);
        this.director = director;
        this.rating = rating;
    }


}
