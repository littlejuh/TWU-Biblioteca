package com.twu.biblioteca;

import com.twu.biblioteca.Util.ConsolePrinter;
import com.twu.biblioteca.Util.ContentPrinter;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {
        ConsolePrinter.print(getWelcomeMessage());
        ConsolePrinter.print(Menu.getMenuMessage());
        ContentPrinter.print(Menu.getOptionsMenu());
        boolean handlerMenu = true;
        while (handlerMenu) {
            handlerMenu = Menu.handlerMenu(InputManager.getInput());
        }
    }

    public static String getWelcomeMessage() {
        return "Welcome to Bangalore Public Library!";
    }
}
