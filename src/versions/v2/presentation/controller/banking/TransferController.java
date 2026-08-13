package versions.v2.presentation.controller.banking;

import versions.v2.contract.request.TransferConfirmationRequest;
import versions.v2.contract.request.TransferLookupRequest;
import versions.v2.contract.response.TransferResponse;
import versions.v2.domain.service.TransferService;

public class TransferController {

    private final TransferService transferService;

    public TransferController(
            TransferService transferService) {

        this.transferService = transferService;

    }

    public TransferResponse lookupReceiver(
            TransferLookupRequest request) {

        return transferService.lookupReceiver(request);

    }

    public TransferResponse transfer(
            TransferConfirmationRequest request) {

        return transferService.transfer(request);

    }

}
