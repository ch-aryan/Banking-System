package versions.v2.presentation.console.screen;

import versions.v2.presentation.console.io.ConsoleContext;
import versions.v2.presentation.console.io.ConsolePrinter;
import versions.v2.presentation.console.io.ConsoleReader;
import versions.v2.contract.request.DepositRequest;
import versions.v2.contract.response.DepositResponse;
import versions.v2.presentation.controller.banking.DepositController;
import versions.v2.domain.model.User;

public class DepositScreen {

    private final ConsoleReader reader;
    private final ConsolePrinter printer;

    private final DepositController depositController;

    public DepositScreen(
            ConsoleContext console,
            DepositController depositController) {

        this.reader = console.getReader();
        this.printer = console.getPrinter();
        this.depositController = depositController;
    }

    public DepositResponse show(User user) {

        printer.blankLine();
        printer.header("Deposit");

        printer.print("Amount : ");
        double amount =
                Double.parseDouble(reader.readLine());

        printer.print("PIN : ");
        int pin =
                Integer.parseInt(reader.readLine());

        DepositRequest request =
                new DepositRequest(
                        user,
                        amount,
                        pin);

        DepositResponse response =
                depositController.deposit(request);

        displayResponse(response);

        return response;
    }

    private void displayResponse(
            DepositResponse response) {

        if(response.isSuccess()){

            printer.success(response.getMessage());

        }else{

            printer.error(response.getMessage());

        }

    }

}