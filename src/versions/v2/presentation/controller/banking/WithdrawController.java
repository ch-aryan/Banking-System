package versions.v2.presentation.controller.banking;

import versions.v2.contract.request.WithdrawRequest;
import versions.v2.contract.response.WithdrawlResponse;
import versions.v2.domain.service.WithdrawService;

public class WithdrawController {

    private final WithdrawService withdrawService;

    public WithdrawController(
            WithdrawService withdrawService) {

        this.withdrawService = withdrawService;

    }

    public WithdrawlResponse withdraw(
            WithdrawRequest request) {

        return withdrawService.withdraw(request);

    }

}