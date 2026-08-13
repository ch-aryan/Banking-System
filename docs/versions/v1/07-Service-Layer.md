# Version 1 — Service Layer

1. Introduction

2. Why Service Layer?

3. Responsibilities of the Service Layer

4. Overall Service Architecture

5. Service Overview Table

6. RegistrationService

7. LoginService

8. DepositService

9. WithdrawService

10. TransferService

11. TransactionHistoryService

12. Result Objects

13. Service Collaboration

14. Under the Hood (JVM)

15. Future Evolution

16. Key Takeaway



## Introduction

The Service Layer contains the business logic of the banking system.

It acts as the bridge between the user interface and the domain model.

When a user performs an operation such as registration, login, deposit, withdrawal, or transfer, the request is first handled by a service.

The service validates the request, coordinates the required business objects, performs the operation, and returns the result to the application.

Rather than storing data itself, the Service Layer orchestrates the interaction between different components of the system.

---

# Why Do We Need a Service Layer?

Imagine placing every banking operation inside the `Application` class.

The application would become responsible for:

- Reading user input
- Validating data
- Updating balances
- Creating transactions
- Searching users
- Printing messages

Such a class would quickly become difficult to understand and maintain.

Instead, each responsibility is delegated to a dedicated service.

```
Application

        │

        ▼

Service Layer

        │

        ▼

Domain Model
```

The Application controls the program.

The Service Layer performs business operations.

The Domain Model stores business data.

This separation keeps responsibilities clear.

---

# Responsibilities of the Service Layer

Every service in the project follows the same principles.

A service should:

- Perform one business operation.
- Coordinate multiple objects.
- Validate business rules.
- Update the domain model.
- Return the outcome as a Result object.

A service should **not**:

- Read input using `Scanner`.
- Print directly to the console.
- Store application data permanently.
- Control menus or navigation.

These responsibilities belong to other layers.

---

# Overall Service Architecture

```
                Application
                      │
                      ▼
             Banking Service
                      │
     ┌────────────────┼────────────────┐
     ▼                ▼                ▼
Validation      Repository       Domain Model
                                       │
                                       ▼
                                Result Object
                                       │
                                       ▼
                                 Application
```

Every service follows this collaboration pattern.

---

# Service Overview

| Service | Responsibility | Return Type |
|----------|---------------|-------------|
| RegistrationService | Register new users | UserResult |
| LoginService | Authenticate users | LoginResult |
| DepositService | Deposit money | DepositResult |
| WithdrawService | Withdraw money | WithdrawResult |
| TransferService | Transfer money | TransferResult |
| TransactionHistoryService | Display transaction history | void |

---

# RegistrationService

## Purpose

Creates a new user and bank account after validating the registration details.

## Collaborates With

- BankValidationRules
- User
- BankAccount
- UserDatabaseHM
- UserResult

## Flow

```
Application

↓

RegistrationService

↓

Validation

↓

Create User

↓

Create BankAccount

↓

Store User

↓

Return UserResult
```

## Why UserResult?

Registration can succeed or fail for several reasons.

Instead of returning only `true` or `false`, the service returns a `UserResult` containing:

- Success status
- Informative message
- Registered user (if successful)

This allows the Application to decide how the information should be displayed.

---

# LoginService

## Purpose

Authenticates an existing user.

## Collaborates With

- UserDatabaseHM
- BankValidationRules
- LoginResult

## Flow

```
Application

↓

LoginService

↓

Search Repository

↓

Validate Password

↓

Return LoginResult
```

The service never starts a session or displays menus.

Its only responsibility is authentication.

---

# DepositService

## Purpose

Adds money to the user's bank account.

## Collaborates With

- User
- BankAccount
- Transaction
- BankValidationRules
- DepositResult

## Flow

```
Application

↓

DepositService

↓

Validate Amount

↓

Validate PIN

↓

Update Balance

↓

Create Transaction

↓

Return DepositResult
```

Every successful deposit creates a transaction record before returning the result.

---

# WithdrawService

The withdrawal process is almost identical to deposit.

Additional business rules include:

- Sufficient balance
- Minimum withdrawal validation

Successful withdrawals also create a transaction record before returning a `WithdrawResult`.

---

# TransferService

## Purpose

Transfers money from one user to another.

Among all services, `TransferService` coordinates the largest number of objects.

## Collaborates With

- Sender
- Receiver
- Repository
- Validation
- Two BankAccount objects
- Two Transaction objects
- TransferResult

## Flow

```
Application

↓

TransferService

↓

Search Receiver

↓

Validate Transfer Rules

↓

Confirm Receiver

↓

Validate PIN

↓

Debit Sender

↓

Credit Receiver

↓

Create Transfer Transaction

↓

Create Received Transaction

↓

Return TransferResult
```

Unlike Deposit and Withdraw, a transfer updates two accounts and creates two transaction records.

---

# TransactionHistoryService

## Purpose

Displays the transaction history of a bank account.

Unlike other services, it does not modify any business data.

Its responsibility is limited to retrieving and presenting transaction information.

This makes it a read-only service.

---

# Why Return Result Objects?

Every service returns a dedicated Result object instead of a boolean value.

For example:

```
DepositService

↓

DepositResult
```

A Result object can contain:

- Success status
- User-friendly message
- Updated balance
- Domain object (when required)

Returning structured information makes communication between layers much clearer.

---

# Service Collaboration

The following diagram summarizes how services interact with the rest of the application.

```
Application

↓

Service

↓

Validation

↓

Repository

↓

Domain Model

↓

Result Object

↓

Application
```

Each component performs one responsibility before passing control to the next.

---

# Under the Hood

Understanding what happens inside the JVM helps explain why services return Result objects instead of printing directly.

---

## Example 1 — Deposit Operation

```java
DepositResult result =
        depositService.deposit(user, amount);
```

### JVM Execution

```
Stack Memory

Application.main()

↓

calls

↓

DepositService.deposit()
```

Inside the method:

- Validation is performed.
- The user's balance is updated.
- A `Transaction` object is created.
- A `DepositResult` object is created.

The `DepositResult` object is allocated in the **Heap Memory**.

A reference to that object is returned to the caller.

```
Heap

DepositResult Object

↑

Reference

↓

Stack

result
```

Finally,

```java
System.out.println(result.getMessage());
```

The Application chooses how to display the message.

The service never prints anything itself.

---

## Example 2 — Transfer Operation

A transfer involves more object collaboration.

```
Application

↓

TransferService

↓

Sender BankAccount

↓

Receiver BankAccount

↓

Transaction

↓

Transaction

↓

TransferResult

↓

Application
```

During execution, multiple objects are created in the heap.

The stack simply stores references while methods are executing.

Once the transfer completes, local method variables are removed from the stack, while the objects remain alive as long as they are still referenced by the application.

---

# Future Evolution

One of the biggest advantages of the Service Layer is that it remains independent of the user interface.

Today, services are called from the console application.

```
Application

↓

DepositService
```

In a future Spring Boot application, the same service can be reused.

```
React Frontend

↓

REST Controller

↓

DepositService

↓

DepositResult

↓

JSON Response
```

The business logic remains unchanged.

Only the caller changes.

This separation allows the application to evolve without rewriting the core banking operations.

---

# Key Takeaway

The Service Layer is the heart of the banking application's business logic.

It coordinates validation, repositories, and domain models while keeping responsibilities separate from user interaction.

By returning structured Result objects instead of directly interacting with the console, the services remain reusable, testable, and ready to support different user interfaces in future versions.