package com.twu.biblioteca.model;

public class Movie {
    private final  String director;
    private final String rating;
    private final String name;
    private final int year;
    private boolean available;

    public Movie(String name, int year, boolean available, String director, String rating){
        this.name = name;
        this.year = year;
        this.available = available;
        this.director = director;
        this.rating = rating;
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

        Movie book = (Movie) o;

        if (year != book.year) return false;
        return name != null ? name.equals(book.name) : book.name == null;

    }

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", rating='" + rating + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }
}
