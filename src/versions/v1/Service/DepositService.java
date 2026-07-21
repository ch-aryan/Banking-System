package versions.v1.Service;

import versions.v1.Model.BankAccount;
import versions.v1.Model.User;
import versions.v1.Validation.BankValidationRules;
import versions.v1.result.DepositResult;

import java.util.Scanner;

public class DepositService {

    private final Scanner in = new Scanner(System.in);

    public DepositResult deposit(User currentUser) {

        BankAccount account = currentUser.getBankAccount();

        System.out.println("\n========= Deposit Money =========");

        System.out.print("Enter Amount : ");
        double amount = in.nextDouble();

        if (!BankValidationRules.validateDepositAmount(amount)) {
            return new DepositResult(
                    false,
                    "Amount should be greater than 0.",
                    account.getBalance()
            );
        }

        System.out.print("Enter PIN : ");
        int pin = in.nextInt();

        if (!account.verifyPin(pin)) {
            return new DepositResult(
                    false,
                    "Incorrect PIN.",
                    account.getBalance()
            );
        }

        double newBalance = account.getBalance() + amount;

        if (!BankValidationRules.validateMaximumBalance(newBalance)) {
            return new DepositResult(
                    false,
                    "Maximum account balance limit (10,00,000) exceeded.",
                    account.getBalance()
            );
        }

        account.deposit(amount);

        return new DepositResult(
                true,
                "₹" + amount + " deposited successfully.",
                account.getBalance()
        );

    }

}