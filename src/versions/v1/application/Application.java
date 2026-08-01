package versions.v1.application;

import versions.v1.Model.User;
import versions.v1.Service.*;
import versions.v1.repository.UserDatabaseHM;
import versions.v1.result.*;

import java.util.Scanner;

public class Application {


    private final Scanner in = new Scanner(System.in);

    private final UserDatabaseHM database = new UserDatabaseHM();

    private final RegistrationService registration = new RegistrationService(database);

    private final LoginService login = new LoginService(database);

    private final DepositService depositService =
            new DepositService();

    private final WithdrawService withdrawService =
            new WithdrawService();

    private final TransferService transferService =
            new TransferService(database);

    private final TransactionHistoryService transactionHistoryService =
            new TransactionHistoryService();

    public void start() {

        database.loadSampleData();

        System.out.println();
        System.out.println("====================================");
        System.out.println(" Welcome To Aryan Banking System ");
        System.out.println("====================================");

        welcomeMenu();
    }

    private void welcomeMenu() {

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========== MAIN MENU ==========");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose Option : ");

            int choice = in.nextInt();

            switch (choice) {

                case 1:
                    registrationFlow();
                    break;

                case 2:
                    loginFlow();
                    break;

                case 3:
                    running = false;
                    System.out.println("Thank you for visiting Aryan Bank.");
                    break;

                default:
                    System.out.println("Invalid Option.");
            }

        }

    }

    private void registrationFlow() {

        RegisterResult result = registration.register();

        System.out.println();

        if (result.isSuccess()) {

            System.out.println(result.getMessage());

            System.out.println();

            System.out.println("Account Created Successfully");

            System.out.println(result.getAccount());

            System.out.println();

            System.out.println("Please Login to Continue.");

        } else {

            System.out.println(result.getMessage());

        }

    }

    private void loginFlow() {

        LoginResult result = login.reqLogin();

        if (!result.isSuccess()) {

            System.out.println(result.getMessage());

            return;

        }

        System.out.println(result.getMessage());

        bankingMenu(result.getUser());

    }

    private void bankingMenu(User currentUser) {

        boolean loggedIn = true;

        while (loggedIn) {

            System.out.println();

            System.out.println("==============================");
            System.out.println("Welcome " + currentUser.getFullName());
            System.out.println("==============================");

            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Transaction History");
            System.out.println("7. Logout");

            System.out.print("Choose Option : ");

            int choice = in.nextInt();

            switch (choice) {

                case 1:
                    DepositResult depositResult = depositService.deposit(currentUser);
                    System.out.println(depositResult.getMessage());

                    System.out.println("Current Balance : ₹"
                            + depositResult.getBalance());

                    break;
                case 2:
                    WithdrawlResult withdrawlResult = withdrawService.withdraw(currentUser);
                    System.out.println(withdrawlResult.getMessage());

                    System.out.println("Current Balance : ₹" + withdrawlResult.getBalance());
                    break;

                case 3:
                    TransferResult transferResult =
                            transferService.transfer(currentUser);

                    System.out.println(transferResult.getMessage());

                    System.out.println(
                            "Current Balance : ₹"
                                    + transferResult.getBalance()
                    );

                    break;

                case 4:
                    System.out.println("Balance :");
                    System.out.println(currentUser.getBankAccount().getBalance());
                    break;

                case 5:
                    System.out.println(currentUser);
                    break;

                case 6:
                    transactionHistoryService
                            .showTransactionHistory(currentUser);
                    break;

                case 7:
                    loggedIn = false;
                    System.out.println("Logout Successful.");
                    break;

                default:
                    System.out.println("Invalid Option");

            }

        }

    }
}



/* ignore it.

    public void start() {
        databaseHM.loadSampleData();
        Scanner in = new Scanner(System.in);
        System.out.println("Namaste & Welcome to the Aryan's bank");
        System.out.println("Please enter and choose the options" +
                "enter 1 to create registration and enter 2 to login to the bank");

        byte response = in.nextByte();
        if(response ==2){
            //user login
            Login login = new Login(databaseHM);
            LoginResult userLogin = login.reqLogin();
           if(userLogin.isSuccess()){
               System.out.println(userLogin.getMessage());
               menu();
           }else{
               System.out.println(userLogin.getMessage());
           }
        }else{
            //Registration for new members
            Registration registration = new Registration(databaseHM);
          UserResult user = registration.register();
          if(user.isSuccess()){
              User account = user.getAccount();
              System.out.println(account);
              System.out.println(user.getMessage());
              System.out.println("now you can login to our bank");
              Login login = new Login(databaseHM);
              login.reqLogin();

          }else{
              System.out.println(user.getMessage());
          }
        }
    }

    private void menu() {

    }
 */
