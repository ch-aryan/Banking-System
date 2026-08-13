# Domain Model

> "Domain Models represent the business entities of the application."

---

# Purpose

The Domain Model represents the real-world objects that exist in the banking system.

Unlike Services, which perform business operations, Domain Models represent the business itself.

They contain business state and behavior that naturally belongs to the entity.

---

# Domain Models

```text
domain
└── model
      ├── User
      ├── BankAccount
      ├── Transaction
      └── TransactionType
```

---

# Model Responsibilities

| Model | Responsibility |
|--------|----------------|
| User | Represents a banking customer and owns a BankAccount. |
| BankAccount | Maintains account information, balance, PIN, and transaction history. |
| Transaction | Represents a single banking operation. |
| TransactionType | Defines the type of transaction (Deposit, Withdraw, Transfer). |

---

# Design Decisions

- Business entities are separated from Services.
- Each model owns only its own state and behavior.
- Models do not know about Screens or Controllers.
- Relationships are expressed using Composition and Association where appropriate.

---

# Why Separate Models from Services?

A model represents **what the business owns**.

A service represents **what the business does**.

Separating them keeps the architecture clean and easier to maintain.

---

# Spring Boot Mapping

| Version 2 | Spring Boot |
|------------|-------------|
| User | `@Entity` |
| BankAccount | `@Entity` |
| Transaction | `@Entity` |
| TransactionType | Enum |

---

# What I Learned

I learned that Domain Models describe the business entities, while Services describe the business operations.

Keeping these responsibilities separate makes the software easier to understand and naturally prepares the project for JPA entities in Spring Boot.