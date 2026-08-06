package versions.v2.contract.request;

import versions.v2.domain.model.User;

public class TransferLookupRequest {

    private final User user;

    private final String receiverAccountNumber;

    public TransferLookupRequest(
            User user,
            String receiverAccountNumber) {

        this.user = user;
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public User getUser() {
        return user;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

}
