# Version 1 — Domain Model

## Introduction

A domain model represents the core business entities of an application and the relationships between them.

Instead of focusing on implementation details, the domain model describes how real-world concepts are represented within the software.

In the banking system, the domain model is intentionally kept simple. Every model corresponds to an actual entity found in a real bank, making the application easier to understand and extend.

---

# Domain Model Overview

```
    User
    │
    └── owns
         │
         ▼
    BankAccount
    │
    └── contains
         │
         ▼
    ArrayList<Transaction>
    │
    └── stores
         │
         ▼
          Transaction
                  │
                  │ classified by
                  ▼
         TransactionType
```

Each model has a specific responsibility and together they represent the core structure of the banking system.

---

# User

The `User` model represents a registered customer of the banking system.

A user is responsible for personal information such as:

- User ID
- Username
- Password
- Full Name
- Bank Account

A user does not directly perform banking operations.

Instead, it owns a bank account through which all financial transactions take place.

---

# BankAccount

The `BankAccount` model represents a customer's bank account.

It stores all financial information associated with a user.

Responsibilities include:

- Account Number
- PIN
- Balance
- Transaction History

Every bank account belongs to exactly one user.

A bank account manages its own balance and maintains the history of every successful transaction.

---

# Transaction

The `Transaction` model represents a single financial operation performed on a bank account.

Examples include:

- Deposit
- Withdraw
- Transfer
- Received Money

Each transaction records:

- Transaction ID
- Transaction Type
- Amount
- Date and Time
- Description
- Balance After Transaction

Once created, a transaction becomes part of the account's transaction history.

---

# TransactionType

`TransactionType` is an enumeration that categorizes every transaction.

Supported transaction types include:

- DEPOSIT
- WITHDRAW
- TRANSFER
- RECEIVED

Using an enum ensures that only valid transaction types can exist within the application.

---

# Relationship Between Models

The banking system follows a simple ownership hierarchy.

```
User
    │
    ▼
BankAccount
    │
    ▼
Transaction History
    │
    ▼
Transaction
```

This structure mirrors how banking information is naturally organized.

A user owns a bank account.

A bank account owns its transaction history.

The transaction history contains individual transaction records.

---

# Why This Domain Model?

The domain model was designed around real banking concepts rather than technical implementation.

For example:

- A transaction cannot exist without a bank account.
- A bank account cannot exist without a user.
- A transaction always belongs to one account.
- A transaction type describes the nature of a transaction.

By following real-world relationships, the software becomes easier to understand and maintain.

---

# Domain Model Benefits

The current domain model provides several advantages:

- Clear ownership of business data.
- Separation of customer information from financial information.
- Permanent record of account activity through transaction history.
- Easy addition of future banking features without changing existing models.
- Better alignment with real-world banking systems.

---

# Key Takeaway

The domain model defines the fundamental business entities of the banking system and the relationships between them.

Rather than focusing on Java classes, it focuses on representing the real-world concepts that the application manages.

A well-designed domain model provides a stable foundation upon which the rest of the application is built.

---

## Next Step

In the next document, we will examine the Object-Oriented relationships between these models and understand how concepts such as composition, aggregation, association, and dependency are applied throughout the project.