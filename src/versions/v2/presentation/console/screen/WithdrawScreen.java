package versions.v2.presentation.console.screen;

import versions.v2.presentation.console.io.*;
import versions.v2.contract.request.WithdrawRequest;
import versions.v2.contract.response.WithdrawlResponse;
import versions.v2.presentation.controller.banking.WithdrawController;
import versions.v2.domain.model.User;

public class WithdrawScreen {

    private final ConsoleReader reader;
    private final ConsolePrinter printer;

    private final WithdrawController withdrawController;

    public WithdrawScreen(
            ConsoleContext console,
            WithdrawController withdrawController) {

        this.reader = console.getReader();
        this.printer = console.getPrinter();
        this.withdrawController = withdrawController;
    }

    public WithdrawlResponse show(User user) {

        printer.blankLine();
        printer.header("Withdraw");

        printer.print("Amount : ");
        double amount =
                Double.parseDouble(reader.readLine());

        printer.print("PIN : ");
        int pin =
                Integer.parseInt(reader.readLine());

        WithdrawRequest request =
                new WithdrawRequest(
                        user,
                        amount,
                        pin);

        WithdrawlResponse response =
                withdrawController.withdraw(request);

        displayResponse(response);

        return response;
    }

    private void displayResponse(
            WithdrawlResponse response){

        if(response.isSuccess()){

            printer.success(response.getMessage());

        }else{

            printer.error(response.getMessage());

        }

    }

}