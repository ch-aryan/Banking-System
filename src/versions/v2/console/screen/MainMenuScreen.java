package versions.v2.console.screen;

import versions.v2.console.io.ConsoleContext;
import versions.v2.console.io.ConsolePrinter;
import versions.v2.console.io.ConsoleReader;

/*
=========================================================
Class : MainMenuScreen

Layer
Console Layer

Responsibility

Displays the application's main menu and
returns the user's selected option.

Collaborates With

ConsoleReader

ConsolePrinter

Design Principle

Single Responsibility Principle

Architectural Role

Console Screen

Version
2.0
=========================================================
*/

public class MainMenuScreen {

    private final ConsoleReader reader;

    private final ConsolePrinter printer;

    public MainMenuScreen(
            ConsoleContext console) {

        this.reader = console.getReader();
        this.printer = console.getPrinter();

    }

    public int show() {

        printer.blankLine();

        printer.header("Main Menu");

        printer.println("1. Register");
        printer.println("2. Login");
        printer.println("3. Exit");

        printer.blankLine();

        printer.print("Enter Choice : ");

        return Integer.parseInt(
                reader.readLine());

    }

}