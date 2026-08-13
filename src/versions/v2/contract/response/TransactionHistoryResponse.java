package versions.v2.contract.response;

import versions.v2.domain.model.Transaction;

import java.util.List;

public class TransactionHistoryResponse {

    private final boolean success;

    private final String message;

    private final List<Transaction> transactions;

    public TransactionHistoryResponse(
            boolean success,
            String message,
            List<Transaction> transactions) {

        this.success = success;
        this.message = message;
        this.transactions = transactions;

    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

}
