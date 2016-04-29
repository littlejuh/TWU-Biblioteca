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
        optionsMenu.add("1 - List Books");
        optionsMenu.add("2 - Checkout Book");
        optionsMenu.add("3 - Return Book");
        optionsMenu.add("4 - Quit");
        return optionsMenu;
    }

    private boolean checkoutItem() {
        printer.print("Write the name of the book:");
        if (library.checkoutBook(inputManager.getInput())) {
            printer.print("Thank you! Enjoy the book.");
        } else {
            printer.print("That book is not available.");
        }
        return true;
    }

    public boolean handlerMenu(String optionSelected) {
        switch (optionSelected) {
            case "Login":
            case "0":
                login();
            case "List Books":
            case "1":
                printer.print(library.getAllBooksAvailable());
                break;
            case "Checkout":
            case "2":
                checkoutItem();
                break;
            case "Return":
            case "3":
                returnItem();
                break;
            case "Personal Info":
            case "4":
                personalInfo();
                break;
            case "Quit":
            case "5":
                printer.print("Bye!");
                return false;
            default:
                printer.print("Select a valid option!");
                break;
        }
        return true;
    }

    private boolean login() {
        if(security.isLogged()){
            printer.print("Your user is already logged in. Type other option.");
        }else{
        printer.print("Please, type your account ID.");
        String accountId = inputManager.getInput();
        printer.print("Please, type your password.");
        String password = inputManager.getInput();
        security.login(accountId, password);
        }
        return true;
    }

    private boolean personalInfo() {
        printer.print(security.getPersonalInfo());
        return true;
    }

    private boolean returnItem() {
        printer.print("Write the name of the book:");
        if (library.returnBook(inputManager.getInput())) {
            printer.print("Thank you for returning the book.");
        } else {
            printer.print("That is not a valid book to return.");
        }
        return true;
    }


}
