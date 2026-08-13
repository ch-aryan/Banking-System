package versions.v1.Validation;

public class BankValidationRules {

    private static final double MAX_BALANCE = 1_000_000;
    private static final double MIN_AMOUNT = 0;

    private BankValidationRules() {

    }

    // -------------------------
    // Deposit Validations
    // -------------------------

    public static boolean validateDepositAmount(double amount) {
        return amount > MIN_AMOUNT;
    }

    public static boolean validateMaximumBalance(double balanceAfterDeposit) {
        return balanceAfterDeposit <= MAX_BALANCE;
    }

    // -------------------------
    // Withdraw Validations
    // -------------------------

    public static boolean validateWithdrawAmount(double amount) {
        return amount > MIN_AMOUNT;
    }

    public static boolean validateSufficientBalance(double balance,
                                                    double amount) {

        return balance >= amount;
    }

    public static boolean validateTransferAmount(double amount) {
        return amount > MIN_AMOUNT;
    }

    // -------------------------
    // PIN Validation
    // -------------------------

    public static boolean validatePinFormat(int pin) {

        int length = String.valueOf(pin).length();

        return length == 4 || length == 6;
    }

}