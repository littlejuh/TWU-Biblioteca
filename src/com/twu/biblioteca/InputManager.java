package com.twu.biblioteca;

import java.io.Console;
import java.util.Scanner;

public class InputManager {

    public static String getInputPassword() {
        Console console = System.console();
        /*
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }
        */
        char passwordArray[] = console.readPassword("Enter your Password: ");
        return new String(passwordArray);
    }

    public static String getInput() {
        String selection;
        Scanner input = new Scanner(System.in);
        selection = input.nextLine();
        return selection;
    }
}
