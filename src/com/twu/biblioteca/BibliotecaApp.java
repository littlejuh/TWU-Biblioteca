package com.twu.biblioteca;

import com.twu.biblioteca.Util.ConsolePrinter;
import com.twu.biblioteca.Util.ContentPrinter;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new Menu(library);
        ConsolePrinter.print(getWelcomeMessage());
        ConsolePrinter.print(menu.getMenuMessage());
        ContentPrinter.print(menu.getOptionsMenu());


        boolean handlerMenu = true;
        while (handlerMenu) {
            handlerMenu = menu.handlerMenu(InputManager.getInput());
        }
    }

    public static String getWelcomeMessage() {
        return "Welcome to Bangalore Public Library!";
    }
}
