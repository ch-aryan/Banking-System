# Domain Layer

> "The Domain Layer is the brain of the application.
> It contains the business knowledge, not the user interface."

---

# Introduction

The Domain Layer represents the core business of the application.

It is the most important layer in the entire architecture because it contains the rules, behavior, and decisions that define how the banking system works.

Unlike the Presentation Layer, which communicates with the user, or the Repository Layer, which stores data, the Domain Layer is responsible for answering one question:

> "How should the business operate?"

Every banking operation eventually reaches this layer.

Whether a user registers, logs in, deposits money, withdraws funds, transfers money, or checks their balance, the business decision is made here.

For this reason, the Domain Layer is often considered the heart of the software.

---

# Why Do We Need a Domain Layer?

When I first started learning Java, most of my business logic lived inside the same class that interacted with the user.

For example, one method would:

- Read user input
- Validate data
- Create objects
- Update account balance
- Print messages

Although this approach works for small console applications, it mixes multiple responsibilities into one place.

Version 2 introduces the Domain Layer to solve this problem.

Instead of allowing user interface classes to make business decisions, every decision is delegated to the Domain Layer.

This creates a clear separation between **communication** and **business logic**.

---

# Domain Package Structure

```text
domain
│
├── factory
│      UserFactory.java
│
├── model
│      User.java
│      BankAccount.java
│      Transaction.java
│      TransactionType.java
│
├── service
│      RegistrationService.java
│      LoginService.java
│      DepositService.java
│      WithdrawService.java
│      TransferService.java
│      BalanceService.java
│      TransactionHistoryService.java
│
└── validator
       RegistrationValidator.java
       LoginValidator.java
       DepositValidator.java
       WithdrawValidator.java
       TransferValidator.java

       rules
           NameRules.java
           UsernameRules.java
           PasswordRules.java
           PinRules.java
           AmountRules.java
           BalanceRules.java
           DateOfBirthRules.java
```

The Domain Layer is divided into four major responsibilities:

- Models
- Services
- Validators
- Factory

Each one solves a different business problem.

---

# Responsibilities of the Domain Layer

The Domain Layer is responsible for:

- Business workflows
- Business validation
- Domain object creation
- Domain modeling
- Business rules
- Use-case orchestration

The Domain Layer is **not responsible** for:

- Reading console input
- Printing output
- Navigation
- Object wiring
- Application startup
- Data storage implementation

Its only responsibility is business.

---

# Domain Models

Domain Models represent the real-world entities that exist inside the banking system.

Examples include:

- User
- BankAccount
- Transaction

These classes represent **what the business owns**, not **what the business does**.

The Domain Models are intentionally independent of the Console, Controllers, and Repository.

They simply describe the business objects.

Their design will be discussed in detail in the next chapter.

---

# Services

Services represent business use cases.

Each service owns one business operation.

Examples include:

- User Registration
- Login
- Deposit
- Withdraw
- Transfer
- Balance Inquiry
- Transaction History

A service does not perform every task itself.

Instead, it coordinates multiple specialized components to complete one business workflow.

For this reason, Services are often described as **Business Orchestrators**.

---

# Validators

Validators protect the business from invalid operations.

Their responsibility is to verify whether a request satisfies all business rules before the Service continues.

Examples include:

- Username format
- Password requirements
- PIN verification
- Deposit amount
- Balance availability
- Transfer validation

Version 2 separates reusable rules from feature-specific validators.

This keeps validation consistent and avoids duplication across multiple services.

---

# Validation Rules

Instead of writing every validation directly inside the Validators, reusable business rules are extracted into the `rules` package.

For example:

- UsernameRules
- PasswordRules
- PinRules
- BalanceRules

These rules can be reused by multiple Validators.

This follows the **Don't Repeat Yourself (DRY)** principle and keeps validation logic organized.

---

# Factory

The Factory owns object creation.

Instead of allowing Services to manually create complex domain objects, object construction is delegated to the Factory.

For example:

Instead of:

```java
new User(...)
new BankAccount(...)
```

inside the Service,

Version 2 delegates this responsibility to:

```
UserFactory
```

This keeps Services focused on business workflows rather than object construction.

---

# Collaboration Inside the Domain Layer

The Domain Layer is built around collaboration.

Each component performs one specialized responsibility.

A Registration use case follows this sequence:

```text
RegistrationService
        │
        ├── RegistrationValidator
        │
        ├── UserFactory
        │
        └── UserRepository
```

The Service coordinates the complete workflow.

The Validator verifies business rules.

The Factory creates business objects.

The Repository stores them.

No single class performs every responsibility.

---

# Why Is Repository Outside the Domain?

One of the most important architectural decisions in Version 2 was placing the Repository outside the Domain package.

Although Services use the Repository, storing data is not considered business logic.

The Domain answers:

> "What should happen?"

The Repository answers:

> "Where should it be stored?"

Separating these responsibilities makes the Domain independent of storage technology.

In Version 3, the Repository can evolve from an in-memory collection to PostgreSQL using Spring Data JPA without changing the business workflows.

---

# Dependency Direction

The Domain Layer depends only on components required to execute business logic.

```text
Presentation
      │
      ▼
Service
   ↙       ↘
Validator  Repository
      │
      ▼
 Domain Model
```

The Domain never depends on:

- Screens
- Console
- Navigation
- Printer
- Scanner

This keeps business logic independent from the user interface.

---

# Architectural Decisions

Several important design decisions shaped the Domain Layer.

- Every use case owns one Service.
- Every Service owns one business workflow.
- Validation is separated from orchestration.
- Object creation is delegated to a Factory.
- Business entities remain independent of Presentation.
- Reusable rules are extracted into dedicated Rule classes.
- Business logic never enters the Presentation Layer.

These decisions reduced coupling and improved maintainability.

---

# Preparing for Spring Boot

The architecture of the Domain Layer maps naturally to enterprise development.

| Version 2 | Spring Boot |
|------------|-------------|
| Services | `@Service` |
| Validators | `@Component` / Bean Validation |
| Factory | `@Component` |
| Domain Models | JPA Entities / Domain Objects |
| Validation Rules | Constraint Validators / Domain Services |

The biggest advantage is that the business logic remains almost unchanged when migrating to Spring Boot.

Only the surrounding infrastructure changes.

---

# What I Learned

Before Version 2, I believed the most important part of software was writing features.

After designing the Domain Layer, I realized that the most important part of software is organizing business responsibilities.

The Domain Layer taught me that software should think in terms of business operations rather than user interfaces.

By separating Services, Validators, Factories, and Domain Models into their own responsibilities, I learned how professional software keeps business logic independent, maintainable, and ready to evolve as the application grows.

The biggest lesson I learned from this chapter is:

> **The Domain Layer should know everything about the business and nothing about the user interface.**