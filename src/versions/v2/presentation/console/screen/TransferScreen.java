package versions.v2.presentation.console.screen;

import versions.v2.presentation.console.io.ConsoleContext;
import versions.v2.presentation.console.io.ConsolePrinter;
import versions.v2.presentation.console.io.ConsoleReader;
import versions.v2.contract.request.TransferConfirmationRequest;
import versions.v2.contract.request.TransferLookupRequest;
import versions.v2.contract.response.TransferResponse;
import versions.v2.presentation.controller.banking.TransferController;
import versions.v2.domain.model.User;

public class TransferScreen {

    private final ConsoleReader reader;

    private final ConsolePrinter printer;

    private final TransferController transferController;

    public TransferScreen(
            ConsoleContext console,
            TransferController transferController) {

        this.reader = console.getReader();
        this.printer = console.getPrinter();
        this.transferController = transferController;
    }

    public TransferResponse show(User user) {

        printer.blankLine();
        printer.header("Transfer Money");

        printer.print("Receiver Account Number : ");
        String receiverAccountNumber =
                reader.readLine();

        TransferLookupRequest lookupRequest =
                new TransferLookupRequest(
                        user,
                        receiverAccountNumber);

        TransferResponse lookupResponse =
                transferController.lookupReceiver(
                        lookupRequest);

        if (!lookupResponse.isSuccess()) {

            displayResponse(lookupResponse);
            return lookupResponse;

        }

        printer.println(
                "Receiver Name : "
                        + lookupResponse.getReceiverName());

        printer.print("Continue? (Y/N) : ");
        String choice = reader.readLine();

        if (!choice.equalsIgnoreCase("Y")) {

            TransferResponse cancelledResponse =
                    new TransferResponse(
                            false,
                            "Transfer Cancelled.",
                            user.getBankAccount().getBalance());

            displayResponse(cancelledResponse);
            return cancelledResponse;

        }

        printer.print("Amount : ");
        double amount =
                Double.parseDouble(reader.readLine());

        printer.print("PIN : ");
        int pin =
                Integer.parseInt(reader.readLine());

        TransferConfirmationRequest confirmationRequest =
                new TransferConfirmationRequest(
                        user,
                        receiverAccountNumber,
                        amount,
                        pin);

        TransferResponse response =
                transferController.transfer(
                        confirmationRequest);

        displayResponse(response);

        return response;
    }

    private void displayResponse(
            TransferResponse response) {

        if (response.isSuccess()) {

            printer.success(response.getMessage());

        } else {

            printer.error(response.getMessage());

        }

    }

}
