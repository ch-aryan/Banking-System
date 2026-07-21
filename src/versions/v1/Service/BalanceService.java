package versions.v1.Service;

import versions.v1.Model.User;

public class BalanceService {
    public double showBankBalance(User currentUser){
       return currentUser.getBankAccount().getBalance();
    }
}
