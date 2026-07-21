package versions.v1;

import versions.v1.Model.BankAccount;
import versions.v1.Model.User;

import java.time.LocalDate;
import java.util.HashMap;

public class UserDatabaseHM {
    HashMap<String , User> map = new HashMap<>();
    User user;
    public void storeUser(String userName, User user){
        map.put(userName, user);
    }
    public  boolean userExist(String userName){
        if(map.containsKey(userName)){
            return true;
            }
        return false;
        }

        public User verifyCredentials(String userName, String password){

            user = map.get(userName);
            if(user == null){
                return null;
            }
            if(user.getPassword().equals(password)){
                return user;
            }
            return null;

        }
    public void loadSampleData() {

        BankAccount acc1 =
                new BankAccount(
                        110000,
                        "Aryan",
                        1234
                );

        User aryan =
                new User(
                        1,
                        "ch_aryan1",
                        "Aryan@123",
                        "Aryan Chilkeshwaram",
                        acc1,
                        LocalDate.of(2003,8,14)
                );

        storeUser(
                aryan.getUserName(),
                aryan
        );


    }
    public User findByAccountNumber(Integer accountNumber){
        for(User user : map.values()){

            if(user.getBankAccount()
                    .getAccountNumber()
                    .equals(accountNumber)){

                return user;
            }

        }

        return null;

    }

}
