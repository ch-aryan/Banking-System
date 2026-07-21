package versions.v0.result;

import versions.v0.Model.User;

public class LoginResult {
    private static boolean success;
    private static String message;
    private static User user;
    public LoginResult(boolean success, String message, User user){
        this.success = success;
        this.message = message;
        this.user = user;
    }
    public static boolean isSuccess(){
        return success;
    }
    public static String getMessage(){
        return message;
    }
    public static User getUser(){
        return user;
    }
}
