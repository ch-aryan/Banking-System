# DTO Architecture

> "A DTO transfers data between layers without exposing business objects."

---

# Purpose

The DTO (Data Transfer Object) Architecture is responsible for carrying data between the Presentation Layer and the Domain Layer.

Instead of passing Domain Models directly, Version 2 uses dedicated Request and Response objects to communicate between layers.

This keeps the Presentation Layer independent from the internal business model.

---

# DTO Structure

```text
contract
│
├── request
│     ├── RegistrationRequest
│     ├── LoginRequest
│     ├── DepositRequest
│     ├── WithdrawRequest
│     ├── TransferLookupRequest
│     ├── TransferConfirmationRequest
│     ├── BalanceRequest
│     └── TransactionHistoryRequest
│
└── response
      ├── RegistrationResponse
      ├── LoginResponse
      ├── DepositResponse
      ├── WithdrawResponse
      ├── TransferResponse
      ├── BalanceResponse
      └── TransactionHistoryResponse
```

---

# Responsibilities

Request DTOs are responsible for:

- Carrying user input from the Presentation Layer to the Domain Layer.

Response DTOs are responsible for:

- Carrying the result of a business operation back to the Presentation Layer.

DTOs are **not responsible** for:

- Business logic
- Validation
- Data persistence
- Object creation

They only transport data.

---

# Request–Response Flow

Every business operation follows the same communication pattern.

```text
Screen
    │
    ▼
Request DTO
    │
    ▼
Controller
    │
    ▼
Service
    │
    ▼
Response DTO
    │
    ▼
Screen
```

This creates a clear contract between the Presentation Layer and the Domain Layer.

---

# Design Decisions

- Every use case owns its own Request DTO.
- Every use case owns its own Response DTO.
- DTOs contain only data.
- DTOs never contain business logic.
- Domain Models are never exposed directly to the Presentation Layer.

---

# Why Use DTOs?

Without DTOs, the Presentation Layer would directly depend on Domain Models.

Using dedicated Request and Response objects keeps both layers independent and allows the internal business model to evolve without affecting the user interface.

---

# Spring Boot Mapping

| Version 2 | Spring Boot |
|------------|-------------|
| Request DTO | `@RequestBody` |
| Response DTO | `ResponseEntity<T>` / JSON Response |
| DTO Contract | API Contract |

---

# What I Learned

I learned that communication between layers should happen through well-defined contracts instead of exposing business objects directly.

DTOs make the architecture cleaner, reduce coupling, and prepare the project for REST APIs in Spring Boot.