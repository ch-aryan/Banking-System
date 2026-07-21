package versions.v1.Model;

import java.sql.Date;

public class BankAccount {

    private final Integer accountNumber;
    private final String accountHolderName;
    private final Date createdAt;
    private final Integer pin;

    private double balance;

    public BankAccount(Integer accountNumber,
                       String accountHolderName,
                       Integer pin) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.createdAt = new Date(System.currentTimeMillis());

        this.balance = 0.0;
    }

    // ----------------------------
    // Business Methods
    // ----------------------------

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public boolean verifyPin(int enteredPin) {
        return pin.equals(enteredPin);
    }

    // ----------------------------
    // Getters
    // ----------------------------

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return """
                -----------------------------
                Account Number : %d
                Holder Name    : %s
                Balance        : %.2f
                Created At     : %s
                -----------------------------
                """
                .formatted(
                        accountNumber,
                        accountHolderName,
                        balance,
                        createdAt
                );
    }
}




/*
 @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", createdAt=" + createdAt +
                ", balance=" + balance +
                '}';
    }
 */
