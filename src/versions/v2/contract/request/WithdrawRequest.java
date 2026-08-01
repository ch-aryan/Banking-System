package versions.v2.contract.request;

import versions.v2.domain.model.User;

public class WithdrawRequest {

    private final User user;

    private final double amount;

    private final int pin;

    public WithdrawRequest(
            User user,
            double amount,
            int pin) {

        this.user = user;
        this.amount = amount;
        this.pin = pin;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public int getPin() {
        return pin;
    }

}