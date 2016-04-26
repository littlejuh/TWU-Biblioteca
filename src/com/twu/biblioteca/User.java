package com.twu.biblioteca;

public class User {
    private final String name;
    private final String email;
    private final int phone;
    public User(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }
}
