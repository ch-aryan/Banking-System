# Version 1 — Project Evolution

## Introduction

Version 0 successfully achieved its primary objective.

It introduced the fundamental concepts of object-oriented programming while building a functional console-based banking system.

The application supported user registration, login, deposit, withdrawal, validation, session management, and a clean package structure.

More importantly, Version 0 established a strong architectural foundation.

However, as new banking requirements appeared, the project naturally began revealing opportunities for improvement.

Version 1 was created to address those opportunities.

Rather than redesigning the entire application, Version 1 improves the existing architecture step by step while preserving the knowledge gained from Version 0.

This document explains that journey.

---

# Evolution Philosophy

One important principle guided every decision during Version 1.

> **Software should evolve because new problems appear, not because new ideas appear.**

Every improvement introduced during this version solves a problem that was discovered while building Version 0.

Nothing was redesigned simply for the sake of making the architecture more complicated.

Instead, every change was introduced only after its benefit became clear.

This gradual evolution mirrors how real software systems grow over time.

---

# Evolution 1 — Data Storage

## Version 0

Registered users were stored inside:

```java
ArrayList<User>
```

This was the simplest solution for learning collections and object references.

Searching for users required iterating through the entire collection.

```
ArrayList

↓

User

↓

User

↓

User
```

Although perfectly acceptable for Version 0, this approach became less suitable as the project expanded.

---

## Problem

Every login operation required searching the complete list.

Finding a specific account became increasingly dependent on iteration.

The application also lacked a dedicated component responsible for managing user storage.

---

## Decision

Introduce a Repository Layer backed by:

```java
HashMap<String, User>
```

using:

```
UserDatabaseHM
```

---

## Benefit

The repository became the single source of user data.

Searching by username became significantly simpler.

Business services no longer needed to understand how users were stored internally.

More importantly, this design prepares the project for replacing the in-memory repository with a real database in future versions.

---

# Evolution 2 — Banking Operations

## Version 0

The banking system initially supported:

- Deposit
- Withdraw
- Balance

These operations focused on modifying a single account.

---

## Problem

A real banking system must also support transferring money between different accounts.

Transfer introduces a much more complex business process because two users participate in the same operation.

---

## Decision

Introduce a dedicated:

```
TransferService
```

instead of placing transfer logic inside existing services.

The service coordinates:

- Sender
- Receiver
- Validation
- PIN Verification
- Balance Updates
- Transaction Creation

---

## Benefit

Each service continues owning only one primary responsibility.

Transfer logic remains isolated and easy to understand.

Future improvements can extend transfer functionality without affecting deposit or withdrawal services.

---

# Evolution 3 — Domain Model

## Version 0

The domain model contained two primary business objects.

```
User

↓

BankAccount
```

This accurately represented users and accounts.

---

## Problem

Deposits and withdrawals changed balances but left no historical record.

Once the balance changed, previous operations disappeared.

---

## Decision

Expand the domain model.

```
User

↓

BankAccount

↓

Transaction History

↓

Transaction
```

Every successful banking operation now creates a Transaction object.

---

## Benefit

The application now remembers every financial operation.

Transfer creates two independent transaction records:

- TRANSFER
- RECEIVED

This mirrors how real banking systems record account activity.

---

# Evolution 4 — Business Communication

## Version 0

Most business operations already returned Result objects.

This greatly improved communication between services and the application.

---

## Observation

As more services were introduced, Result objects became even more valuable.

TransferService naturally introduced:

```
TransferResult
```

while maintaining the same communication pattern established in Version 0.

---

## Benefit

All business operations now communicate consistently.

Each operation returns structured information instead of simple success or failure values.

---

# Evolution 5 — Validation

## Version 0

Validation focused primarily on:

- Registration
- Login
- Deposit
- Withdrawal

---

## Problem

Transfer introduced several new business rules.

Examples include:

- Receiver exists
- Cannot transfer to yourself
- Sufficient balance
- Maximum receiver balance
- PIN verification

---

## Decision

Expand the Validation Layer instead of embedding these rules inside TransferService.

---

## Benefit

Business rules remain reusable.

Services continue coordinating operations while validation remains centralized.

---

# Evolution 6 — Software Engineering Mindset

Perhaps the biggest evolution during Version 1 was not technical.

It was architectural.

During Version 0, many questions focused on implementation.

Examples included:

- How do I create this class?
- How do I use HashMap?
- How do I validate input?

Version 1 introduced a different style of thinking.

Questions gradually became:

- Who owns this responsibility?
- Should this logic belong here?
- Is this composition or aggregation?
- Can this responsibility be separated?
- Does this class represent a real business concept?

This shift represents the transition from learning Java syntax to learning software engineering.

---

# Preparing for Version 2

Version 1 intentionally stops after implementing all core banking features.

Instead of immediately introducing new functionality, the next version focuses on improving the existing architecture.

Version 2 will emphasize:

- Refactoring
- Cleaner responsibilities
- Reduced duplication
- Better abstractions
- Improved presentation
- Stronger engineering practices

This allows the project to mature before introducing enterprise technologies.

---

# Key Takeaway

Version 1 demonstrates that software does not become better by being rewritten.

It becomes better through continuous, thoughtful evolution.

Every improvement introduced during this version solves a real problem discovered during development.

The project has evolved from a simple Java practice application into a well-structured software engineering learning platform.

---

## Next Step

In the next document, we will examine the package structure of Version 1 and understand how each package contributes to the overall architecture of the application.