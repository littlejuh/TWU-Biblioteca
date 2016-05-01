package com.twu.biblioteca;

import com.twu.biblioteca.print.Printer;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final Library library;
    private final Printer printer;
    private final InputManager inputManager;
    private final Security security;

    public Menu(Printer printer, Library library, InputManager inputManager, Security security) {
        this.printer = printer;
        this.library = library;
        this.inputManager = inputManager;
        this.security = security;
    }

    public String getMenuMessage() {
        return "Choose from these choices:";
    }

    public List<String> getOptionsMenu() {
        List<String> optionsMenu = new ArrayList<>();
        optionsMenu.add("0 - Login");
        optionsMenu.add("1 - List Books");
        optionsMenu.add("2 - List Movies");
        optionsMenu.add("3 - Checkout Movie");
        optionsMenu.add("4 - Return Movie");
        optionsMenu.add("5 - Checkout Book");
        optionsMenu.add("6 - Return Book");
        optionsMenu.add("7 - Personal Info");
        optionsMenu.add("8 - Quit");
        return optionsMenu;
    }

    public boolean handlerMenu(String optionSelected) {
        switch (optionSelected.toLowerCase()) {
            case "login":
            case "0":
                login();
                break;
            case "list books":
            case "1":
                printer.print(library.getAllBooksAvailable());
                break;
            case "list movies":
            case "2":
                printer.print(library.getAllMoviesAvailable());
                break;
            case "checkout movie":
            case "3":
                checkoutMovie();
                break;
            case "return movie":
            case "4":
                returnMovie();
                break;
            case "checkout book":
            case "5":
                checkoutBook();
                break;
            case "return book":
            case "6":
                returnBook();
                break;
            case "personal info":
            case "7":
                personalInfo();
                break;
            case "quit":
            case "8":
                printer.print("Bye!");
                return false;
            default:
                printer.print("Select a valid option!");
                break;
        }
        return true;
    }

    private boolean login() {
        if (security.isLogged()) {
            printer.print("Your user is already logged in. Type other option.");
        } else {
            printer.print("Please, type your account ID.");
            String accountId = inputManager.getInput();
            printer.print("Please, type your password.");
            String password = inputManager.getInput();
            security.login(accountId, password);
            if (security.isLogged()) {
                printer.print("Enjoy the library, type any option.");
            } else {
                printer.print("User not found, type any option.");
            }
        }
        return true;
    }

    private boolean personalInfo() {
        printer.print(security.getPersonalInfo());
        return true;
    }

    private boolean checkoutMovie() {
        if (security.isLogged()) {
            printer.print("Write the name of the movie:");
            if (library.checkoutMovie(inputManager.getInput())) {
                printer.print("Thank you! Enjoy the movie.");
            } else {
                printer.print("That movie is not available.");
            }
        } else {
            printer.print("ERROR; The user is not logged. Type 0 to login.");
        }
        return true;
    }

    private boolean returnMovie() {
        if (security.isLogged()) {
            printer.print("Write the name of the movie:");
            if (library.returnMovie(inputManager.getInput())) {
                printer.print("Thank you for returning the movie.");
            } else {
                printer.print("That is not a valid movie to return.");
            }
        } else {
            printer.print("ERROR; The user is not logged. Type 0 to login.");
        }
        return true;
    }

    private boolean returnBook() {
        if (security.isLogged()) {
            printer.print("Write the name of the book:");
            if (library.returnBook(inputManager.getInput())) {
                printer.print("Thank you for returning the book.");
            } else {
                printer.print("That is not a valid book to return.");
            }
        } else {
            printer.print("ERROR; The user is not logged. Type 0 to login.");
        }
        return true;
    }

    private boolean checkoutBook() {
        if (security.isLogged()) {
            printer.print("Write the name of the book:");
            if (library.checkoutBook(inputManager.getInput())) {
                printer.print("Thank you! Enjoy the book.");
            } else {
                printer.print("That book is not available.");
            }
        } else {
            printer.print("ERROR; The user is not logged. Type 0 to login.");
        }
        return true;
    }

}
