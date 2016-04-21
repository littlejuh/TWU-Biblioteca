package com.twu.biblioteca;

import com.twu.biblioteca.Util.ConsolePrinter;
import com.twu.biblioteca.Util.ContentPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static ContentPrinter contentPrinter;
    private static ConsolePrinter consolePrinter;
    private static Library library;

    public static void main(String[] args) {
        initialize();
        consolePrinter.print(getWelcomeMessage());
        consolePrinter.print(getMenuMessage());
        contentPrinter.print(getOptionsMenu());
        boolean handlerMenu = true;
        while (handlerMenu) {
            handlerMenu = handlerMenu(getInput());
        }
    }
    private static void initialize() {
        contentPrinter = new ContentPrinter();
        consolePrinter = new ConsolePrinter();
        library = new Library();
    }

    private static String getInput() {
        String selection;
        Scanner input = new Scanner(System.in);
        selection = input.nextLine();
        return selection;
    }

    private static boolean handlerMenu(String optionSelected) {
        switch (optionSelected) {
            case "List Books":
            case "1":
                contentPrinter.print(library.getAllBooksAvailable());
                return true;
            case "Checkout Book":
            case "2":
                checkoutBook();
            case "Return Book":
            case "3":
                returnBook();
            case "Quit":
            case "4":
                consolePrinter.print("Bye!");
                return false;
            default:
                consolePrinter.print("Select a valid option!");
                return true;
        }
    }

    private static boolean checkoutBook() {
        consolePrinter.print("Write the name of the book:");
        if (library.checkoutBook(getInput())) {
            consolePrinter.print("Thank you! Enjoy the book.");
        } else {
            consolePrinter.print("That book is not available.");
        }
        return true;
    }

    private static boolean returnBook() {
        consolePrinter.print("Write the name of the book:");
        if (library.returnBook(getInput())) {
            consolePrinter.print("Thank you for returning the book.");
        } else {
            consolePrinter.print("That is not a valid book to return.");
        }
        return true;
    }

    public static String getMenuMessage() {
        return "Choose from these choices:";
    }

    public static List<String> getOptionsMenu() {
        List<String> optionsMenu = new ArrayList<>();
        optionsMenu.add("1 - List Books");
        optionsMenu.add("2 - Checkout Book");
        optionsMenu.add("3 - Return Book");
        optionsMenu.add("4 - Quit");
        return optionsMenu;
    }

    public static String getWelcomeMessage() {
        return "Welcome to Bangalore Public Library!";
    }
}
