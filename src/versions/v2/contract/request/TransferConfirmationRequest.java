package versions.v2.contract.request;

import versions.v2.domain.model.User;

public class TransferConfirmationRequest {

    private final User user;

    private final String receiverAccountNumber;

    private final double amount;

    private final int pin;

    public TransferConfirmationRequest(
            User user,
            String receiverAccountNumber,
            double amount,
            int pin) {

        this.user = user;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.pin = pin;
    }

    public User getUser() {
        return user;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public int getPin() {
        return pin;
    }

}
