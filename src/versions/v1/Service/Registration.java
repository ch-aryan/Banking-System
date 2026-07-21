package versions.v1.Service;


import versions.v1.Model.BankAccount;
import versions.v1.Model.User;
import versions.v1.result.UserResult;
import versions.v1.UserDatabaseHM;
import versions.v1.Validation.ValidationRules;
import versions.v1.util.IdGenerator;

import java.time.LocalDate;


import java.util.Scanner;

public class Registration {
    Scanner in = new Scanner(System.in);
    UserDatabaseHM databaseHM;
    public Registration(UserDatabaseHM storeUser){
        this.databaseHM = storeUser;
    }
    public UserResult register(){
        System.out.println("Registration form");
        System.out.println("enter your fullName");
        String fullName = in.nextLine();
        System.out.println("Enter your Dob");
        LocalDate dob = null;

        while (dob == null) {

            System.out.print("Enter DOB (yyyy-MM-dd): ");

            String input = in.next();

            try {

                dob = LocalDate.parse(input);

            } catch (Exception e) {

                System.out.println("Invalid date format.");
                System.out.println("Example: 2003-08-14");
            }
        }
        System.out.println("Enter your username");
        String username = in.next();
        System.out.println("Enter your password");
        String password = in.next();
        System.out.println("Set pin");
        Integer pin = in.nextInt();
        System.out.println("thanks for submitting");


        if(!ValidationRules.validateFullName(fullName)){
            return new UserResult(false, "Enter proper name", null);
        }
        if(!ValidationRules.isValidUsername(username)){
            return new UserResult(false, "please set userName properly", null);
        }
        if(databaseHM.userExist(username)){
            return new UserResult(false, "userName already exist please" +
                    "select another one", null);
        }

        if(!ValidationRules.validatePassword(password)){
            return new UserResult(false, "please set proper password", null);
        }



        Integer id = IdGenerator.generateUserId();
        Integer accountNumber = IdGenerator.generateAccountNumber();

        BankAccount userBankAccount = new BankAccount(accountNumber, fullName,
               pin );

        User user = new User(id, username, password, fullName, userBankAccount,dob);

        databaseHM.storeUser(username, user);
        return new UserResult(true," registration done successfully",
                user);
    }
}
