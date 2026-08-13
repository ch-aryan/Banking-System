package versions.v2.contract.request;

import versions.v2.domain.model.User;

public class TransactionHistoryRequest {

    private final User user;

    public TransactionHistoryRequest(User user) {

        this.user = user;

    }

    public User getUser() {

        return user;

    }

}
