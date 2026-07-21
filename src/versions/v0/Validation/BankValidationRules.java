package versions.v0.Validation;

public class BankValidationRules {

    public static boolean validateDeposit(Double amt){
        if(amt <= 0 || amt > 1000000){
           return false;
        }
      return true;

    }
    public static boolean validateWithdrawl(Double amt){
        if(amt <= 0 ){
            return false;
        }
        if(amt > 1000000){
            return false;
        }

        return true;
    }



    public static boolean validatePin(Integer pin){
        int len = 0;
        int temp = pin;
        while(temp > 0){
            temp = temp / 10;
            len++;
        }
        if(len == 4 || len == 6){
            return true;
        }
        return false;
    }

//    validateMaximumBalance()
//
//    validateMinimumBalance()

}
