package versions.v2.contract.request;

import versions.v2.domain.model.User;

public class BalanceRequest {

    private final User user;

    public BalanceRequest(User user) {

        this.user = user;

    }

    public User getUser() {

        return user;

    }

}