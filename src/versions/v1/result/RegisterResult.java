package versions.v1.result;

import versions.v1.Model.User;

public class RegisterResult {
    private boolean success;
    private String message;
    private User account;

    public RegisterResult(boolean success, String message, User account){
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
