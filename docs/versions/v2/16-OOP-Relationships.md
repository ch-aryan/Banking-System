# 13 - OOP Relationships.md

> "Object-Oriented Programming is about how objects collaborate."

---

## Relationships Used

### Composition

A `User` owns exactly one `BankAccount`.

A `BankAccount` owns multiple `Transaction` objects.

If the owner is removed, the owned objects lose their meaning.

Examples:

- User → BankAccount
- BankAccount → Transaction

---

### Association

Services work with Repositories, Validators, and Factories to complete business workflows.

These objects collaborate but have independent lifecycles.

Examples:

- RegistrationService → UserRepository
- DepositService → DepositValidator

---

### Dependency

Most classes receive their collaborators through Constructor Injection.

Examples:

- RegistrationScreen → RegistrationController
- RegistrationController → RegistrationService
- RegistrationService → UserFactory

---

### Encapsulation

Each Domain Model protects its own data and exposes only the operations required by the business.

Examples:

- deposit()
- withdraw()
- addTransaction()

---

## What I Learned

Version 2 taught me that software is built by allowing small objects with clear responsibilities to collaborate rather than creating one large class that performs every task.