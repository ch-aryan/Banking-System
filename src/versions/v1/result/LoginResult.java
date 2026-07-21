package versions.v1.result;

import versions.v1.Model.User;

public class LoginResult {
    private static boolean success;
    private static String message;
    private static User user;
    public LoginResult(boolean success, String message, User user){
        this.success = success;
        this.message = message;
        this.user = user;
    }
    public boolean isSuccess(){
        return success;
    }
    public  String getMessage(){
        return message;
    }
    public  User getUser(){
        return user;
    }
}
