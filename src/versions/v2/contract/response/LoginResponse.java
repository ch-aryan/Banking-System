package versions.v2.contract.response;

import versions.v2.domain.model.User;

public class LoginResponse {

    private final boolean success;

    private final String message;

    private final User user;

    public LoginResponse(
            boolean success,
            String message,
            User user) {

        this.success = success;
        this.message = message;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

}
