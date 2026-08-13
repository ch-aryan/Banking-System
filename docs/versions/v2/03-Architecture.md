# Architecture

> "Good software architecture is not measured by how many classes exist.
> It is measured by how clearly responsibilities are separated."

---

# Introduction

Version 2 is the first version of this project where the focus shifted from writing features to designing software.

Previous versions taught me how to write Java programs and build object-oriented systems.

Version 2 taught me how professional software is organized.

Instead of thinking about individual classes, I started thinking about responsibilities, layers, dependencies, and collaboration between components.

The architecture introduced in this version became the bridge between Core Java and enterprise backend development.

---

# Why Architecture?

One question completely changed the way I think about software.

Instead of asking,

> "How do I implement this feature?"

I started asking,

> "Which class should own this responsibility?"

That single question led to the layered architecture used throughout Version 2.

Every class now has one clear responsibility.

Every package owns one part of the application.

Every dependency exists for a reason.

This makes the system easier to understand, maintain, extend, and eventually migrate to Spring Boot.

---

# Architectural Philosophy

The goal of this architecture was never to imitate Spring Boot.

Instead, the goal was to understand the responsibilities that Spring Boot automates.

For that reason, everything is implemented manually.

- Manual Dependency Injection
- Manual Composition Root
- Manual Controller Layer
- Manual Service Layer
- Manual Repository Layer

By building these layers ourselves, we understand what enterprise frameworks actually do behind the scenes.

---

# High-Level Architecture

The application follows a layered architecture.

```text
                    User
                      │
                      ▼
            Console Application
                      │
                      ▼
              Presentation Layer
        (Screens + Navigation + Controller)
                      │
                      ▼
               Service Layer
            (Business Orchestration)
             ↙                  ↘
      Validation Layer     Repository Layer
             │                  │
             ▼                  ▼
         Domain Models      Data Storage
```

Each layer has one responsibility.

Each layer communicates only with the layer directly below it.

No layer skips another layer.

---

# Layer Responsibilities

## 1. Presentation Layer

The Presentation Layer represents everything related to user interaction.

It is responsible for:

- Displaying menus
- Reading user input
- Showing responses
- Navigation between screens
- Calling controllers

It never performs business logic.

It never updates data directly.

Its only responsibility is communication with the user.

---

## 2. Controller Layer

Controllers act as the entry point for every use case.

Their job is intentionally simple.

They receive a request from the Presentation Layer, delegate it to the appropriate Service, and return the response.

Controllers never contain business rules.

Controllers never interact with the repository directly.

They only coordinate communication between Presentation and Domain.

---

## 3. Service Layer

The Service Layer is the heart of every use case.

A service does not own every responsibility.

Instead, it orchestrates the complete business workflow.

For example, RegistrationService performs the following sequence:

```text
Receive Request
        │
        ▼
Validate Request
        │
        ▼
Create Domain Object
        │
        ▼
Store Object
        │
        ▼
Return Response
```

Rather than implementing validation, object creation, or persistence itself, the service delegates each responsibility to a specialized component.

For this reason, we often describe a service as the **Business Orchestrator**.

---

## 4. Validation Layer

Validation ensures that business rules are satisfied before the application modifies any data.

Examples include:

- Username format
- Password rules
- PIN verification
- Deposit amount
- Withdrawal limits
- Balance checks

Version 2 separates reusable validation rules from feature-specific validators.

This allows multiple services to reuse the same business rules without duplication.

---

## 5. Repository Layer

The Repository Layer owns persistence.

It hides how data is stored from the rest of the application.

The service simply requests:

> "Store this user."

The service never knows whether the repository uses:

- ArrayList
- HashMap
- PostgreSQL
- MongoDB

This abstraction allows the storage mechanism to evolve without affecting business logic.

---

## 6. Domain Layer

The Domain Layer represents the business itself.

It contains the concepts that exist regardless of technology.

Examples:

- User
- BankAccount
- Transaction

These classes model the real-world banking domain.

They are independent of the console, controllers, or repositories.

---

# Complete Execution Flow

Every feature follows the same architectural pipeline.

```text
Screen
    │
    ▼
Controller
    │
    ▼
Service
   ↙      ↘
Validator Repository
    │
    ▼
Domain Model
    │
    ▼
Response
    │
    ▼
Screen
```

This consistency is one of the biggest architectural improvements introduced in Version 2.

Regardless of whether the feature is Registration, Login, Deposit, Withdraw, Transfer, or Balance Inquiry, the execution flow remains the same.

---

# Architectural Decisions

Several important architectural decisions shaped Version 2.

- Business logic belongs in Services.
- Validation belongs in the Domain.
- Navigation belongs in the Console layer.
- Controllers remain thin.
- DTOs separate Presentation from Domain.
- Repositories hide persistence.
- Factories own object creation.
- Every dependency is injected manually through the Composition Root.

These decisions reduced coupling and increased maintainability.

---

# Why This Matters

Without architecture, a single class would eventually become responsible for:

- Reading user input
- Validating data
- Creating objects
- Updating the database
- Printing output

Such classes become difficult to understand and almost impossible to maintain.

Layered Architecture solves this problem by distributing responsibilities across multiple specialized components.

Each component becomes smaller, simpler, and easier to reason about.

---

# Preparing for Spring Boot

One of the biggest goals of Version 2 was preparing for enterprise development.

The architecture intentionally mirrors Spring Boot.

| Version 2 | Spring Boot |
|------------|-------------|
| Controller | @RestController |
| Service | @Service |
| Repository | @Repository |
| Validator | Bean Validation / Custom Validator |
| ApplicationContext | Spring IoC Container |
| DomainModule | @Configuration |
| DTOs | Request / Response Objects |

Because these responsibilities are already understood, Version 3 will focus on learning the framework instead of learning architecture.

---

# What I Learned

Version 2 changed my perspective on software development.

I learned that software architecture is not about adding more layers or more classes.

It is about assigning every responsibility to its correct place.

Once responsibilities become clear, the code naturally becomes easier to read, easier to test, easier to extend, and easier to maintain.

This architecture became the foundation upon which every future backend project will be built.