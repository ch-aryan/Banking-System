package versions.v2.presentation.controller.authentication;

import versions.v2.contract.request.LoginRequest;
import versions.v2.contract.response.LoginResponse;
import versions.v2.domain.service.LoginService;

public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {

        this.loginService = loginService;

    }

    /**
     * Handles the login use case.
     *
     * @param request Login details entered by the user.
     * @return LoginResponse containing the outcome.
     */
    public LoginResponse login(LoginRequest request) {

        return loginService.login(request);

    }

}