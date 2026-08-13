# 15 - SOLID Principles.md

> "SOLID principles help build software that is easy to maintain and extend."

---

## S - Single Responsibility Principle (SRP)

Every class has one responsibility.

Examples:

- RegistrationScreen → User interaction
- RegistrationController → Delegation
- RegistrationService → Workflow orchestration
- RegistrationValidator → Business validation
- UserRepository → Data storage

---

## O - Open/Closed Principle (OCP)

The architecture allows new features to be added with minimal changes.

Examples:

- New Service
- New Validator
- New Screen

Existing classes remain unchanged.

---

## L - Liskov Substitution Principle (LSP)

Not explicitly demonstrated in Version 2 because inheritance is intentionally minimal.

---

## I - Interface Segregation Principle (ISP)

Not applied in Version 2 because interfaces were intentionally avoided to keep the learning focused.

This principle will become more relevant in Spring Boot.

---

## D - Dependency Inversion Principle (DIP)

High-level classes receive their dependencies instead of creating them.

Examples:

- Services receive Validators and Repositories.
- Controllers receive Services.
- Screens receive Controllers.

---

# What I Learned

Version 2 taught me that good software is achieved by separating responsibilities and allowing classes to collaborate through clear dependencies rather than tightly coupling them together.