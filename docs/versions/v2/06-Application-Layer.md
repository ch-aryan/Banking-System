# Application Layer

> "Building an application and running an application are two different responsibilities."

---

# Introduction

The Application Layer is the first layer executed when the program starts.

Unlike the Domain Layer, it does not contain any banking rules or business logic.

Its responsibility is to construct the entire application, connect all required objects together, and finally start the software.

The Application Layer acts as the **Composition Root** of the application.

It is responsible for answering one question:

> "How should this application be assembled before it starts running?"

---

# Why Do We Need an Application Layer?

When I first started learning Java, the `main()` method was responsible for almost everything.

It created objects, initialized data, started the menus, and contained the complete startup logic.

That approach works for small learning programs.

However, as software grows, hundreds of objects need to be created and connected together.

If every object is created inside `Main.java`, it quickly becomes a large file that knows every class in the project.

Instead of acting as the entry point, `Main` slowly becomes responsible for constructing the entire application.

This violates the Single Responsibility Principle.

Version 2 solves this problem by introducing the Application Layer.

---

# Responsibilities of the Application Layer

The Application Layer is responsible for:

- Starting the application.
- Building the complete object graph.
- Wiring dependencies together.
- Creating application modules.
- Loading bootstrap data.
- Starting the Console Application.

It is **not responsible** for:

- Banking rules.
- Validation.
- Deposits.
- Withdrawals.
- User registration.
- Repository operations.
- Business decisions.

Its only responsibility is application assembly.

---

# Application Package Structure

```text
application
│
├── Application.java
├── ApplicationContext.java
├── Bootstrap.java
│
└── module
      ├── InfrastructureModule.java
      ├── DomainModule.java
      ├── PresentationModule.java
      ├── ConsoleModule.java
      └── ConsoleApplication.java
```

Each class has a specific responsibility during application startup.

---

# Main.java

`Main.java` is the Java entry point.

Its responsibility is intentionally small.

It simply starts the application.

Instead of knowing how to build the complete system, it delegates that responsibility to the Application Layer.

This keeps `Main` simple and focused.

```text
JVM
 │
 ▼
Main
 │
 ▼
Application
```

---

# Application.java

`Application.java` represents the starting point of my software.

While `Main.java` belongs to Java itself, `Application.java` belongs to my banking application.

Its responsibility is to initialize the application lifecycle.

This creates a clear separation between the Java runtime and the application startup process.

---

# ApplicationContext.java

`ApplicationContext` is the heart of the Application Layer.

Its responsibility is to construct the complete object graph of the application.

Instead of allowing individual classes to create their own dependencies, every object is created here and connected together.

This follows the **Composition Root Pattern**.

For example:

```text
RegistrationService
        │
        ├── RegistrationValidator
        ├── UserFactory
        └── UserRepository
```

None of these objects are created inside `RegistrationService`.

Instead, `ApplicationContext` creates them once and injects them into the service.

This makes dependencies explicit, improves maintainability, and prepares the architecture for Spring Boot Dependency Injection.

---

# Bootstrap.java

Before the application starts, some initial data must already exist.

For example:

- Demo users
- Sample bank accounts
- Initial transactions

`Bootstrap.java` is responsible for loading this initial application data.

It is part of application initialization rather than business logic.

In Spring Boot, this responsibility is commonly handled using `CommandLineRunner` or `ApplicationRunner`.

---

# Application Modules

As the project grew, even the startup process became large.

Instead of placing every object creation inside one file, the Application Layer was divided into specialized modules.

## InfrastructureModule

Builds shared infrastructure components.

Examples:

- UserRepository
- ConsoleContext

---

## DomainModule

Builds the complete Domain Layer.

Creates:

- Services
- Validators
- Factory

This module assembles the business layer without executing any business logic.

---

## PresentationModule

Builds the Presentation Layer.

Creates:

- Controllers

Controllers receive their required Services through constructor injection.

---

## ConsoleModule

Builds the Console User Interface.

Creates:

- Screens
- Navigators

This module assembles everything related to the Console experience.

---

## ConsoleApplication

After every object has been created and connected together, the Console Application starts the user experience.

Its responsibility is simply to launch the application.

---

# Complete Startup Flow

Every execution begins with the following sequence:

```text
JVM
 │
 ▼
Main
 │
 ▼
Application
 │
 ▼
ApplicationContext
 │
 ▼
Application Modules
 │
 ▼
ConsoleApplication
 │
 ▼
WelcomeScreen
```

This startup sequence remains independent of any banking feature.

Whether the user chooses Registration, Login, Deposit, or Transfer, every feature starts from this same application flow.

---

# Architectural Decisions

## Why not create everything inside Main.java?

At first, placing every `new` statement inside `Main.java` seems simple.

However, as the project grows, `Main` would become responsible for creating every object in the system.

Eventually it would know about every Service, Controller, Screen, Repository, and Validator.

This creates a large startup class with too many responsibilities.

Instead, Version 2 separates application startup into dedicated classes.

`Main` now has only one responsibility:

> Start the application.

Everything else is delegated to the Application Layer.

This follows the Single Responsibility Principle and keeps the startup process clean and maintainable.

A good analogy is launching a game.

When we open a game, we only click **Play**.

We do not manually initialize graphics, audio, networking, menus, or player profiles.

All those systems are prepared internally before the game begins.

Similarly, `Main.java` simply starts the application.

The Application Layer prepares everything required before the user interacts with the system.

---

# Spring Boot Mapping

One of the major goals of Version 2 was preparing for Spring Boot.

The manual architecture created in this version maps naturally to Spring Boot concepts.

| Version 2 | Spring Boot |
|------------|-------------|
| Main | `main()` |
| Application | `SpringApplication.run()` |
| ApplicationContext | Spring IoC Container |
| Modules | `@Configuration` + Component Scanning |
| Constructor Injection | Spring Dependency Injection |
| Bootstrap | `CommandLineRunner` / `ApplicationRunner` |

Because these concepts were implemented manually first, Version 3 will focus on understanding the framework rather than learning architecture from scratch.

---

# What I Learned

Before Version 2, I believed software started with business logic.

After designing the Application Layer, I learned that software first needs to be assembled before it can execute any feature.

I also learned that object creation is itself an architectural responsibility.

Keeping application startup separate from business logic makes the system easier to understand, easier to maintain, and naturally prepares it for enterprise frameworks like Spring Boot.

The biggest lesson I learned from this chapter is:

> **A good application starts by organizing responsibilities before executing functionality.**