package versions.v2.controller.authentication;

import versions.v2.contract.request.RegistrationRequest;
import versions.v2.contract.response.RegistrationResponse;
import versions.v2.domain.service.RegistrationService;

public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(
            RegistrationService registrationService) {

        this.registrationService = registrationService;

    }

    /**
     * Handles user registration.
     *
     * @param request Registration details.
     * @return RegistrationResponse
     */
    public RegistrationResponse register(
            RegistrationRequest request) {

        return registrationService.register(request);

    }

}