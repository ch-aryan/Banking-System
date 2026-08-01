package versions.v2.contract.request;

import versions.v2.domain.model.User;

public class DepositRequest {

    private final User user;

    private final double amount;

    public DepositRequest(
            User user,
            double amount) {

        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

}