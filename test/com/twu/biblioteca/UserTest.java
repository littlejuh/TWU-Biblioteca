package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp(){
        this.user = new User("Juliana Fernandes", "jfernan@thoughtworks.com", 82034983);
    }

    @Test
    public void shouldReturnUserName(){
        assertEquals("Juliana Fernandes", this.user.getName());
    }
}
