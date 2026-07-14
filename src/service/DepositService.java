package service;

import Model.BankAccount;
import Model.User;
import Validation.BankValidationRules;
import result.DepositResult;

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
