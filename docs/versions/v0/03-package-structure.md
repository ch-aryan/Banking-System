# Version 0 — Package Structure

## Why were packages introduced?

When this project started, there were only a few Java classes.

```
src

versions.v0.Main.java
User.java
UserRegistration.java
UserLogin.java
```

Keeping everything together was simple and easy to understand.

As the project grew, more classes were introduced.

Examples included:

- BankAccount
- ValidationRules
- LoginResult
- DepositService
- WithdrawService
- versions.v0.Session
- IdGenerator

Finding classes became more difficult.

Some classes represented business objects.

Some contained business logic.

Some performed validation.

Some simply stored results.

Everything had different responsibilities.

To make the project easier to understand, classes were grouped based on what they do rather than when they were created.

---

## Package Structure

```
src

versions.v0.Model/
Service/
versions.v0.Validation/
Result/
versions.v0.Session/
Util/
```

---

## Why each package exists

### versions.v0.Model

Represents real-world banking objects.

Examples:

- User
- BankAccount

---

### Service

Contains business operations.

Examples:

- UserRegistration
- UserLogin
- DepositService
- WithdrawService

---

### versions.v0.Validation

Contains reusable business rules.

Examples:

- Username validation
- Password validation
- PIN validation

---

### Result

Returns detailed operation results instead of simple boolean values.

Examples:

- LoginResult
- UserResult
- DepositResult

---

### versions.v0.Session

Keeps track of the currently logged-in user.

---

### Utility

Contains helper classes.

Example:

- IdGenerator

---

## Key Takeaway

Packages were introduced because the project grew, not because Java requires them.

They help organize responsibilities and make the codebase easier to navigate.

The next document explains the design decisions of Version 0