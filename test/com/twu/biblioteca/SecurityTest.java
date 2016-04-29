package com.twu.biblioteca;

import com.twu.biblioteca.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SecurityTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private Security security;

    @Test
    public void shouldLogInUser(){
        security.login("1234", "1234");
        assertTrue(security.isLogged());
    }

    @Test
    public void shouldNotLogInUser(){
        security.login("error", "error");
        assertFalse(security.isLogged());
    }

    @Test
    public void shouldReturnPersonalInfoWhenUserIsLogged(){
        security.login("1234", "1234");
        assertThat(security.getPersonalInfo(), is("User{name='User', email='user@user', phone=0454541}"));
    }

    @Test
    public void shouldReturnPersonalInfoWhenUserIsNotLogged(){
        security.login("error", "error");
        assertThat(security.getPersonalInfo(), is("ERROR; The user is not logged. Type 0 to login."));
    }

}