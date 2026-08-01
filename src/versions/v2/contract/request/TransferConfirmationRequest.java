package versions.v2.contract.request;


/*
=========================================================
Class : TransferConfirmationRequest

Layer
DTO Layer

Responsibility
Carries the information required to perform
the actual money transfer after the receiver
has been verified.

Design Pattern
Data Transfer Object (DTO)

Why it exists
Separates receiver verification from the
actual transfer operation.

Contains
Only information entered by the sender
during confirmation.

Spring Boot Equivalent
@RequestBody TransferConfirmationRequest
=========================================================
*/

public class TransferConfirmationRequest {

    private final String receiverAccountNumber;

    private final double amount;

    private final int pin;

    public TransferConfirmationRequest(
            String receiverAccountNumber,
            double amount,
            int pin) {

        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.pin = pin;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public int getPin() {
        return pin;
    }

}
