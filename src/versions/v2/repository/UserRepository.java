package versions.v2.repository;

import versions.v2.domain.model.BankAccount;
import versions.v2.domain.model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/*
=========================================================
Class : UserRepository

Layer
Repository Layer

Responsibility
Stores and retrieves User objects from the
application's in-memory database.

Design Principle
Single Responsibility Principle

Architectural Role
Repository

Why it exists
Acts as the application's data access layer.

The repository knows HOW data is stored,
but knows nothing about business rules,
validation, or authentication.

Current Storage
HashMap<String, User>

Future Storage
MySQL
PostgreSQL
MongoDB
Redis

The service layer should never know or care
where the data comes from.

Spring Boot Equivalent
@Repository

Version
2.0
=========================================================
*/

public class UserRepository {

    // =====================================================
    // In-Memory Database
    // =====================================================

    private final Map<String, User> users =
            new HashMap<>();

    /*
    --------------------------------------------------------
    Responsibility
    Stores a new user.

    Key
    Username

    Value
    User
    --------------------------------------------------------
    */
    public void storeUser(
            String username,
            User user) {

        users.put(username, user);

    }

    /*
    --------------------------------------------------------
    Responsibility
    Checks whether a username already exists.

    Returns

    true  -> Username already exists

    false -> Username is available
    --------------------------------------------------------
    */
    public boolean userExists(String username) {

        return users.containsKey(username);

    }

    /*
    --------------------------------------------------------
    Responsibility
    Finds a user by username.

    Returns

    User -> Found

    null -> Not Found
    --------------------------------------------------------
    */
    public User findByUsername(String username) {

        return users.get(username);

    }

    /*
    --------------------------------------------------------
    Responsibility
    Verifies login credentials.

    Returns

    User -> Credentials match

    null -> Invalid username or password
    --------------------------------------------------------
    */
    public User verifyCredentials(
            String username,
            String password) {

        User user = users.get(username);

        if (user == null) {
            return null;
        }

        if (user.getPassword().equals(password)) {
            return user;
        }

        return null;

    }

    /*
    --------------------------------------------------------
    Responsibility
    Finds a user using account number.

    Returns

    User -> Found

    null -> Not Found
    --------------------------------------------------------
    */
    public User findByAccountNumber(Integer accountNumber) {

        for (User user : users.values()) {

            if (user.getBankAccount()
                    .getAccountNumber()
                    .equals(accountNumber)) {

                return user;

            }

        }

        return null;

    }

    /*
    --------------------------------------------------------
    Temporary

    Loads sample users into the in-memory
    database.

    Note

    This method exists only for the console
    application.

    It will later be replaced by a proper
    DataInitializer or a real database.
    --------------------------------------------------------
    */
    //this below code is shipped to bootstrap class in the application package
//    public void loadSampleData() {
//
//        BankAccount account =
//                new BankAccount(
//                        110000,
//                        "Aryan",
//                        1234
//                );
//
//        User aryan =
//                new User(
//                        1,
//                        "ch_aryan1",
//                        "Aryan@123",
//                        "Aryan Chilkeshwaram",
//                        account,
//                        LocalDate.of(2003, 8, 14)
//                );
//
//        storeUser(
//                aryan.getUserName(),
//                aryan
//        );
//
//    }

}