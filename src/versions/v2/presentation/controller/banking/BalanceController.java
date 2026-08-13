package versions.v2.presentation.controller.banking;

import versions.v2.contract.request.BalanceRequest;
import versions.v2.contract.response.BalanceResponse;
import versions.v2.domain.service.BalanceService;

public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(
            BalanceService balanceService) {

        this.balanceService = balanceService;

    }

    public BalanceResponse checkBalance(
            BalanceRequest request) {

        return balanceService.checkBalance(request);

    }

}