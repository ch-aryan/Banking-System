package Model;

import java.util.Scanner;

public class User {
    private final Integer id;
    private  final String fullName;
    private final String userName;
    private final String password;
    private  final BankAccount account;

    public User(Integer id, String userName, String password, String fullName , BankAccount account) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.account = account;

    }


    public String getFullName(){
        return fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public BankAccount getBankAccount() {
        return account;
    }
}
