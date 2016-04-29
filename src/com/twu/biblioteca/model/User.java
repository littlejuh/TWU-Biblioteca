package com.twu.biblioteca.model;

public class User {

    private static final String ACCOUNT_ID = "1234";
    private static final String PASSWORD = "1234";
    private final String account;
    private final String name;
    private final String email;
    private final String phone;
    private final String password;

    public User(String name, String email, String phone) {
        this.account = ACCOUNT_ID;
        this.password = PASSWORD;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
