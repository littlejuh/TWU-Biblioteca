package com.twu.biblioteca;

import com.twu.biblioteca.Util.ConsolePrinter;
import com.twu.biblioteca.Util.ContentPrinter;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static Library library = new Library();
    
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

    public static boolean handlerMenu(String optionSelected) {
        switch (optionSelected) {
            case "List Books":
            case "1":
                ContentPrinter.print(library.getAllBooksAvailable());
                return true;
            case "Checkout":
            case "2":
                checkoutItem();
            case "Return":
            case "3":
                returnItem();
            case "Quit":
            case "4":
                ConsolePrinter.print("Bye!");
                return false;
            default:
                ConsolePrinter.print("Select a valid option!");
                return true;
        }
    }


    private static boolean checkoutItem() {
        ConsolePrinter.print("Write the name of the book:");
        if (library.checkoutBook(InputManager.getInput())) {
            ConsolePrinter.print("Thank you! Enjoy the book.");
        } else {
            ConsolePrinter.print("That book is not available.");
        }
        return true;
    }

    private static boolean returnItem() {
        ConsolePrinter.print("Write the name of the book:");
        if (library.returnBook(InputManager.getInput())) {
            ConsolePrinter.print("Thank you for returning the book.");
        } else {
            ConsolePrinter.print("That is not a valid book to return.");
        }
        return true;
    }


}
