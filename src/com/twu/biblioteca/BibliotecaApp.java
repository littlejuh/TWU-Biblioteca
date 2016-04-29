package com.twu.biblioteca;

import com.twu.biblioteca.print.Printer;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library(new BookRepository(), new MovieRepository());
        Printer printer = new Printer();
        Security security = new Security();
        InputManager inputManager = new InputManager(new Scanner(System.in));
        Menu menu = new Menu(printer, library, inputManager, security);
        printer.print(getWelcomeMessage());
        printer.print(menu.getMenuMessage());
        printer.print(menu.getOptionsMenu());

        boolean handlerMenu = true;
        while (handlerMenu) {
            handlerMenu = menu.handlerMenu(inputManager.getInput());
        }
    }

    public static String getWelcomeMessage() {
        return "Welcome to Bangalore Public Library!";
    }
}
