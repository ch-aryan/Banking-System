package versions.v2.presentation.console.screen;

import versions.v2.presentation.console.io.ConsoleContext;
import versions.v2.presentation.console.io.ConsolePrinter;
import versions.v2.contract.request.TransactionHistoryRequest;
import versions.v2.contract.response.TransactionHistoryResponse;
import versions.v2.presentation.controller.banking.TransactionHistoryController;
import versions.v2.domain.model.Transaction;
import versions.v2.domain.model.User;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionHistoryScreen {

    private final ConsolePrinter printer;

    private final TransactionHistoryController transactionHistoryController;

    public TransactionHistoryScreen(
            ConsoleContext console,
            TransactionHistoryController controller) {

        this.printer = console.getPrinter();
        this.transactionHistoryController = controller;

    }

    public TransactionHistoryResponse show(User user) {

        TransactionHistoryRequest request =
                new TransactionHistoryRequest(user);

        TransactionHistoryResponse response =
                transactionHistoryController.getHistory(request);

        List<Transaction> transactions =
                response.getTransactions();

        if (transactions.isEmpty()) {

            printer.blankLine();
            printer.println("No transactions found.");
            return response;

        }

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss");

        printer.blankLine();
        printer.println(
                "========== Transaction History ==========");

        for (Transaction transaction : transactions) {

            printer.println(
                    "-----------------------------------------");
            printer.println(
                    "Transaction Id : "
                            + transaction.getTransactionId());
            printer.println(
                    "Type           : "
                            + transaction.getTransactionType());
            printer.println(
                    "Amount         : ₹"
                            + transaction.getAmount());
            printer.println(
                    "Date & Time    : "
                            + transaction.getDateTime()
                            .format(formatter));
            printer.println(
                    "Description    : "
                            + transaction.getDescription());
            printer.println(
                    "Balance        : ₹"
                            + transaction.getBalanceAfterTransaction());

        }

        printer.println(
                "-----------------------------------------");

        return response;

    }

}
