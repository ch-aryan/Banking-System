# Version 1 — Package Structure

## Introduction

As Version 1 introduced new banking features, the number of classes increased significantly.

Instead of placing every class inside a single package, the project organizes related classes together based on their responsibilities.

Each package represents one part of the banking system.

This organization makes the project easier to understand, navigate, and maintain.

---

# Package Structure

```
src/

├── application/
│   └── Application.java
│
├── model/
│   ├── User.java
│   ├── BankAccount.java
│   ├── Transaction.java
│   └── TransactionType.java
│
├── repository/
│   └── UserDatabaseHM.java
│
├── service/
│   ├── RegistrationService.java
│   ├── LoginService.java
│   ├── DepositService.java
│   ├── WithdrawService.java
│   ├── TransferService.java
│   └── TransactionHistoryService.java
│
├── validation/
│   └── BankValidationRules.java
│    |_ UserValidationRules.java   
|
├── result/
│   ├── UserResult.java
│   ├── LoginResult.java
│   ├── DepositResult.java
│   ├── WithdrawResult.java
│   └── TransferResult.java
│
└── utility/
    └── IdGenerator.java
```

---

# Package Responsibilities

## application

Contains the entry point of the application.

Current class:

- Application

Responsibilities:

- Display menus
- Read user input
- Coordinate program flow
- Invoke service classes

The application package does not contain business logic.

---

## model

Represents the core business entities of the banking system.

Classes:

- User
- BankAccount
- Transaction
- TransactionType

These classes model real-world banking concepts and store application data.

---

## repository

Responsible for managing user storage.

Current class:

- UserDatabaseHM

Responsibilities:

- Store registered users
- Find users by username
- Find users by account number

The repository acts as the single source of user data.

---

## service

Contains the business operations of the application.

Classes:

- RegistrationService
- LoginService
- DepositService
- WithdrawService
- TransferService
- TransactionHistoryService

Each service performs one specific banking operation.

---

## validation

Contains reusable business rules.

Current class:

- BankValidationRules

Examples include:

- Username validation
- Password validation
- PIN validation
- Deposit validation
- Withdrawal validation
- Transfer validation

Centralizing these rules avoids duplication across services.

---

## result

Contains result objects returned by business operations.

Classes:

- UserResult
- LoginResult
- DepositResult
- WithdrawResult
- TransferResult

Instead of returning only success or failure, these objects provide detailed information about the operation.

---

## utility

Contains helper classes shared across the application.

Current class:

- IdGenerator

Its responsibility is generating unique identifiers for users and bank accounts.

---

# Why organize the project this way?

The package structure follows a simple principle:

> Classes that share the same responsibility should belong together.

This makes the project easier to navigate because each package has a clear purpose.

For example:

- Need to modify banking logic? → Open the `service` package.
- Need to update validation rules? → Open the `validation` package.
- Need to change user storage? → Open the `repository` package.

The package names themselves describe where each responsibility belongs.

---

# Key Takeaway

Version 1 organizes the project by responsibility rather than by feature.

Each package has a single purpose, making the application easier to understand and maintain as it continues to grow.

---

## Next Step

In the next document, we will explore the Domain Model and understand how the banking system represents users, bank accounts, and transactions as business objects.