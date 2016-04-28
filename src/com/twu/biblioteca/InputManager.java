package com.twu.biblioteca;

import java.io.Console;
import java.util.Scanner;

public class InputManager {

    private final Scanner scanner;
    private final Console console;

    public InputManager(Console console, Scanner scanner) {
        this.console = console;
        this.scanner = scanner;
    }

    public String getInputPassword() {
        char passwordArray[] = console.readPassword("Enter your Password: ");
        return new String(passwordArray);
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
