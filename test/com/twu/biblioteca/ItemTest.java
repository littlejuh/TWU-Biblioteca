package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    private Item item;

    @Before
    public void setUp(){
        this.item = new Item("The Great Gatsby", 1925, true);
    }

    @Test
    public void shouldReturnToString(){
        assertEquals("Title: The Great Gatsby | Year published: 1925", this.item.toString());
    }
}
