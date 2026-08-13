package versions.v2.contract.response;

public class WithdrawlResponse {

    private boolean success;

    private String message;

    private double balance;

    public WithdrawlResponse(boolean success,
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