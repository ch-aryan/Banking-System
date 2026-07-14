package result;

import Model.User;

public class UserResult {
    private boolean success;
    private String message;
    private User account;

    public UserResult(boolean success, String message, User account){
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
