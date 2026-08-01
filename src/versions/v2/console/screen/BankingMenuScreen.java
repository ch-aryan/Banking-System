package versions.v2.console.screen;

import versions.v2.console.io.ConsoleContext;
import versions.v2.console.io.ConsolePrinter;
import versions.v2.console.io.ConsoleReader;

/*
=========================================================
Class : BankingMenuScreen

Layer
Console Layer

Responsibility

Displays the authenticated user's banking
menu and returns the selected option.

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

public class BankingMenuScreen {

    private final ConsoleReader reader;

    private final ConsolePrinter printer;

    public BankingMenuScreen(
            ConsoleContext console) {

        this.reader = console.getReader();
        this.printer = console.getPrinter();

    }

    public int show() {

        printer.blankLine();

        printer.header("Banking Menu");

        printer.println("1. Deposit");
        printer.println("2. Withdraw");
        printer.println("3. Transfer");
        printer.println("4. Balance");
        printer.println("5. Transaction History");
        printer.println("6. Logout");

        printer.blankLine();

        printer.print("Enter Choice : ");

        return Integer.parseInt(
                reader.readLine());

    }

}