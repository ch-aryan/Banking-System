# Version 0 — System Architecture

## Introduction

Version 0 follows a simple layered architecture where each package is responsible for a specific part of the banking system.

Instead of placing all the code inside the `versions.v0.Main` class, responsibilities are divided into smaller components. This makes the project easier to understand, maintain, and extend.

Although this is still a console application, the architecture already follows the idea of **separating responsibilities**, which is one of the foundations of software engineering.

---

# High Level Architecture

```
                        User
                          │
                          ▼
                   Console (versions.v0.Main)
                          │
                          ▼
                 -------------------
                 |   Service Layer  |
                 -------------------
                 │        │
                 │        │
         UserRegistration  UserLogin
                 │        │
                 ▼        ▼
                User (versions.v0.Model)
                     │
                     ▼
               BankAccount (versions.v0.Model)
                     │
        ┌────────────┴────────────┐
        ▼                         ▼
 DepositService           WithdrawService
        │                         │
        └────────────┬────────────┘
                     ▼
              versions.v0.Validation Rules

```

Every request passes through these layers until the required operation is completed.

---

# Application Flow

The application starts from the `versions.v0.Main` class.

The `versions.v0.Main` class creates the required objects and coordinates the flow of the application.

For example, during user registration:

```
versions.v0.Main

↓

UserRegistration Service

↓

versions.v0.Validation Rules

↓

Generate IDs

↓

Create BankAccount

↓

Create User

↓

Return UserResult

↓

versions.v0.Main
```

The same approach is followed for login, deposit, and withdrawal operations.

---

# Responsibilities of Each Layer

## versions.v0.Main

The `versions.v0.Main` class acts as the starting point of the application.

Its responsibilities include:

- Creating versions.v0.service objects
- Registering users
- Performing login
- Calling deposit and withdrawal services
- Displaying results

At this stage of the project, the `versions.v0.Main` class still coordinates many operations.

This is acceptable for Version 0, but it becomes one of the biggest improvement areas for the next version.

---

## Service Layer

The Service Layer contains the business logic of the banking system.

Examples include:

- UserRegistration
- UserLogin
- DepositService
- WithdrawService

Instead of placing banking logic inside the `versions.v0.Main` class or model classes, these services perform the actual business operations.

For example:

- Registration checks business rules before creating a user.
- Login verifies user credentials.
- Deposit validates the amount before updating the balance.
- Withdrawal checks available balance before allowing money to be withdrawn.

---

## versions.v0.Model Layer

The versions.v0.Model layer represents real-world banking objects.

Current models include:

- User
- BankAccount

These classes mainly store application data.

For example:

A `User` owns one `BankAccount`.

The `BankAccount` stores:

- Account Number
- PIN
- Balance

The model does not coordinate the entire application.

Its purpose is to represent business entities.

---

## versions.v0.Validation Layer

The versions.v0.Validation package contains reusable business rules.

Examples include:

- Username validation
- Password validation
- PIN validation
- Deposit limits
- Withdrawal limits

Keeping validation separate avoids duplicating the same logic throughout the application.

---

## Result Layer

Instead of returning only `true` or `false`, business operations return Result objects.

Examples:

- UserResult
- LoginResult
- DepositResult
- WithdrawResult

A Result object can contain:

- Success status
- Message
- Related object
- Updated balance

This makes communication between different parts of the application much clearer.

---

## versions.v0.Session Layer

The versions.v0.Session component stores the currently logged-in user.

Instead of repeatedly passing the logged-in user between different methods, the application keeps track of the active session.

This simulates the idea of user sessions found in real applications.

---

## Utility Layer

The Utility package currently contains helper classes that support the application.

For Version 0, this includes:

- ID generation

Instead of generating IDs inside registration logic, this responsibility is separated into its own utility class.

---

# Why was this architecture chosen?

The goal of Version 0 was not to build a perfect architecture.

The goal was to avoid placing every responsibility inside a single class.

As the project grew, it became easier to understand that different responsibilities naturally belong in different places.

This architecture provides a simple foundation that future versions can improve through refactoring.

---

# Current Limitations

Although the architecture is much cleaner than placing everything inside one class, there are still several limitations.

Examples include:

- `versions.v0.Main` still controls too many operations.
- Data is stored using an `ArrayList` instead of a repository.
- There is no transaction history.
- There is no database.
- There is no exception hierarchy.
- Business operations are tightly coupled to the current implementation.

These limitations are intentional.

Future versions of the project will gradually improve them instead of solving everything at once.

---

# Key Takeaway

Version 0 introduces the idea that software should be divided based on responsibilities.

Instead of asking:

> "How do I write this class?"

Version 0 encourages a different question:

> "Which responsibility should this class own?"

That small shift in thinking is the first step toward understanding software architecture.

---

## Next Step

The next document explains the package structure of Version 0 and why each package was introduced as the project evolved.