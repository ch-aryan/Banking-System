package versions.v1.Service;

import versions.v1.Model.BankAccount;
import versions.v1.Model.User;
import versions.v1.Validation.BankValidationRules;
import versions.v1.result.WithdrawlResult;

import java.util.Scanner;

public class WithdrawService {

    private final Scanner in = new Scanner(System.in);

    public WithdrawlResult withdraw(User currentUser) {

        BankAccount account = currentUser.getBankAccount();

        System.out.println("\n========= Withdraw Money =========");

        System.out.print("Enter Amount : ");
        double amount = in.nextDouble();

        if (!BankValidationRules.validateWithdrawAmount(amount)) {
            return new WithdrawlResult(
                    false,
                    "Amount should be greater than 0.",
                    account.getBalance()
            );
        }

        System.out.print("Enter PIN : ");
        int pin = in.nextInt();

        if (!account.verifyPin(pin)) {
            return new WithdrawlResult(
                    false,
                    "Incorrect PIN.",
                    account.getBalance()
            );
        }

        if (!BankValidationRules.validateSufficientBalance(
                account.getBalance(),
                amount)) {

            return new WithdrawlResult(
                    false,
                    "Insufficient Balance.",
                    account.getBalance()
            );
        }

        account.withdraw(amount);

        return new WithdrawlResult(
                true,
                "₹" + amount + " withdrawn successfully.",
                account.getBalance()
        );

    }

}