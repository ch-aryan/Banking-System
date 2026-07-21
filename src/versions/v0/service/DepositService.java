package versions.v0.service;

import versions.v0.Model.BankAccount;
import versions.v0.Model.User;
import versions.v0.Validation.BankValidationRules;
import versions.v0.result.DepositResult;

public class DepositService {

    public DepositResult Deposit(User currentUser , double amt){
        BankAccount account =
                currentUser.getBankAccount();
        if(!BankValidationRules.validateDeposit(account.getBalance() + amt)){
            return new DepositResult(
                    false,
                    "Deposit Failed due to limit ",
                    account.getBalance());
        }
        account.DepBalance(amt);
        return new DepositResult(true, "successfully deposited"+ amt, account.getBalance());

    }
}
