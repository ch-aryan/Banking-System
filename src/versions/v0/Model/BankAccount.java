package versions.v0.Model;

public class BankAccount {
    private final Integer accountNumber;
    private final String accountHolderName;
    private final Integer pin;
    private Double balance;

    public BankAccount( Integer accountNumber, Integer pin , String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;

    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void DepBalance(Double amt){
        balance = balance+amt;
    }
    public void WithBalance(Double amt){
        balance = balance - amt;
    }

    public Double getBalance() {
        return balance;
    }

    public boolean verifyPin(int enteredPin){

        return pin == enteredPin;

    }
    public void displayDetails(){

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : " + balance);

    }


}
