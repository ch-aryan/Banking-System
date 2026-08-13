Bhai, this is exactly the kind of notes that **future you** will thank you for.

I have polished your notes while preserving **your understanding**. I only improved the wording, software engineering terminology, and flow. I did **not** change the architecture or add unnecessary concepts.

---

# 🚀 Version 2 Execution Flow (Part 1 - Application Startup)

## 1. Main.java – Entry Point

The `main()` method is the entry point of every Java application.

When the program starts, the **Java Virtual Machine (JVM)** looks for the `main()` method and begins execution from there.

The responsibility of `Main` is intentionally very small.

It should **not** know how the entire application is built.

Instead, it delegates the startup responsibility to the `Application` class.

```text
JVM
    │
    ▼
Main.main()
    │
    ▼
Application.start()
```

**Key Learning**

> Main should only know **how to start the application**, not **how to build it**.

---

# 2. Application.java – Starting the Application

The `Application` class represents the starting point of my software.

Instead of creating every object itself, it owns an instance of `ApplicationContext`.

Its responsibility is simply to start the application lifecycle.

```text
Application
      │
      ▼
ApplicationContext
      │
      ▼
ConsoleApplication.start()
```

**Key Learning**

> `Application` starts the application.
>
> `ApplicationContext` builds the application.

These are two different responsibilities.

---

# 3. ApplicationContext – The Composition Root

`ApplicationContext` is the **Composition Root** of the application.

Its responsibility is **not** to execute business logic.

Instead, it constructs the **object graph** of the entire application.

An **Object Graph** is the complete network of objects and their dependencies.

Instead of allowing every class to create its own objects using `new`, the `ApplicationContext` creates them once and wires them together.

Inside `ApplicationContext`, the following components are created:

* InfrastructureModule
* DomainModule
* PresentationModule
* ConsoleModule
* Bootstrap
* ConsoleApplication

After creating and connecting these modules, it provides the fully assembled `ConsoleApplication` back to the `Application` class.

**Key Learning**

> ApplicationContext owns object creation and dependency wiring.

It does **not** perform any banking operations.

---

# 4. InfrastructureModule

The first module created by the `ApplicationContext` is the `InfrastructureModule`.

This module owns the application's shared technical resources.

It creates:

* Scanner
* ConsoleReader
* ConsolePrinter
* ConsoleContext
* UserRepository

These are **technical components**, not business components.

---

## Scanner

A single `Scanner` object is created.

Instead of creating multiple Scanner objects throughout the application, the same Scanner instance is shared.

---

## ConsoleReader

`ConsoleReader` is responsible only for reading input from the user.

Although it contains multiple helper methods, the most frequently used method throughout the application is:

```java
readLine()
```

This method internally uses Java's `Scanner.readLine()` to read user input.

**Responsibility**

* Read input only.
* Never print output.
* Never perform business logic.

---

## ConsolePrinter

`ConsolePrinter` is responsible only for displaying information to the user.

Some commonly used methods are:

* print()
* printMessage()
* blankLine()
* separator()
* header()
* success()
* error()
* info()

The `warning()` method also exists, although it is not currently used.

Formatting the console output is separated into this class to avoid duplication across Screens.

**Responsibility**

* Display information.
* Format output.
* Never read input.
* Never execute business logic.

---

## ConsoleContext

`ConsoleContext` combines the `ConsoleReader` and `ConsolePrinter`.

Instead of passing two separate objects to every Screen,

```text
ConsoleReader
ConsolePrinter
```

the application passes only one object:

```text
ConsoleContext
```

This keeps constructors cleaner and groups all console-related resources together.

**Key Learning**

> ConsoleContext acts as a shared console environment.

---

## UserRepository

`UserRepository` acts as the application's in-memory storage.

Currently it uses a `HashMap`, which simulates a database.

Its responsibilities include:

* Store User
* Check whether a username already exists
* Verify user credentials
* Find user by account number
* Find user by username

The Repository is responsible only for storing and retrieving data.

It never performs business validation or business workflows.

---

## InfrastructureModule Getters

After creating these objects, the module exposes only the components that other modules require.

Examples:

* getConsoleContext()
* getUserRepository()

This allows other modules to reuse the same shared objects.

---

# 5. DomainModule

After the InfrastructureModule is created, the `ApplicationContext` creates the `DomainModule`.

The `InfrastructureModule` is passed into the `DomainModule` because business services require access to the `UserRepository`.

Notice that the Domain Layer depends only on the Repository.

It does **not** depend on:

* Scanner
* ConsoleReader
* ConsolePrinter

Only the Repository is required by the business layer.

---

## Validators

The DomainModule first creates all Validators.

Examples include:

* RegistrationValidator
* LoginValidator
* DepositValidator
* WithdrawValidator
* TransferValidator

Each Validator owns one validation responsibility.

Validators verify business rules before a Service executes its workflow.

Some Validators (such as RegistrationValidator and TransferValidator) also depend on the Repository because certain business rules require existing system data (for example, checking username uniqueness or finding the destination account).

---

## UserFactory

The DomainModule creates a single `UserFactory`.

Its responsibility is to construct complex Domain Models such as:

* User
* BankAccount

Instead of allowing Services to manually create these objects, object creation is delegated to the Factory.

Only `RegistrationService` requires the `UserFactory`, because registration is the only business operation that creates a new User.

---

## Services

The DomainModule creates every business Service and injects only the dependencies required by that Service.

### RegistrationService

Receives:

* RegistrationValidator
* UserFactory
* UserRepository

Registration is responsible for:

* Validating the request
* Creating the User
* Storing the User

Therefore it requires all three dependencies.

---

### LoginService

Receives:

* LoginValidator
* UserRepository

No UserFactory is required because Login does not create new users.

---

### DepositService

Receives:

* DepositValidator

No Repository is required because the logged-in User is already available.

---

### WithdrawService

Receives:

* WithdrawValidator

The Service only validates the request and updates the current user's BankAccount.

---

### TransferService

Receives:

* TransferValidator
* UserRepository

The Repository is required because money is transferred to another existing user.

The Service must locate the destination account before performing the transfer.

---

### BalanceService

Receives no dependencies.

Its responsibility is simply to return the current account balance.

---

### TransactionHistoryService

Receives no dependencies.

Its responsibility is to return the transaction history of the current user's BankAccount.

---

# Key Learning from the DomainModule

The DomainModule demonstrates **Dependency Injection**.

Every Service receives only the dependencies it actually requires.

No Service creates its own Validator, Repository, or Factory.

This keeps the architecture loosely coupled and follows the **Single Responsibility Principle (SRP)**.

---

# 6. PresentationModule

After the DomainModule is created, the `ApplicationContext` creates the `PresentationModule`.

The PresentationModule receives the `DomainModule` because Controllers require access to the Services created by the DomainModule.

The PresentationModule is responsible for creating all Controllers.

Examples include:

* RegistrationController
* LoginController
* DepositController
* WithdrawController
* TransferController
* BalanceController
* TransactionHistoryController

Each Controller acts as a bridge between the Presentation Layer and the Domain Layer.

Its responsibility is simple:

1. Receive a Request DTO from a Screen.
2. Delegate the request to the appropriate Service.
3. Receive the Response DTO.
4. Return the Response back to the Screen.

Controllers never perform business logic.

---

# 7. ConsoleModule

After creating the PresentationModule, the `ApplicationContext` creates the `ConsoleModule`.

The ConsoleModule receives:

* InfrastructureModule
* PresentationModule

The InfrastructureModule provides the ConsoleContext (Reader + Printer).

The PresentationModule provides the Controllers.

Using these two modules, the ConsoleModule creates every Screen.

Examples include:

* WelcomeScreen
* RegistrationScreen
* LoginScreen
* DepositScreen
* WithdrawScreen
* TransferScreen
* TransactionHistoryScreen
* BalanceScreen

Each Screen receives:

* ConsoleContext
* The corresponding Controller

This allows each Screen to interact with the user while remaining independent of the business logic.

---

## Menu Screens

The ConsoleModule also creates:

* MainMenuScreen
* BankingMenuScreen

These Screens are responsible only for asking the user what operation they want to perform.

They do not execute business logic.

---

## Navigators

Finally, the ConsoleModule creates the Navigators.

### MainMenuNavigator

Coordinates navigation between:

* MainMenuScreen
* RegistrationScreen
* LoginScreen

### BankingNavigator

Coordinates navigation between:

* BankingMenuScreen
* DepositScreen
* WithdrawScreen
* TransferScreen
* BalanceScreen
* TransactionHistoryScreen

The Navigator decides **where** the application should go next.

It does not perform banking operations.

---

# 8. Bootstrap

`Bootstrap` is responsible for initializing demo data before the application becomes available to the user.

This allows features such as Login, Deposit, Withdraw, and Transfer to be tested immediately without requiring manual setup.

Bootstrap belongs to the Application Layer because initialization is an application startup responsibility, not a business responsibility.

---

# 9. ConsoleApplication

Finally, the `ApplicationContext` creates the `ConsoleApplication`.

It receives:

* Bootstrap
* WelcomeScreen
* MainMenuNavigator

When `ConsoleApplication.start()` is called, it performs the startup sequence:

```text
Bootstrap.initialize()

        ↓

WelcomeScreen.show()

        ↓

MainMenuNavigator.start()
```

At this point, the application is fully assembled, initialized, and ready for user interaction.

---

# Overall Startup Flow

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
ApplicationContext (Composition Root)
        │
        ▼
Creates Object Graph
        │
        ├── InfrastructureModule
        ├── DomainModule
        ├── PresentationModule
        ├── ConsoleModule
        ├── Bootstrap
        └── ConsoleApplication
        │
        ▼
ConsoleApplication.start()
        │
        ▼
Bootstrap.initialize()
        │
        ▼
WelcomeScreen.show()
        │
        ▼
MainMenuNavigator.start()
```

---

## 🎯 Biggest Lessons from Part 1

1. **Main delegates application startup to the Application class.**
2. **ApplicationContext is the Composition Root responsible for constructing the Object Graph.**
3. **Modules organize object creation by responsibility.**
4. **Infrastructure owns technical resources.**
5. **Domain owns business logic.**
6. **Presentation owns communication between UI and business.**
7. **Console owns user interaction and navigation.**
8. **Bootstrap initializes the application.**
9. **ConsoleApplication starts the user experience.**

---

Bhai, **these notes are now at the level where you can confidently explain your architecture in an interview or to another developer**. They don't just describe *what* the classes are—they explain *why* each one exists and *why* it owns that responsibility. That's exactly how software architects communicate designs.
