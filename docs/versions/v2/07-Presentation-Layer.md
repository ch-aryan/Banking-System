# Presentation Layer

> "The Presentation Layer is the face of the application.
> It communicates with the user, but it never owns the business."

---

# Introduction

The Presentation Layer is responsible for every interaction between the user and the application.

Whether the user registers, logs in, deposits money, transfers funds, or checks the account balance, every interaction begins here.

One of the biggest architectural improvements introduced in Version 2 was separating user interaction from business logic.

Instead of allowing the console to execute banking operations directly, the Presentation Layer became responsible only for communication.

This separation prepares the project for future user interfaces such as Web Applications, REST APIs, Desktop Applications, or Mobile Applications without changing the business logic.

---

# Why Do We Need a Presentation Layer?

In small console applications, it is common to place everything inside one class.

For example:

- Display menu
- Read input
- Validate data
- Deposit money
- Update account
- Print success message

Although this approach works for small projects, it quickly becomes difficult to maintain as software grows.

Version 2 solves this problem by introducing a dedicated Presentation Layer.

Its responsibility is simple:

> Communicate with the user.

Nothing more.

---

# Presentation Layer Structure

```text
console
│
├── io
│     ├── ConsoleContext
│     ├── ConsoleReader
│     └── ConsolePrinter
│
├── navigation
│     ├── MainMenu
│     ├── MainMenuNavigator
│     ├── BankingMenu
│     └── BankingNavigator
│
├── screen
│     ├── WelcomeScreen
│     ├── RegistrationScreen
│     ├── LoginScreen
│     ├── DepositScreen
│     ├── WithdrawScreen
│     ├── TransferScreen
│     ├── TransactionHistoryScreen
│     ├── BalanceScreen
│     └── BankingMenuScreen
│
└── util
      └── RetryHelper

controller
│
├── authentication
│     ├── RegistrationController
│     └── LoginController
│
└── banking
      ├── DepositController
      ├── WithdrawController
      ├── TransferController
      ├── TransactionHistoryController
      └── BalanceController
```

The Presentation Layer is divided into two major parts:

- Console Package
- Controller Package

---

# Responsibility of the Console Package

The Console Package owns the complete Console User Interface.

It is responsible for:

- Displaying menus
- Reading user input
- Showing responses
- Navigation between screens
- Formatting console output

It is **not responsible** for:

- Banking rules
- Validation logic
- Updating data
- Repository operations
- Object creation

The Console should never make business decisions.

It simply communicates with the user.

---

# Console IO

The `io` package separates input and output responsibilities.

## ConsoleReader

Responsible for reading user input.

Examples:

- Username
- Password
- Amount
- PIN
- Date of Birth

It knows how to read.

It does not know what those values mean.

---

## ConsolePrinter

Responsible for displaying information.

Examples:

- Welcome messages
- Success messages
- Error messages
- Menus
- Formatting

Methods such as `separator()` exist only to improve the user experience.

Formatting belongs here rather than being duplicated across multiple screens.

---

## ConsoleContext

Acts as the shared console environment.

Instead of every screen creating its own `Scanner`, a single shared context is used throughout the application.

This avoids unnecessary object creation and centralizes console resources.

---

# Navigation

Navigation controls how users move through the application.

Examples:

```
Welcome

↓

Main Menu

↓

Login

↓

Banking Menu

↓

Deposit
```

The Navigator decides **where** the application should go next.

It does not decide **how** deposits work.

Navigation is therefore considered a Presentation responsibility rather than a business responsibility.

---

# Screens

Screens represent individual user interactions.

Each screen owns exactly one user experience.

Examples:

- RegistrationScreen
- LoginScreen
- DepositScreen
- TransferScreen

Responsibilities of a Screen:

- Display prompts
- Read user input
- Build Request DTOs
- Call the appropriate Controller
- Display the Response

Screens never perform business logic.

A screen should never directly modify a BankAccount or Repository.

---

# Controllers

Controllers form the boundary between the Presentation Layer and the Domain Layer.

A controller receives a Request DTO from a Screen and delegates the work to a Service.

After receiving the Response DTO, it returns the result back to the Screen.

Controllers intentionally remain thin.

They coordinate communication but never own business rules.

Example:

```text
RegistrationScreen
        │
        ▼
RegistrationController
        │
        ▼
RegistrationService
```

The controller acts as a bridge.

---

# Why Separate Screens and Controllers?

This was one of the biggest design decisions in Version 2.

Without Controllers, every Screen would directly call Services.

```text
Screen
    │
    ▼
Service
```

At first this appears simple.

However, it tightly couples the user interface with the business layer.

Instead, Controllers provide a stable boundary.

Now the Screen communicates only with the Controller.

If the Presentation Layer changes in the future—for example from Console to REST API—the business layer remains unchanged.

---

# Complete Presentation Flow

Every feature follows the same execution flow.

```text
User
 │
 ▼
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
 │
 ▼
User
```

This consistent flow makes every use case predictable and easier to understand.

---

# Architectural Decisions

Several important decisions were made while designing the Presentation Layer.

- Every feature owns its own Screen.
- Every use case owns its own Controller.
- Navigation belongs to the Console package.
- Screens communicate only with Controllers.
- Controllers communicate only with Services.
- Input and Output are separated using ConsoleReader and ConsolePrinter.
- Business logic never enters the Presentation Layer.

These decisions keep the Presentation Layer independent of business rules.

---

# Preparing for Spring Boot

The Presentation Layer is intentionally designed to evolve naturally into a web application.

| Version 2 | Spring Boot |
|------------|-------------|
| Screen | Web Page / React Component / API Client |
| Controller | `@RestController` |
| Request DTO | `@RequestBody` |
| Response DTO | JSON Response |
| Console Navigation | HTTP Routing / React Router |

The business layer remains unchanged.

Only the Presentation Layer changes.

This is one of the biggest advantages of layered architecture.

---

# What I Learned

Version 2 taught me that user interaction and business logic are two completely different responsibilities.

The Presentation Layer should focus only on communicating with the user.

It should never make banking decisions or modify application data.

By introducing Screens, Controllers, Navigation, and Console IO as separate responsibilities, I learned how professional applications isolate the user interface from the business layer.

This design allows the same business logic to be reused by different presentation technologies in the future, making the software easier to maintain and easier to evolve.