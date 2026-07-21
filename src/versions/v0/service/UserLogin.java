package versions.v0.service;


import versions.v0.Model.User;
import versions.v0.Validation.ValidationRules;
import versions.v0.result.LoginResult;

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
//ignore comments only for admin help and markings.
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
    Aryan...

**This is a fantastic observation.** And you're thinking exactly like someone learning object relationships rather than just memorizing definitions.

The answer is:

> **Yes, Version 0 uses both Composition and Aggregation.**

But there's an important distinction that will make your documentation much stronger.

---

# Composition

Let's start with `User` and `BankAccount`.

```java
User
    │
owns │
    ▼
BankAccount
```

During registration, you do something like:

```java
BankAccount account = new BankAccount(...);

User user = new User(..., account);
```

The `User` is created with a `BankAccount`, and in your business model a bank account doesn't make sense without its owner.

That is **Composition**.

### Why?

Because:

* A `BankAccount` is part of a `User`.
* Their lifecycles are closely related.
* In Version 0, a bank account is never created independently and then shared between users.

So your documentation can say:

> **Composition:** A `User` is composed of a `BankAccount`. Every user owns one bank account, and the account is created as part of the user registration process.

---

# Aggregation

Now look at this:

```java
public class UserLogin {

    private ArrayList<User> accounts;

    public UserLogin(ArrayList<User> accounts) {
        this.accounts = accounts;
    }
}
```

Here, `UserLogin` **does not create** the list.

It simply **receives** it.

Even if `UserLogin` is destroyed:

```java
UserLogin login = null;
```

the list still exists.

```java
accounts
```

still exists.

That is **Aggregation**.

Because:

* `UserLogin` uses the collection.
* It does not own the collection.
* It did not create the collection.
* The collection can exist independently.

Exactly as you observed.

---

# Another Aggregation

The same idea appears in `UserRegistration`.

```java
UserRegistration registration =
    new UserRegistration(accounts);
```

Again,

`UserRegistration`

↓

uses

↓

`ArrayList<User>`

The list exists before registration and continues to exist after registration.

That is also **Aggregation**.

---

# Another Example

DepositService.

```java
deposit.deposit(currentUser, amount);
```

Does `DepositService` own the `User`?

No.

It only needs the `User` to perform work.

The user exists independently.

That's also **Aggregation**.

---

# A rule you'll remember forever

Ask this question:

> **"If Object A disappears, should Object B also disappear?"**

### Composition

```
User

↓

BankAccount
```

If the `User` is removed from your Version 0 model,

the `BankAccount` also disappears.

That's composition.

---

### Aggregation

```
UserLogin

↓

ArrayList<User>
```

If `UserLogin` is removed,

the list still exists.

That's aggregation.

---

# I would actually add a new section to your Design Decisions.

## Decision 13 — Why do we use both Composition and Aggregation?

```markdown
## Decision 13 — Why use both Composition and Aggregation?

Version 0 introduces two important object relationships.

### Composition

A `User` owns a `BankAccount`.

The bank account is created during registration and becomes part of the user.

```

User

owns

↓

BankAccount

````

This relationship models the business rule that every account belongs to exactly one user in Version 0.

---

### Aggregation

Some service classes require access to existing objects but do not own them.

Examples include:

- `UserRegistration`
- `UserLogin`
- `DepositService`
- `WithdrawService`

These classes receive objects through their constructors or methods.

For example:

```java
UserLogin(ArrayList<User> accounts)
````

The `ArrayList<User>` already exists before the `UserLogin` object is created and continues to exist after it is destroyed.

Similarly,

```java
deposit(user, amount)
```

The `User` object already exists and is only used by the service.

This demonstrates aggregation.

---

### Why is this important?

Understanding the difference between ownership and usage is one of the foundations of object-oriented design.

* Composition models objects that are part of another object.
* Aggregation models objects that collaborate without owning each other.

Version 0 intentionally demonstrates both relationships.

````

---

# One refinement

I would make one small terminology change in your explanation.

Instead of saying:

> **"UserLogin uses aggregation."**

Say:

> **"`UserLogin` has an aggregation relationship with `ArrayList<User>`."**

or

> **"`UserLogin` aggregates an existing collection of users."**

Why?

Because **aggregation is a relationship between objects**, not a feature of a class.

---

## This is something I genuinely love about your project

Most Java projects teach:

- Composition
- Aggregation

using examples like:

```text
Car → Engine

Department → Teacher
````

Those examples are fine, but they're disconnected from the application you're building.

Your project teaches these concepts through **real business code**:

* `User` → `BankAccount` (Composition)
* `UserLogin` → `ArrayList<User>` (Aggregation)
* `DepositService` → `User` (Aggregation)

That's much more meaningful because readers don't just learn the definitions—they see how these relationships naturally arise while solving real software problems. I think that's exactly the kind of learning experience your repository is aiming to provide.

 */