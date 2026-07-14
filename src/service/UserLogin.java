package service;


import Model.User;
import Validation.ValidationRules;
import result.LoginResult;

import java.util.ArrayList;

public class UserLogin {
public ArrayList<User> accounts;


    public UserLogin(ArrayList<User> accounts)
    {


        this.accounts = accounts;
    }

  public LoginResult login(String userName, String password){
      if( !ValidationRules.isValidUsername(userName)){
          return new LoginResult(
                  false,
                  "Invalid UserFormat",
                  null);
      }
      if(!ValidationRules.validatePassword(password)) {
          return new LoginResult(
                  false,
                  "Invalid Password Format",
                  null
          );
      }

    User user = findUserName(userName);
            if(user == null)
            {
                return new LoginResult(false, "UserNotFound", null);

            }

            if(!user.getPassword().equals(password)){
                return new LoginResult(
                        false,
                        "Password incorrect",
                        null);

            }

            return new LoginResult(true, "LoginSuccess", user);


       }
       public User findUserName(String userName){
    for(User account : accounts){
        if(account.getUserName().equals(userName)){
            return account;
        }
    }
    return null;
  }


}
/*
  public void login(String userName , String passWord){
        boolean userFound = false;
        for(RegisterAccount i : detials){
            if(i.getUserName().equals(userName)){
                System.out.println("userName is valid");
                if(i.getPassword().equals(passWord)){
                    System.out.println("login succesfull");
                    userFound = true;
                   break;

                }else{
                    System.out.println("password is wrong retry");
                   break;
                }
            }
        }
        if(!userFound ){
            System.out.println("Invalid details");
        }
    }
 */