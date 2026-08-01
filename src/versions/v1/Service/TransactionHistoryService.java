package versions.v1.Service;


import versions.v1.Model.BankAccount;
import versions.v1.Model.Transaction;
import versions.v1.Model.User;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionHistoryService
{

    public void showTransactionHistory(User user)
    {
        BankAccount account = user.getBankAccount();

        List<Transaction> transactions =
                account.getTransactionHistory();

        if(transactions.isEmpty())
        {
            System.out.println();
            System.out.println("No transactions found.");
            return;
        }

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println();
        System.out.println("========== Transaction History ==========");

        for(Transaction transaction : transactions)
        {
            System.out.println("-----------------------------------------");
            System.out.println("Transaction Id : "
                    + transaction.getTransactionId());

            System.out.println("Type           : "
                    + transaction.getTransactionType());

            System.out.println("Amount         : ₹"
                    + transaction.getAmount());

            System.out.println("Date & Time    : "
                    + transaction.getDateTime().format(formatter));

            System.out.println("Description    : "
                    + transaction.getDescription());

            System.out.println("Balance        : ₹"
                    + transaction.getBalanceAfterTransaction());
        }

        System.out.println("-----------------------------------------");
    }
}