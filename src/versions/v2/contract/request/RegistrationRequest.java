package versions.v2.contract.request;


import java.time.LocalDate;

/*
=========================================================
Class : RegistrationRequest

Layer
DTO Layer

Responsibility
Carries user registration data from the
Presentation Layer to the Service Layer.

Design Pattern
Data Transfer Object (DTO)

Why it exists
Decouples user input from business logic.

Contains
Only data.
No business logic.
No validation.
No database operations.

Spring Boot Equivalent
@RequestBody RegistrationRequest
=========================================================
*/


public class RegistrationRequest {

    private final String fullName;

    private final String dateOfBirth;

    private final String gender;

    private final String username;

    private final String password;

    public RegistrationRequest(
            String fullName,
            String dateOfBirth,
            String gender,
            String username,
            String password) {

        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}