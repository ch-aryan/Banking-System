package versions.v0;

import versions.v0.Model.User;

import versions.v0.Session.Session;
import versions.v0.result.DepositResult;
import versions.v0.result.LoginResult;
import versions.v0.result.UserResult;
import versions.v0.result.WithdrawlResult;
import versions.v0.service.DepositService;
import versions.v0.service.UserLogin;
import versions.v0.service.UserRegistration;
import versions.v0.service.WithdrawlService;

import java.util.ArrayList;

class Main{
    public static void main(String[] args) {
        ArrayList<User> users1 = new ArrayList<>();
//        RegisterAccount acc1 = new RegisterAccount(1,"ch_aryan1", "Aryan@123");
//        RegisterAccount acc2 = new RegisterAccount(2, "Bhavana_12", "HelloWorld");
//        RegisterAccount acc3 = new RegisterAccount(3, "bhai", "321");
//        accountArrayList.add(acc1);
//        accountArrayList.add(acc2);
//        accountArrayList.add(acc3);

        UserRegistration registration = new UserRegistration(users1);
        UserLogin login = new UserLogin(users1);
        Session session = new Session();
        // ============================
        // Register Users
        // ============================

        UserResult r1 = registration.register("Aryan Chilkeshwaram ","ch_aryan1", "Aryan@123", 123456);
        System.out.println(r1.getMessage());

        UserResult r2 = registration.register("Bhavana Chilkeshwaram","Bhavana_12", "Hello1@World", 1408);
        System.out.println(r2.getMessage());

        UserResult r3 = registration.register("bhai", "Hello321", "1233", 888);
        System.out.println(r3.getMessage());

        UserResult r4 = registration.register("hel","ch_aryan155", "Another@123", 1300);
        System.out.println(r4.getMessage());

        UserResult r5 = registration.register("Aryan", "ch_ary1", "password123", 124);
        System.out.println(r5.getMessage());



        System.out.println("\n================ LOGIN ================\n");



        LoginResult chAryan1 = login.login("ch_aryan1", "Aryan@123");
        System.out.println(chAryan1.getMessage());

        if(chAryan1.isSuccess()){

            System.out.println(
                    chAryan1.getUser().getFullName()
            );

        }
        LoginResult bhavana12 = login.login("Bhavana_12", "Hello1@World");
        System.out.println(bhavana12.getMessage());

        if(bhavana12.isSuccess()){
            session.login(bhavana12.getUser());
            System.out.println(
//                    chAryan.getUser().getUserName()
                    session.getCurrentUser().getFullName()
            );

        }

        LoginResult bhai1 = login.login("Bhai", "123");
        System.out.println(bhai1.getMessage());

        if(bhai1.isSuccess()){

            System.out.println(
                    bhai1.getUser().getUserName()
            );

        }

        LoginResult bhai = login.login("ch_aryan1", "Aryan@1234");
        System.out.println(bhai.getMessage());

        if(bhai.isSuccess()){

            System.out.println(
                    bhai.getUser().getUserName()
            );

        }
        LoginResult chAryan2 = login.login("ch_aryan1", "Aryan@123");
        System.out.println(chAryan2.getMessage());

        if(chAryan2.isSuccess()){

            System.out.println(
                    chAryan2.getUser().getFullName()
            );

        }
        System.out.println("\n================ MONEY Services ================\n");
        User currentUser = LoginResult.getUser();

        DepositService depositService = new DepositService();
        WithdrawlService withdrawService = new WithdrawlService();

        DepositResult d1 = depositService.Deposit(currentUser, 5000);
        System.out.println(d1.getMessage());

        WithdrawlResult w1 = withdrawService.withdraw(currentUser, 2000);
        System.out.println(w1.getMessage());

        System.out.println("Final Balance: " + currentUser.getBankAccount().getBalance());
        session.logout();

        LoginResult bhavana1 = login.login("Bhavana_12", "Hello1@World");
        System.out.println(bhavana1.getMessage());

        if(bhavana1.isSuccess()){
            session.login(bhavana1.getUser());
            System.out.println(
//                    chAryan.getUser().getUserName()
                    session.getCurrentUser().getFullName()
            );

        }

        User currentUser1 = LoginResult.getUser();

        DepositService depositService2 = new DepositService();
        WithdrawlService withdrawService2 = new WithdrawlService();

        DepositResult d11 = depositService2.Deposit(currentUser, 8000);
        System.out.println(d11.getMessage());

        WithdrawlResult w11 = withdrawService2.withdraw(currentUser, 9000);
        System.out.println(w11.getMessage());

        System.out.println("Final Balance: " + currentUser1.getBankAccount().getBalance());
        session.logout();

    }
}