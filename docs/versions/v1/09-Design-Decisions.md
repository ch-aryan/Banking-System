# Version 1 - Design Decisions

## Introduction

This document explains the important design decisions made while developing Version 1 of the Banking System. Each decision was taken to improve code organization, readability, maintainability, and to prepare the project for future development.

---

## 1. Layered Architecture

Separated the application into different layers such as Application, Service, Repository, and Model instead of writing everything inside one class.

---

## 2. HashMap for User Storage

Used a `HashMap<String, User>` instead of an `ArrayList<User>` to provide faster user lookup using the username as the key.

---

## 3. Repository Pattern

Created a separate `UserDatabaseHM` class to manage user storage instead of allowing every class to access the HashMap directly.

---

## 4. Service Layer

Moved business logic into dedicated service classes like RegistrationService, LoginService, DepositService, and TransferService to keep the Application class clean.

---

## 5. Result Objects

Created Result classes instead of returning primitive values like `boolean` or `String`, allowing operations to return both status and additional information.

---

## 6. Composition

Used Composition between `User` and `BankAccount` because a bank account cannot exist independently without a user.

---

## 7. Aggregation

Used Aggregation where shared objects can exist independently, such as passing the user collection into services like UserLogin.

---

## 8. Transaction Model

Created a dedicated `Transaction` class instead of storing transaction information as plain strings.

---

## 9. TransactionType Enum

Used an Enum for transaction types to avoid invalid string values and improve code readability.

---

## 10. Validation Before Processing

Validated user input before performing business operations to ensure data consistency and reduce errors.

---

## 11. Encapsulation

Declared class fields as `private` and provided controlled access using getters and setters.

---

## 12. Package Organization

Organized classes into packages based on their responsibility, making the project easier to understand and maintain.

---

## 13. LocalDateTime

Used `LocalDateTime` to record the exact date and time of every transaction.

---

## 14. Future Ready Design

Designed the project in a way that allows easy migration to Spring Boot, PostgreSQL, and REST APIs without major structural changes.

---


# Design Decision 1
## Layered Architecture

### Problem

Initially, all application logic was placed inside a single class. As the project grew, the code became difficult to read, maintain, and extend.

### Decision

Separated the application into multiple layers:
- Application
- Service
- Repository
- Model

### Why This Decision?

Each layer has a single responsibility, making the project easier to understand and maintain.

### Benefits

- Clear separation of responsibilities.
- Improved readability.
- Easier maintenance and debugging.

### Trade-offs

- More classes to manage.
- Slightly more project structure.

### Future Impact

This architecture can be migrated to Spring Boot with minimal structural changes.

---

# Design Decision 2
## Using HashMap for User Storage

### Problem

Using an `ArrayList<User>` required iterating through every user during login, making lookups slower as the number of users increased.

### Decision

Used a `HashMap<String, User>` with the username as the key.

### Why This Decision?

HashMap provides fast user lookup and naturally enforces unique usernames.

### Benefits

- Fast average lookup time.
- Simpler retrieval logic.
- Better scalability.

### Trade-offs

- Slightly higher memory usage.
- Does not preserve insertion order.

### Future Impact

The lookup approach is similar to querying a database using a unique identifier.

---

# Design Decision 3
## Repository Pattern

### Problem

Allowing every class to access the user collection directly would tightly couple the application to its storage implementation.

### Decision

Created the `UserDatabaseHM` repository class to manage all user storage operations.

### Why This Decision?

The repository centralizes data access and hides storage implementation details from the rest of the application.

### Benefits

- Better encapsulation.
- Cleaner architecture.
- Centralized data management.

### Trade-offs

- One additional abstraction layer.
- Slight increase in code size.

### Future Impact

The repository can later be replaced with a database implementation without changing the service layer.

---

# Design Decision 4
## Service Layer

### Problem

Mixing business logic with menu handling made the Application class large and difficult to maintain.

### Decision

Moved business logic into dedicated service classes such as:
- RegistrationService
- LoginService
- DepositService
- WithdrawService
- TransferService
- TransactionHistoryService

### Why This Decision?

Each service focuses on a single business responsibility.

### Benefits

- Cleaner Application class.
- Better code organization.
- Easier testing and maintenance.

### Trade-offs

- More classes to manage.
- Additional method calls.

### Future Impact

These services can be reused directly inside Spring Boot controllers.

---

# Design Decision 5
## Result Objects

### Problem

Returning only primitive values like `boolean` or `String` could not provide enough information about an operation.

### Decision

Created dedicated result classes such as:
- UserResult
- LoginResult
- DepositResult
- WithdrawResult
- TransferResult

### Why This Decision?

Operations often need to return both the operation status and additional information.

### Benefits

- Richer responses.
- Better readability.
- Easier error handling.

### Trade-offs

- Additional classes.
- Slightly more code.

### Future Impact

These result classes can later become API response objects in Spring Boot.

---

# Design Decision 6
## Composition Between User and BankAccount

### Problem

A bank account should not exist independently without its owner.

### Decision

Used composition by making `BankAccount` a part of the `User` object.

### Why This Decision?

The lifecycle of a bank account depends entirely on the user who owns it.

### Benefits

- Correct real-world modeling.
- Strong ownership relationship.
- Better object consistency.

### Trade-offs

- BankAccount cannot exist independently.

### Future Impact

The same relationship can later be represented using JPA's `@OneToOne` mapping.

---

# Design Decision 7
## Transaction as a Separate Model

### Problem

Storing transaction history as plain text would make future enhancements difficult.

### Decision

Created a dedicated `Transaction` model containing transaction details.

### Why This Decision?

Each transaction has its own data such as amount, type, date, and description.

### Benefits

- Better object-oriented design.
- Easier reporting and filtering.
- Improved maintainability.

### Trade-offs

- Additional model class.
- Slightly more memory usage.

### Future Impact

Supports future features such as transaction statements, filtering, analytics, and database persistence.

---

# Design Decision 8
## Using Enum for Transaction Types

### Problem

Using string values like `"Deposit"` or `"Withdraw"` could lead to spelling mistakes and inconsistent values.

### Decision

Created the `TransactionType` enum.

### Why This Decision?

Enums restrict values to a predefined set of valid transaction types.

### Benefits

- Type safety.
- Better readability.
- Prevents invalid values.

### Trade-offs

- New transaction types require updating the enum.

### Future Impact

The enum can be stored directly in a database and used consistently throughout the application.

---

# Conclusion

The design decisions made in Version 1 were focused on building a clean, maintainable, and extensible architecture rather than simply implementing banking features. By applying object-oriented principles, separating responsibilities, and organizing the code into well-defined layers, the project establishes a solid foundation for future versions using Spring Boot, PostgreSQL, and REST APIs.
# Key Takeaways

- Business logic is separated from user interaction.
- Classes have a single responsibility.
- Object-Oriented Programming principles are followed throughout the project.
- The project structure is designed for learning as well as future scalability.