package versions.v1.Service;

import versions.v1.result.LoginResult;
import versions.v1.Model.User;
import versions.v1.UserDatabaseHM;
import versions.v1.Validation.ValidationRules;
import versions.v1.result.UserResult;


import java.util.Scanner;

public class Login {
    Scanner in = new Scanner(System.in);
    UserDatabaseHM login;
    public Login(UserDatabaseHM login){
        this.login = login;
    }
    public LoginResult reqLogin() {
        System.out.println("User Login service");
        System.out.println("Enter your userName");
        String userName = in.next();
        System.out.println("Enter your password");
        String passWord = in.next();

     if(!ValidationRules.isValidUsername(userName)){
         return new LoginResult(false, "Invalid useName", null);
     }
     if(!ValidationRules.validatePassword(passWord)) {
         return new LoginResult(false, "Invalid password", null);
     }

         User user = login.verifyCredentials(userName, passWord);
         if(user == null){
             return new LoginResult(false, "Invalid userName or password", null);
         }

         return new LoginResult(true, "login successfull", user);
     }



    }

