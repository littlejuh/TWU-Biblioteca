package com.twu.biblioteca;

import java.io.Console;
import java.util.Scanner;

public class InputManager {

    private final Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
