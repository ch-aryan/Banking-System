package service;

import Model.BankAccount;
import Model.User;
import Validation.BankValidationRules;
import result.WithdrawlResult;

public class WithdrawlService {


    public WithdrawlResult withdraw(User currentUser , double amt) {
        BankAccount account = currentUser.getBankAccount();
        if(amt == 0) return new WithdrawlResult(false, "cannot be zero", account.getBalance());
        if (!BankValidationRules.validateWithdrawl(account.getBalance() - amt)) {
            return new WithdrawlResult(
                    false,
                    "Deposit Failed due to limit ",
                    account.getBalance());
        }
        account.WithBalance(amt);
        return new WithdrawlResult(true, "successfully withdraw "+amt, account.getBalance());

    }
}
