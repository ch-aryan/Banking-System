package versions.v2.contract.response;

public class BalanceResponse {

    private final boolean success;

    private final String message;

    private final double balance;

    public BalanceResponse(
            boolean success,
            String message,
            double balance) {

        this.success = success;
        this.message = message;
        this.balance = balance;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public double getBalance() {
        return balance;
    }

}