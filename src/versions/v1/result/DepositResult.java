package versions.v1.result;

public class DepositResult {

    private boolean success;

    private String message;

    private double balance;

    public DepositResult(boolean success,
                         String message,
                         double balance){

        this.success = success;
        this.message = message;
        this.balance = balance;
    }

    public boolean isSuccess(){
        return success;
    }

    public String getMessage(){
        return message;
    }

    public double getBalance(){
        return balance;
    }

}