package com.twu.biblioteca;

public class Item {

    private final  String name;
    private final int year;
    private boolean available;

    public Item(String name, int year, boolean available){
        this.name = name;
        this.year = year;
        this.available = available;
    }

    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public String toString() {
        return "Title: "+ this.name + " | " + "Year published: " + this.year;
    }

    public String getName() {
        return this.name;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
