package versions.v1.Service;

import versions.v1.Model.BankAccount;
import versions.v1.Model.Transaction;
import versions.v1.Model.TransactionType;
import versions.v1.Model.User;
import versions.v1.repository.UserDatabaseHM;
import versions.v1.Validation.BankValidationRules;
import versions.v1.result.TransferResult;

import java.util.Scanner;

public class TransferService {

    private final Scanner in = new Scanner(System.in);

    private final UserDatabaseHM database;

    public TransferService(UserDatabaseHM database) {
        this.database = database;
    }

    public TransferResult transfer(User currentUser) {

        BankAccount sender = currentUser.getBankAccount();

        System.out.println("\n========= Transfer Money =========");

        System.out.print("Enter Receiver Account Number : ");
        Integer receiverAccountNumber = in.nextInt();

        User receiverUser =
                database.findByAccountNumber(receiverAccountNumber);

        if (receiverUser == null) {

            return new TransferResult(
                    false,
                    "Receiver account does not exist.",
                    sender.getBalance()
            );
        }

        BankAccount receiver = receiverUser.getBankAccount();

        // Prevent self transfer
        if (sender.getAccountNumber()
                .equals(receiver.getAccountNumber())) {

            return new TransferResult(
                    false,
                    "Cannot transfer money to your own account.",
                    sender.getBalance()
            );
        }

        System.out.println("Receiver Name : "
                + receiver.getAccountHolderName());

        System.out.print("Continue? (Y/N) : ");

        String choice = in.next();

        if (!choice.equalsIgnoreCase("Y")) {

            return new TransferResult(
                    false,
                    "Transfer Cancelled.",
                    sender.getBalance()
            );
        }

        System.out.print("Enter Amount : ");

        double amount = in.nextDouble();

        if (!BankValidationRules.validateTransferAmount(amount)) {

            return new TransferResult(
                    false,
                    "Invalid transfer amount.",
                    sender.getBalance()
            );
        }

        if (!BankValidationRules.validateSufficientBalance(
                sender.getBalance(),
                amount)) {

            return new TransferResult(
                    false,
                    "Insufficient Balance.",
                    sender.getBalance()
            );
        }

        double receiverBalance =
                receiver.getBalance() + amount;

        if (!BankValidationRules.validateMaximumBalance(receiverBalance)) {

            return new TransferResult(
                    false,
                    "Receiver account exceeds maximum balance.",
                    sender.getBalance()
            );
        }

        System.out.print("Enter PIN : ");

        int pin = in.nextInt();

        if (!sender.verifyPin(pin)) {

            return new TransferResult(
                    false,
                    "Incorrect PIN.",
                    sender.getBalance()
            );
        }

        sender.withdraw(amount);
        Transaction senderTransaction = new Transaction(
                TransactionType.TRANSFER,
                amount,
                "Transferred to Account " +
                        receiverUser.getBankAccount().getAccountNumber(),
                sender.getBalance()
        );

         currentUser.getBankAccount().addTransaction(senderTransaction);

        receiver.deposit(amount);
        Transaction receiverTransaction = new Transaction(
                TransactionType.RECEIVED,
                amount,
                "Received from Account " +
                        currentUser.getBankAccount().getAccountNumber(),
                receiver.getBalance()
        );

        receiverUser.getBankAccount().addTransaction(receiverTransaction);

        return new TransferResult(
                true,
                "₹" + amount + " transferred successfully to "
                        + receiver.getAccountHolderName(),
                sender.getBalance()
        );
    }

}