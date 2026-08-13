# Package Structure

> "Packages are not folders.
> Packages represent responsibilities."

---

# Introduction

Version 2 introduces a responsibility-driven package structure.

Instead of grouping classes randomly, every package owns one part of the application.

This makes the project easier to understand, maintain and extend.

Each package exists for a specific reason.

---

# Package Overview

```

versions.v2

│
├── application
├── console
├── contract
├── controller
├── domain
├── repository
└── utility

```

---

# Package Responsibilities

| Package | Responsibility |
|----------|----------------|
| application | Starts the application and builds the object graph. |
| console | Owns the complete Console User Interface. |
| contract | Defines Request and Response DTOs. |
| controller | Coordinates communication between the Presentation Layer and the Domain Layer. |
| domain | Contains business logic and business models. |
| repository | Manages persistence of application data. |
| utility | Contains reusable technical helper classes. |

---

# Dependency Direction

```

Console
↓

Controller
↓

Service

↙      ↘

Validator Repository

↓

Domain Model

```

Each layer communicates only with the layer directly below it.

This keeps responsibilities isolated and reduces coupling.

---

# Package Breakdown

## application

Responsible for bootstrapping the application.

Contains:

- Application
- ApplicationContext
- Bootstrap
- Modules

This package acts as the Composition Root of the application.

---

## console

Responsible for every interaction with the user.

Sub-packages:

- io
- navigation
- screen
- util

Responsibilities:

- Read user input
- Display output
- Navigate between screens

No business logic belongs here.

---

## controller

Responsible for use-case coordination.

Controllers receive requests from Screens and delegate them to Services.

Controllers remain intentionally thin.

---

## contract

Contains only communication objects.

### request

Input sent from Presentation to Domain.

### response

Output returned from Domain to Presentation.

These classes carry data only.

---

## domain

Represents the business itself.

Contains:

- Models
- Services
- Validators
- Validation Rules
- Factory

This is the heart of the application.

---

## repository

Responsible for storing and retrieving Users.

The Domain Layer never knows how storage is implemented.

---

## utility

Contains reusable technical helpers.

Example:

- IdGenerator

These classes are independent of business logic.

---

# What I Learned

A package is more than a folder.

A package defines ownership.

Every package exists because it owns one clear responsibility.

Understanding package responsibilities helped me understand how professional software systems are organized.