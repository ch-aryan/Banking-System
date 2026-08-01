package versions.v2.console.io;

public class ConsoleContext {

    private final ConsoleReader reader;

    private final ConsolePrinter printer;

    public ConsoleContext(
            ConsoleReader reader,
            ConsolePrinter printer) {

        this.reader = reader;
        this.printer = printer;
    }

    public ConsoleReader getReader() {
        return reader;
    }

    public ConsolePrinter getPrinter() {
        return printer;
    }

}