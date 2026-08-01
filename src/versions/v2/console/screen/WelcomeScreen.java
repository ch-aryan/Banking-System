package versions.v2.console.screen;

import versions.v2.console.io.ConsolePrinter;

public class WelcomeScreen {


    private final ConsolePrinter printer;

    public WelcomeScreen(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void show() {

        printer.blankLine();

        printer.separator();

        printer.println("Welcome To Aryan Banking");

        printer.separator();

    }

}