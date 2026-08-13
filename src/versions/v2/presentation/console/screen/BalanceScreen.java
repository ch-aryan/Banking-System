package versions.v2.presentation.console.screen;

import versions.v2.presentation.console.io.*;
import versions.v2.contract.request.BalanceRequest;
import versions.v2.contract.response.BalanceResponse;
import versions.v2.presentation.controller.banking.BalanceController;
import versions.v2.domain.model.User;

public class BalanceScreen {

    private final ConsolePrinter printer;

    private final BalanceController balanceController;

    public BalanceScreen(
            ConsoleContext console,
            BalanceController balanceController) {

        this.printer = console.getPrinter();
        this.balanceController = balanceController;
    }

    public BalanceResponse show(User user) {

        printer.blankLine();
        printer.header("Check Balance");

        BalanceRequest request =
                new BalanceRequest(user);

        BalanceResponse response =
                balanceController.checkBalance(request);

        printer.info(
                "Current Balance : ₹"
                        + response.getBalance());

        return response;
    }
}