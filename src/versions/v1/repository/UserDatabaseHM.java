package versions.v1.repository;

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
/*
Yes! 👍

This is called **Method Chaining** (also known as **Chained Method Calls**).

Your code:

```java
if (user.getBankAccount()
        .getAccountNumber()
        .equals(accountNumber)) {

    return user;
}
```

is a perfect example of method chaining.

---

# How it works

Let's break it down step by step.

### Step 1

```java
user.getBankAccount()
```

Returns a `BankAccount` object.

```text
User
  │
  ▼
BankAccount
```

---

### Step 2

Now Java continues the chain.

```java
user.getBankAccount()
    .getAccountNumber()
```

Since `getBankAccount()` returned a `BankAccount`, Java now calls:

```java
bankAccount.getAccountNumber()
```

which returns a `String`.

```text
User

↓

BankAccount

↓

String
```

---

### Step 3

Now Java continues again.

```java
user.getBankAccount()
    .getAccountNumber()
    .equals(accountNumber)
```

Since `getAccountNumber()` returned a `String`, Java can now call

```java
String.equals(...)
```

which returns

```java
boolean
```

---

Complete chain:

```text
User
   │
   ▼
getBankAccount()

returns BankAccount
   │
   ▼
getAccountNumber()

returns String
   │
   ▼
equals(accountNumber)

returns boolean
```

---

# JVM's View

The JVM evaluates it **from left to right**.

Internally, it's almost like writing:

```java
BankAccount account = user.getBankAccount();

String accNo = account.getAccountNumber();

boolean match = accNo.equals(accountNumber);

if (match) {
    return user;
}
```

Method chaining is simply a shorter, cleaner way of writing the same thing.

---

# Why does this work?

Because every method returns an object (or value) on which the next method can be called.

Think of it like a relay race:

```text
User

↓

returns BankAccount

↓

returns String

↓

returns boolean
```

Each return value becomes the receiver of the next method call.

---

# Another Example

```java
String name = user.getBankAccount()
                  .getOwner()
                  .getName()
                  .toUpperCase()
                  .trim();
```

Flow:

```text
User

↓

BankAccount

↓

Owner

↓

String

↓

Uppercase String

↓

Trimmed String
```

Every method returns something that allows the next method to be invoked.

---

# When does Method Chaining fail?

Suppose:

```java
user.getBankAccount()
```

returns `null`.

Then this line

```java
.getAccountNumber()
```

tries to execute on `null`.

Result:

```text
NullPointerException
```

That's why method chaining requires that each intermediate object exists (is not `null`).

---

# Fun Fact

Method chaining is used heavily in modern Java libraries.

### StringBuilder

```java
StringBuilder sb = new StringBuilder();

sb.append("Hello")
  .append(" ")
  .append("Aryan")
  .append("!");
```

Each `append()` returns the same `StringBuilder` object, allowing the next `append()` to be called.

---

### Streams API

```java
list.stream()
    .filter(x -> x > 10)
    .map(x -> x * 2)
    .sorted()
    .forEach(System.out::println);
```

This is also method chaining.

---

### Builder Pattern

```java
User user = new UserBuilder()
                .setName("Aryan")
                .setAge(22)
                .setCity("Hyderabad")
                .build();
```

Again, each method returns the builder object itself.

---

## In your banking project

This line:

```java
user.getBankAccount()
    .getAccountNumber()
    .equals(accountNumber)
```

shows something more than method chaining—it also demonstrates **object navigation**.

You're navigating through the object graph:

```text
User
   │
   ▼
BankAccount
   │
   ▼
Account Number
```

This is a very common pattern in object-oriented programming. You're following the relationships between objects (`User` → `BankAccount`) to reach the piece of data you need. So you can confidently say:

* ✅ **Method Chaining** (the syntax)
* ✅ **Object Navigation** (the OOP concept)

Together, they describe exactly what's happening in this line of code.

 */