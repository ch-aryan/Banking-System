# Version 1 — OOP Relationships

## Introduction

Object-Oriented Programming (OOP) is not only about creating classes and objects. It is also about defining how those objects interact with one another.

A well-designed software system is built on meaningful relationships between objects. Choosing the correct relationship improves readability, reduces coupling, and makes the system easier to maintain.

This project uses the four fundamental object relationships:

- Composition
- Aggregation
- Association
- Dependency

Instead of explaining these concepts using generic examples, this document demonstrates how they are applied within the banking system.

---

# 1. Composition

## Definition

Composition represents a **strong "has-a" relationship** where one object completely owns another.

The owned object cannot exist independently of its owner.

If the owner is destroyed, the owned object is also destroyed.

---

## Example from our project

```java
public class BankAccount {

    private ArrayList<Transaction> transactionHistory;

    public BankAccount() {
        this.transactionHistory = new ArrayList<>();
    }
}
```

Here, every `BankAccount` creates and owns its own transaction history.

The transaction history is automatically initialized when the bank account is created.

A transaction history has no meaning without its bank account.

Likewise, if the bank account no longer exists, its transaction history also disappears.

This is a classic example of composition.

---

## Why Composition?

Every bank account should always start with an empty transaction history.

Creating it inside the constructor guarantees that the object is always in a valid state.

```java
this.transactionHistory = new ArrayList<>();
```

This design removes the possibility of a `null` transaction history and reflects how real banking systems work.

---

## Relationship

```
BankAccount
      ♦
      │
Transaction History
```

Strong ownership.

---

# 2. Aggregation

## Definition

Aggregation represents a **weak "has-a" relationship**.

The owner uses another object, but it does not control that object's lifecycle.

Both objects can exist independently.

---

## Example from our project

```java
public class LoginService {

    private UserDatabaseHM database;

    public LoginService(UserDatabaseHM database) {
        this.database = database;
    }
}
```

`LoginService` depends on the repository to perform user authentication.

However, the repository exists independently of the service.

The service simply receives a reference to it.

If `LoginService` is destroyed, the repository continues to exist.

This is aggregation.

---

## Relationship

```
LoginService
      ◇
      │
UserDatabaseHM
```

Weak ownership.

---

# 3. Association

## Definition

Association represents a relationship where two or more objects collaborate to complete a task.

Neither object owns the other.

---

## Example from our project

During a money transfer, two users participate in the same operation.

```
Sender User

        │

TransferService

        │

Receiver User
```

`TransferService` temporarily associates the sender and receiver to complete the transfer.

Neither user owns the other.

The relationship exists only for the duration of the business operation.

---

## Relationship

```
User  ───────── User
      (Transfer)
```

Collaboration without ownership.

---

# 4. Dependency

## Definition

Dependency is the weakest object relationship.

One object temporarily uses another object to complete a method.

The relationship usually exists only while the method is executing.

---

## Example from our project

```java
public DepositResult deposit(User user, double amount)
```

`DepositService` requires a `User` object to perform the deposit.

It does not store the user.

It simply uses the object during method execution.

Once the method finishes, the dependency ends.

---

Another example:

```java
withdraw(User user, ...)
```

```java
transfer(User sender, User receiver, ...)
```

Each service depends on the objects passed to it.

---

## Relationship

```
DepositService
      │
      ▼
    User
```

Temporary usage.

---

# Comparison

| Relationship | Ownership | Lifecycle | Example |
|--------------|-----------|-----------|---------|
| Composition | Strong | Owner controls lifecycle | BankAccount → Transaction History |
| Aggregation | Weak | Independent | LoginService → UserDatabaseHM |
| Association | None | Temporary collaboration | Sender ↔ Receiver during transfer |
| Dependency | None | Method-level usage | DepositService → User |

---
# Why Not the Other Relationships?

Choosing the correct relationship is just as important as understanding why the other relationships do not apply. During the development of this project, each relationship was selected based on object ownership, lifecycle, and responsibility.

---

## Why is BankAccount → Transaction History Composition instead of Aggregation?

The relationship between `BankAccount` and `Transaction` is Composition because the bank account completely owns its transaction history.

```java
public BankAccount() {
    this.transactionHistory = new ArrayList<>();
}
```

The transaction history is created automatically when a bank account is created.

A transaction history cannot exist without its bank account, and it has no independent purpose in the application.

If a bank account is removed, its transaction history is also removed.

### Why not Aggregation?

Aggregation allows both objects to exist independently.

In our project, a transaction history cannot be created or managed separately from a bank account.

Therefore, Composition is the correct relationship.

---

## Why is LoginService → UserDatabaseHM Aggregation instead of Composition?

`LoginService` requires access to the repository to authenticate users.

```java
public LoginService(UserDatabaseHM database) {
    this.database = database;
}
```

The repository is created outside the service and passed through the constructor.

This means the service only uses the repository; it does not own it.

### Why not Composition?

In Composition, the owner is responsible for creating and destroying the owned object.

If `LoginService` created the repository internally, every service would have its own separate repository, leading to inconsistent data.

Sharing a single repository instance across multiple services makes Aggregation the appropriate choice.

---

## Why is TransferService → User Association instead of Composition?

During a transfer, `TransferService` coordinates two existing users.

```
Sender User
      │
TransferService
      │
Receiver User
```

The service only connects these objects to perform one business operation.

Neither user owns the other, and the service does not own either user.

### Why not Composition?

Composition implies ownership.

`TransferService` neither creates nor destroys users.

Users continue to exist before and after the transfer operation.

Therefore, Composition is not appropriate.

---

## Why is DepositService → User Dependency instead of Association?

```java
public DepositResult deposit(User user, double amount)
```

The `User` object is passed as a method parameter.

`DepositService` temporarily uses it to complete the deposit operation.

After the method finishes, the relationship ends.

### Why not Association?

Association usually exists when objects maintain a longer-lived relationship through references.

In our project, `DepositService` does not store the `User` object as an instance variable.

It simply depends on it while executing the method.

Therefore, Dependency is the correct relationship.

---

# Summary

The relationships used in this project were chosen based on three important questions:

1. **Who owns the object?**
2. **Can the object exist independently?**
3. **How long does the relationship exist?**

Answering these questions helps determine whether Composition, Aggregation, Association, or Dependency is the most suitable relationship for a given design.

---

# Why Choosing the Right Relationship Matters

Selecting the correct relationship makes responsibilities clear.

For example:

- A bank account should own its transaction history.
- A service should use a repository rather than own it.
- Users collaborate during transfers but do not own each other.
- Services temporarily depend on domain objects to perform business operations.

Each relationship reflects how the objects interact in the real banking domain.

---

# Key Takeaway

Different relationships express different levels of ownership and collaboration.

Using the appropriate relationship makes the code easier to understand and keeps object responsibilities well defined.

Understanding these relationships is an important step toward designing maintainable object-oriented software.

---

## Next Step

In the next document, we will explore the Service Layer and understand how each service coordinates business operations while keeping the domain model independent of application logic.