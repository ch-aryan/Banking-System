package versions.v2.presentation.console.screen;

import versions.v2.presentation.console.io.ConsoleContext;
import versions.v2.contract.request.LoginRequest;
import versions.v2.contract.response.LoginResponse;
import versions.v2.presentation.controller.authentication.LoginController;

public class LoginScreen {

    private final ConsoleContext console;

    private final LoginController loginController;

    public LoginScreen(
            ConsoleContext console,
            LoginController loginController) {

        this.console = console;
        this.loginController = loginController;
    }

    /**
     * Displays the Login Screen.
     */
    public LoginResponse show() {

        console.getPrinter().blankLine();

        console.getPrinter().header("Login");

        console.getPrinter().print("Username : ");
        String username =
                console.getReader().readLine();

        console.getPrinter().print("Password : ");
        String password =
                console.getReader().readLine();

        LoginRequest request =
                new LoginRequest(username, password);

        LoginResponse result =
                loginController.login(request);

        displayResponse(result);

        return result;
    }

    /**
     * Displays the login response.
     */
    private void displayResponse(LoginResponse result) {

        if (result.isSuccess()) {

            console.getPrinter().success(result.getMessage());

        } else {

            console.getPrinter().error(result.getMessage());

        }

    }

}