# Version 1 — System Architecture

## Introduction

Version 1 introduces a significantly improved architecture compared to Version 0.

While Version 0 successfully separated the application into packages, Version 1 focuses on improving how those packages collaborate to perform banking operations.

The application now follows a cleaner layered architecture where each layer has a well-defined responsibility.

Although the project is still a console application built using Core Java, the internal organization now closely resembles the architecture found in larger software systems.

Instead of allowing one class to perform multiple responsibilities, Version 1 encourages every layer to focus on a single purpose.

This makes the project easier to understand, easier to maintain, and easier to extend in future versions.

---

# High-Level Architecture

```
                           User
                             │
                             ▼
                     Application Layer
                             │
      ┌──────────────────────┼──────────────────────┐
      ▼                      ▼                      ▼
Registration Service   Login Service      Banking Services
                                                │
                           ┌────────────────────┼────────────────────┐
                           ▼                    ▼                    ▼
                   Deposit Service     Withdraw Service     Transfer Service
                                                                   │
                                                                   ▼
                                                    TransactionHistoryService
                             │
                             ▼
                        Repository Layer
                             │
                             ▼
                      UserDatabaseHM (HashMap)
                             │
                             ▼
                        Domain Model Layer
                             │
                ┌────────────┴────────────┐
                ▼                         ▼
              User                 BankAccount
                                        │
                                        ▼
                               Transaction History
                                        │
                                        ▼
                               Transaction Model

                             ▲
                             │
                    Validation Layer

                             ▲
                             │
                       Result Objects
```

Every request made by the user travels through these layers before the final result is returned to the application.

Each layer performs only the responsibility assigned to it.

---

# Evolution from Version 0

Version 0 established the basic separation between models, services, validation, and results.

Version 1 expands that architecture by introducing several important components.

The most significant improvements include:

- Repository Layer using `HashMap`
- Transfer Service
- Transaction Model
- Transaction History
- Transaction Type Enumeration
- Improved Domain Model
- Better separation of business responsibilities

These additions make the architecture more modular while keeping the project easy to understand.

---

# Layer Responsibilities

## 1. Application Layer

The `Application` class remains the entry point of the program.

Its responsibility is no longer to perform business logic.

Instead, it coordinates the overall execution of the application.

Responsibilities include:

- Displaying menus
- Reading user input
- Calling appropriate services
- Displaying results
- Managing application flow

The Application layer does **not** directly modify banking data.

Instead, it delegates every business operation to the Service Layer.

---

## 2. Service Layer

The Service Layer contains the business logic of the banking system.

Current services include:

- RegistrationService
- LoginService
- DepositService
- WithdrawService
- TransferService
- TransactionHistoryService

Each service performs one business responsibility.

For example:

- RegistrationService creates new users.
- LoginService authenticates existing users.
- DepositService updates account balances after validation.
- WithdrawService validates balance before withdrawing money.
- TransferService coordinates money movement between two accounts.
- TransactionHistoryService displays account transaction history.

Services coordinate business operations but do not own business data.

---

## 3. Repository Layer

One of the biggest architectural improvements introduced in Version 1 is the Repository Layer.

Version 0 stored users inside an `ArrayList`.

As the project grew, searching users required iterating through the entire collection.

Version 1 replaces this approach with a repository backed by a `HashMap`.

Current repository:

```
UserDatabaseHM
```

Responsibilities include:

- Store registered users
- Search users by username
- Search users by account number
- Provide a single source of user data

Although the repository still stores data in memory, it closely resembles the repository pattern used later with databases.

---

## 4. Domain Model Layer

The Domain Model represents the real banking entities.

Current models include:

- User
- BankAccount
- Transaction
- TransactionType

Each model represents a real business concept.

Ownership follows the natural banking hierarchy:

User

↓

BankAccount

↓

Transaction History

↓

Transaction

This ownership model keeps business data organized and easy to understand.

---

## 5. Validation Layer

The Validation Layer centralizes reusable business rules.

Examples include:

- Username validation
- Password validation
- PIN validation
- Deposit validation
- Withdrawal validation
- Transfer validation
- Maximum balance validation

Separating validation prevents business rules from being duplicated across multiple services.

---

## 6. Result Layer

Business operations return Result Objects instead of simple boolean values.

Examples include:

- UserResult
- LoginResult
- DepositResult
- WithdrawResult
- TransferResult

Each result object communicates:

- Success status
- User-friendly message
- Updated balance (where applicable)
- Related domain object (where applicable)

This keeps communication between layers structured and expressive.

---

# Architectural Benefits

Version 1 introduces several architectural improvements over Version 0.

These include:

- Better separation of responsibilities
- Faster user lookup
- Improved object ownership
- Cleaner business logic
- Easier feature expansion
- Reduced coupling between layers
- Better preparation for future technologies

Most importantly, the architecture now allows new features to be introduced with minimal impact on existing code.

---

# Current Limitations

Although Version 1 represents a significant improvement, several limitations remain intentionally unresolved.

Examples include:

- Data still exists only in memory.
- Repository is backed by a HashMap instead of a database.
- Application still performs console interaction.
- No dependency injection.
- No REST APIs.
- No persistence layer.
- No exception hierarchy.

These limitations are intentionally postponed until future versions.

The goal of Version 1 is to master software architecture using only Core Java before introducing enterprise technologies.

---

# Key Takeaway

Version 1 transforms the project from a simple console application into a layered software system.

Rather than focusing only on writing code, this version emphasizes designing responsibilities, coordinating business operations, and preparing the application for future evolution.

The architecture introduced in Version 1 serves as the foundation for future refactoring in Version 2 and the transition to Spring Boot in Version 3.

---

## Next Step

In the next document, we will explore how the project evolved from Version 0 to Version 1 and examine the engineering decisions that drove each architectural improvement.