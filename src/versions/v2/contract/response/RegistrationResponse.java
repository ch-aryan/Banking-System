package versions.v2.contract.response;

import versions.v2.domain.model.User;

public class RegistrationResponse {
    private boolean success;
    private String message;
    private User account;

    public RegistrationResponse(boolean success, String message, User account){
        this.account = account;
        this.message = message;
        this.success = success;
    }
    public boolean isSuccess(){
        return success;
    }
    public String  getMessage(){
        return message;
    }
    public User getAccount(){
        return account;
    }


}
