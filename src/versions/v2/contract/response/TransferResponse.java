package versions.v2.contract.response;

public class TransferResponse {

    private final boolean success;

    private final String message;

    private final double balance;

    private final String receiverName;

    public TransferResponse(
            boolean success,
            String message,
            double balance) {

        this(success, message, balance, null);
    }

    public TransferResponse(
            boolean success,
            String message,
            double balance,
            String receiverName) {

        this.success = success;
        this.message = message;
        this.balance = balance;
        this.receiverName = receiverName;
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

    public String getReceiverName() {
        return receiverName;
    }

}
