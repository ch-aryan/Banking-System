# Dependency Injection

> "A class should receive its dependencies, not create them."

---

# Purpose

Dependency Injection (DI) is a design principle that allows objects to receive the dependencies they need instead of creating them internally.

Version 2 implements Dependency Injection manually to understand how enterprise frameworks like Spring Boot manage object creation.

---

# How Dependency Injection Works

Instead of creating objects using `new` inside a class, the required dependencies are provided through the constructor.

Example:

```text
RegistrationService
        │
        ├── RegistrationValidator
        ├── UserFactory
        └── UserRepository
```

`RegistrationService` does not create these objects.

They are injected during application startup.

---

# Constructor Injection

Version 2 uses Constructor Injection throughout the project.

Benefits include:

- Explicit dependencies
- Easier testing
- Better readability
- Lower coupling
- Immutable dependencies using `final`

---

# Composition Root

All dependencies are created inside the Application Layer.

```text
Main
    │
Application
    │
ApplicationContext
    │
Modules
    │
Objects Created
```

This centralizes object creation and keeps business classes focused only on their responsibilities.

---

# Responsibilities

A class should:

- Use its dependencies.
- Never create its own dependencies.

Object creation belongs to the Application Layer.

Business logic belongs to the Domain Layer.

---

# Design Decisions

- Constructor Injection is used throughout the project.
- Dependencies are marked as `final`.
- Object creation is centralized inside `ApplicationContext`.
- Services, Controllers, and Screens never create their own collaborators.

---

# Why Use Dependency Injection?

Without Dependency Injection, every class becomes responsible for creating its own dependencies.

This increases coupling and makes the architecture harder to maintain.

By injecting dependencies, each class focuses only on its own responsibility.

---

# Spring Boot Mapping

| Version 2 | Spring Boot |
|------------|-------------|
| Constructor Injection | Constructor Injection |
| ApplicationContext | Spring IoC Container |
| Modules | `@Configuration` |
| Object Wiring | Spring Bean Management |

---

# What I Learned

Before Version 2, I created objects wherever they were needed.

Version 2 taught me that object creation is an architectural responsibility.

By separating object creation from object usage, the software becomes easier to maintain, easier to test, and naturally compatible with Spring Boot's IoC container.