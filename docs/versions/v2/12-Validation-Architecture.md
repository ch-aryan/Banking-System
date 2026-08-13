# Validation Architecture

> "Validation protects the business from invalid operations before business logic is executed."

---

# Purpose

The Validation Architecture is responsible for ensuring that every business request satisfies the required rules before the Service executes the workflow.

Instead of placing validation logic inside Services, Version 2 delegates this responsibility to dedicated Validators and reusable Rule classes.

This keeps business workflows clean and focused.

---

# Validation Structure

```text
validator
│
├── RegistrationValidator
├── LoginValidator
├── DepositValidator
├── WithdrawValidator
├── TransferValidator
│
└── rules
      ├── NameRules
      ├── UsernameRules
      ├── PasswordRules
      ├── PinRules
      ├── AmountRules
      ├── BalanceRules
      └── DateOfBirthRules
```

---

# Responsibilities

Validators are responsible for:

- Validating one business request
- Applying the required business rules
- Returning validation results to the Service

Validators are **not responsible** for:

- Creating domain objects
- Updating account balances
- Storing data
- Printing messages
- Executing business workflows

---

# Rule Classes

Rule classes represent small reusable validation rules.

Examples:

- Username format
- Password strength
- PIN validation
- Deposit amount validation
- Balance checks
- Date of Birth validation

Each rule performs one validation only.

This allows the same rule to be reused across multiple Validators.

---

# Validation Flow

Every business operation follows the same validation flow.

```text
Request DTO
      │
      ▼
Validator
      │
      ▼
Rule Classes
      │
      ▼
Validation Result
      │
      ▼
Service
```

The Service decides whether to continue the business workflow based on the validation result.

---

# Design Decisions

- One Validator per business use case.
- One Rule per validation responsibility.
- Rules remain reusable across multiple Validators.
- Services never contain validation logic.
- Validation executes before business operations begin.

---

# Why Separate Validators and Rules?

Separating Validators from Rules prevents duplication.

For example, `PinRules` can be reused by:

- DepositValidator
- WithdrawValidator
- TransferValidator

instead of implementing the same validation multiple times.

This follows the **Single Responsibility Principle (SRP)** and the **Don't Repeat Yourself (DRY)** principle.

---

# Spring Boot Mapping

| Version 2 | Spring Boot |
|------------|-------------|
| Validators | `@Component` or custom validator |
| Rule Classes | Bean Validation (`@Valid`, `@Pattern`, `@Size`) or reusable domain validators |
| Validation Flow | Validation before Service execution |

---

# What I Learned

Version 2 taught me that validation is a separate business responsibility.

A Service should not become responsible for checking every business rule.

Instead, validation should be delegated to dedicated Validators, while reusable Rule classes keep common validations consistent across the application.

This makes the business workflow easier to read, easier to maintain, and easier to extend.