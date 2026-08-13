package versions.v2.presentation.console.io;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleReader {

    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine().trim();
    }

    public int readInt() {
        return Integer.parseInt(readLine());
    }

    public long readLong() {
        return Long.parseLong(readLine());
    }

    public double readDouble() {
        return Double.parseDouble(readLine());
    }

    public LocalDate readDate() {
        return LocalDate.parse(readLine());
    }

    public boolean readConfirmation() {

        String input = readLine();

        return input.equalsIgnoreCase("Y")
                || input.equalsIgnoreCase("YES");

    }

}