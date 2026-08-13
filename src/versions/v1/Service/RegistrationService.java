package versions.v1.Service;


import versions.v1.Model.BankAccount;
import versions.v1.Model.User;
import versions.v1.result.RegisterResult;
import versions.v1.repository.UserDatabaseHM;
import versions.v1.Validation.ValidationRules;
import versions.v1.utility.IdGenerator;

import java.time.LocalDate;


import java.util.Scanner;

public class RegistrationService {
    Scanner in = new Scanner(System.in);
    UserDatabaseHM databaseHM;
    public RegistrationService(UserDatabaseHM storeUser){
        this.databaseHM = storeUser;
    }
    public RegisterResult register(){
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
            return new RegisterResult(false, "Enter proper name", null);
        }
        if(!ValidationRules.isValidUsername(username)){
            return new RegisterResult(false, "please set userName properly", null);
        }
        if(databaseHM.userExist(username)){
            return new RegisterResult(false, "userName already exist please" +
                    "select another one", null);
        }

        if(!ValidationRules.validatePassword(password)){
            return new RegisterResult(false, "please set proper password", null);
        }



        Integer id = IdGenerator.generateUserId();
        Integer accountNumber = IdGenerator.generateAccountNumber();

        BankAccount userBankAccount = new BankAccount(accountNumber, fullName,
               pin );

        User user = new User(id, username, password, fullName, userBankAccount,dob);

        databaseHM.storeUser(username, user);
        return new RegisterResult(true," registration done successfully",
                user);
    }
}
