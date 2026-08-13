package versions.v2.utility;

public class IdGenerator {

    private static int nextUserId = 1;

    private static int nextAccountNumber = 100001;

    private IdGenerator() {

    }

    public static int generateUserId() {
        return nextUserId++;
    }

    public static int generateAccountNumber() {
        return nextAccountNumber++;
    }

}