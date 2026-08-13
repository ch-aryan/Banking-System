package versions.v2.presentation.controller.banking;

import versions.v2.contract.request.DepositRequest;
import versions.v2.contract.response.DepositResponse;
import versions.v2.domain.service.DepositService;

public class DepositController {

    private final DepositService depositService;

    public DepositController(
            DepositService depositService) {

        this.depositService = depositService;

    }

    public DepositResponse deposit(
            DepositRequest request) {

        return depositService.deposit(request);

    }

}