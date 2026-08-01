package versions.v2.contract.request;
/*
=========================================================
Class : TransferLookupRequest

Layer
DTO Layer

Responsibility
Carries the receiver account number entered
by the sender for account verification.

Design Pattern
Data Transfer Object (DTO)

Why it exists
Allows the service to search for the receiver
without exposing repository details to the
Presentation Layer.

Contains
Only user input.

Spring Boot Equivalent
@RequestBody TransferLookupRequest
=========================================================
*/

public class TransferLookupRequest {

    private final String receiverAccountNumber;

    public TransferLookupRequest(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

}