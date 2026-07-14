package service;

import Model.BankAccount;
import Model.User;
import Validation.BankValidationRules;
import Validation.ValidationRules;
import result.UserResult;
import util.IdGenerator;

import java.util.ArrayList;

public class UserRegistration {
    private ArrayList<User> users;
    public UserRegistration(ArrayList<User> users){
        this.users = users;
    }
    public UserResult register(String fullName, String userName, String password, int pin){
        if(!ValidationRules.validateFullName(fullName)){
            System.out.println(fullName + "should follow the guidelines");
            return new UserResult(false, "full Name cannot be added", null);
        }
        if(!ValidationRules.isValidUsername(userName)){
            System.out.println(userName+" is not proper name ");
            return new UserResult(false, "userName must accept the rules", null);
        }
        if(!ValidationRules.validatePassword(password)){
            return new UserResult(false,"password is not accepted", null);
        }
      if(existByUserName(userName) ){
          System.out.println(userName + " is taken");
          return new UserResult(false,"UserName already exsist", null);
      }
        if(!BankValidationRules.validatePin(pin)) {

            return new UserResult(
                    false,
                    "Invalid PIN",
                    null
            );
        }
        int userId = IdGenerator.generateUserId();

        int accountNumber = IdGenerator.generateAccountNumber();

        BankAccount account = new BankAccount(accountNumber, pin, fullName);

        User user =
                new User(
                       userId,
                        userName,
                        password,
                        fullName,
                        account
                );

     users.add(user);
        return new UserResult(
                true,
                user.getFullName() + "Registration Successful",
                user
        );
    }

    private boolean existByUserName(String userName) {
        for(User account : users){
            if(account.getUserName().equals(userName)){
                return true;
            }

        }
        return false;
    }

}
