# Version 1 - Execution Flows
┌───────────────────────────────────────────┐
│            Application Layer              │
│  - Reads user input                       │
│  - Calls Service Layer                    │
│  - Displays Result                        │
└───────────────────────────────────────────┘
            │
            ▼
┌───────────────────────────────────────────┐
│              Service Layer                │
│  Registration, Login, Deposit, Transfer   │
└───────────────────────────────────────────┘
│
▼
┌───────────────────────────────────────────┐
│             Validation Layer              │
│   Business Rules & Input Validation       │
└───────────────────────────────────────────┘
│
▼
┌───────────────────────────────────────────┐
│              Repository Layer             │
│     Store / Retrieve Users                │
└───────────────────────────────────────────┘
│
▼
┌───────────────────────────────────────────┐
│              Domain Model                 │
│ User • BankAccount • Transaction          │
└───────────────────────────────────────────┘
│
▼
┌───────────────────────────────────────────┐
│              Result Object                │
│ UserResult / LoginResult / ...            │
└───────────────────────────────────────────┘
│
▼
┌───────────────────────────────────────────┐
│              Application                  │
│ Prints Result to Console                  │
└───────────────────────────────────────────┘

## Introduction

Every feature in the banking system follows a well-defined sequence of interactions between multiple components.

Instead of placing all business logic inside the `Application` class, Version 1 delegates responsibilities to dedicated services. These services validate requests, coordinate domain objects, interact with the repository, and return structured Result objects back to the Application.

This document explains how each major banking operation executes from the moment a user performs an action until the final result is displayed.

The objective of this document is not to explain the implementation of every class, but to demonstrate how different layers of the application collaborate to complete a business operation.

---

# Purpose of this Document

This document answers one important question:

> **"What happens inside the system when the user performs an operation?"**

For every major feature, we will examine:

- The execution flow
- The participating components
- The order of execution
- The business rules applied
- The final result returned to the Application

---

# How to Read These Execution Flows

Before exploring each feature, it is important to understand the responsibility of every layer involved during execution.

| Component | Responsibility |
|------------|----------------|
| **Application** | Receives user input, invokes services, and displays the final output. |
| **Service Layer** | Executes the business logic and coordinates different objects. |
| **Validation Layer** | Verifies business rules before performing any operation. |
| **Repository** | Stores and retrieves user information. |
| **Domain Model** | Represents the core business entities such as User, BankAccount, and Transaction. |
| **Result Objects** | Return the outcome of an operation back to the Application. |

Each execution flow follows the collaboration between these components.

---

# Execution Flows Covered

The following business operations are discussed in this document:

1. User Registration
2. User Login
3. Deposit Money
4. Withdraw Money
5. Transfer Money
6. Transaction History

Each section follows a consistent structure:

- Overview
- Execution Diagram
- Step-by-Step Execution
- Business Rules
- Execution Summary

This consistency makes it easier to understand and compare how different operations are implemented throughout the application.

---

# 1. User Registration Flow

  USER
                  │
                  ▼
┌──────────────────────────────────┐
│         Application              │
│ Collect Registration Details     │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│     RegistrationService          │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│      Validate Registration       │
│ • Username                       │
│ • PIN                            │
│ • Initial Deposit                │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Create BankAccount               │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Create User                      │
│ Attach BankAccount               │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ UserDatabaseHM.store(user)       │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Return UserResult                │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Application Displays Message     │
└──────────────────────────────────┘

---

# 2. User Login Flow

               USER
                 │
                 ▼
┌──────────────────────────────────┐
│        Application               │
│ Enter Credentials                │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│         LoginService             │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Search UserDatabaseHM            │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Validate Password                │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Return LoginResult               │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Application Opens User Menu      │
└──────────────────────────────────┘

---

# 3. Deposit Flow

            USER
               │
               ▼
┌──────────────────────────────────┐
│       Application                │
│ Enter Amount & PIN               │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│      DepositService              │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Validate Amount                  │
│ Validate PIN                     │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Update BankAccount Balance       │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Create Transaction               │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Return DepositResult             │
└──────────────────────────────────┘
│
▼
┌──────────────────────────────────┐
│ Application Displays Success     │
└──────────────────────────────────┘

---

# 4. Withdraw Flow

> * same identical to deposit flow *

---

# 5. Transfer Flow

                  USER
                   │
                   ▼
┌────────────────────────────────────┐
│          Application               │
└────────────────────────────────────┘
│
▼
┌────────────────────────────────────┐
│         TransferService            │
└────────────────────────────────────┘
│
▼
┌────────────────────────────────────┐
│ Search Receiver                    │
└────────────────────────────────────┘
│
▼
┌────────────────────────────────────┐
│ Validate                           │
│ • Receiver Exists                  │
│ • Sender != Receiver               │
│ • PIN                              │
│ • Balance                          │
└────────────────────────────────────┘
│                    │
▼                    ▼
┌──────────────────┐   ┌──────────────────┐
│ Debit Sender     │   │ Credit Receiver  │
└──────────────────┘   └──────────────────┘
│                    │
└──────────┬─────────┘
▼
┌────────────────────────────────────┐
│ Create Sender Transaction          │
│ Create Receiver Transaction        │
└────────────────────────────────────┘
│
▼
┌────────────────────────────────────┐
│ Return TransferResult              │
└────────────────────────────────────┘
│
▼
┌────────────────────────────────────┐
│ Application Displays Result        │
└────────────────────────────────────┘

---

# 6. Transaction History Flow

             USER
               │
               ▼
Application
│
▼
TransactionHistoryService
│
▼
BankAccount
│
▼
List<Transaction>
│
▼
Format Output
│
▼
Application Displays History

---

# Common Execution Pattern

Although every banking operation performs different business logic, all operations follow the same architectural pattern.

```text
User
   │
   ▼
Application
   │
   ▼
Service Layer
   │
   ▼
Validation
   │
   ▼
Repository
   │
   ▼
Domain Model
   │
   ▼
Result Object
   │
   ▼
Application
   │
   ▼
Console Output
```

This consistent execution pattern keeps the system modular, maintainable, and easy to extend. Every layer performs a single responsibility before delegating control to the next layer.

---

# Key Takeaways

- Every feature begins from the `Application` class.
- Business logic is delegated to dedicated services.
- Validation is performed before modifying business data.
- The repository is responsible for storing and retrieving information.
- Domain models represent real-world banking entities.
- Result Objects communicate the outcome of operations back to the Application.
- Every execution flow follows the same layered architecture while implementing different business rules.

---

## Conclusion

Understanding the execution flow is essential for understanding how the entire application works as a complete system.

Rather than viewing classes in isolation, execution flows demonstrate how multiple components collaborate to perform a business operation from start to finish.

The following sections explain each banking operation individually, allowing us to study the complete journey of a request through the application.