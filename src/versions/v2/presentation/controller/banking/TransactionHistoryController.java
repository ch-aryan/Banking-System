package versions.v2.presentation.controller.banking;

import versions.v2.contract.request.TransactionHistoryRequest;
import versions.v2.contract.response.TransactionHistoryResponse;
import versions.v2.domain.service.TransactionHistoryService;

public class TransactionHistoryController {

    private final TransactionHistoryService transactionHistoryService;

    public TransactionHistoryController(
            TransactionHistoryService transactionHistoryService) {

        this.transactionHistoryService = transactionHistoryService;

    }

    public TransactionHistoryResponse getHistory(
            TransactionHistoryRequest request) {

        return transactionHistoryService.getHistory(request);

    }

}
