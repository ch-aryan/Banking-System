package versions.v2.contract.request;


/*
=========================================================
Class : LoginRequest

Layer
DTO Layer

Responsibility
Carries login credentials from the
Presentation Layer to the Service Layer.

Pattern
DTO
=========================================================
*/

public class LoginRequest {

    private final String username;

    private final String password;

    public LoginRequest(
            String username,
            String password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}