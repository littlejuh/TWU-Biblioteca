package com.twu.biblioteca;

import com.twu.biblioteca.model.User;

public class Security {

    private final User user;
    private boolean logged;


    public Security() {
        user = new User("User", "user@user", "0454541");
    }

    public boolean isLogged() {
        return logged;
    }

    public void login(String accountId, String password) {
        if (user.getAccount().equals(accountId) && user.getPassword().equals(password)) {
            logged = true;
        } else {
            logged = false;
        }
    }

    public String getPersonalInfo() {
        if (isLogged()) {
            return user.toString();
        }
        return "ERROR; The user is not logged. Type 0 to login.";
    }
}
