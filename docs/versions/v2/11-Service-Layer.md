# Service Layer

> "A Service does not perform every task itself. It orchestrates specialized components to complete one business use case."

---

# Purpose

The Service Layer represents the business operations of the application.

Each Service owns one complete use case.

Instead of implementing every responsibility itself, a Service coordinates multiple specialized classes to complete the business workflow.

For this reason, Services are often called **Business Orchestrators**.

---

# Service Structure

```text
service
│
├── RegistrationService
├── LoginService
├── DepositService
├── WithdrawService
├── TransferService
├── BalanceService
└── TransactionHistoryService
```

Each Service is responsible for exactly one business operation.

---

# Responsibilities

The Service Layer is responsible for:

- Executing business workflows
- Coordinating Validators
- Coordinating Factories
- Coordinating Repositories
- Returning Response DTOs

The Service Layer is **not responsible** for:

- Reading user input
- Printing output
- Navigation
- Parsing console data
- Creating dependencies
- Storing data directly

---

# How a Service Works

A Service acts as the coordinator of a business operation.

For example, the Registration workflow follows this sequence:

```text
RegistrationService
        │
        ├── RegistrationValidator
        │
        ├── UserFactory
        │
        └── UserRepository
```

Instead of validating, creating, and storing the user itself, the Service delegates each responsibility to the appropriate component.

Finally, it returns a Response DTO back to the Presentation Layer.

---

# Why Separate Services?

Without a Service Layer, business logic would be scattered across Screens, Controllers, or Repositories.

The Service Layer centralizes the business workflow while keeping each supporting class focused on a single responsibility.

This improves readability, maintainability, and extensibility.

---

# Design Decisions

- One Service per business use case.
- Services orchestrate, not implement every responsibility.
- Services communicate with Validators, Factories, and Repositories.
- Services return Response DTOs.
- Services never perform user interaction.

---

# Spring Boot Mapping

| Version 2 | Spring Boot |
|------------|-------------|
| RegistrationService | `@Service` |
| LoginService | `@Service` |
| DepositService | `@Service` |
| WithdrawService | `@Service` |
| TransferService | `@Service` |
| BalanceService | `@Service` |

The architecture remains the same in Spring Boot.

Only dependency creation is handled automatically by the Spring IoC Container.

"A Service owns the workflow, not the work."

Read that again.

Service owns the workflow.

It does not own:

Validation

Object Creation

Data Storage

Console Output

It only decides:

"Who should do the next piece of work?"

Example:

RegistrationService

↓

RegistrationValidator
"Is the request valid?"

↓

UserFactory
"Create the User."

↓

UserRepository
"Store the User."

↓

RegistrationResponse
"Return the result."

Notice something beautiful.

The Service itself never validates.

It never creates the User.

It never stores the User.

It only orchestrates.

And I think this sentence deserves to be remembered because it captures one of the biggest software engineering lessons from Version 2:

"A Service owns the workflow, not the work."
---

# What I Learned

The biggest lesson I learned from the Service Layer is that a Service should never become a "God Class."

Its responsibility is not to perform every task itself.

Its responsibility is to coordinate specialized components and execute the complete business workflow.

This taught me that software engineering is not about writing larger classes.

It is about allowing smaller, focused classes to collaborate together to solve a problem.