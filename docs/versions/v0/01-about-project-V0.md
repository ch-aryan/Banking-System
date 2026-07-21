# Project Purpose

## Why did this project start?

The idea behind this project was simple.

I wanted to build a small console-based banking system using Core Java.

At first, the goal was not to create a production-ready banking application.

The goal was to understand how Java programs are organized as they grow.

Most beginner Java examples are very small, while many real-world projects already contain hundreds of files,
packages, frameworks, and architectural patterns. 

That makes it difficult to understand how a simple Java program gradually evolves into a larger software system.
This project was created to bridge that gap.

Instead of starting with enterprise frameworks, we begin with Core Java and allow the software to grow naturally.

---

## Initial Project Plan

The original idea was to build a simple banking application that could perform everyday banking operations through the console.

```
Welcome

1. Create Account
2. Login
3. Deposit
4. Withdraw
5. Transfer Money
6. Check Balance
7. Exit
```

The planned features included:

- Create Account
- User Login
- Deposit Money
- Withdraw Money
- Transfer Money
- Transaction History
- Account versions.v0.Validation

At this stage, the focus was not on building every feature immediately.

The focus was on building a strong foundation that could support future improvements.

---

## What were we trying to learn?

Version 0 focuses on understanding the fundamentals of object-oriented programming by solving a real business problem.

Instead of creating classes only for practice, every class represents a responsibility within the banking system.

During this version, the primary learning objectives were:

- Classes and Objects
- Constructors
- Methods
- Encapsulation
- Object Composition
- Collections
- Input versions.v0.Validation
- Basic Package Organization
- Separation of Responsibilities

More importantly, the project introduces the habit of asking:

> Why does this class exist?

instead of simply asking

> How do I write this class?

---

## What changed during development?

As the project started growing, new responsibilities appeared.

Instead of keeping everything inside a few Java files, we began separating responsibilities into packages such as:

- versions.v0.Model
- Service
- versions.v0.Validation
- Result
- versions.v0.Session
- Utility

This happened naturally while solving real problems.

The project became more than a console banking application.

It became a learning platform for understanding software design.

---

## What does Version 0 achieve?

By the end of Version 0, the application provides a working foundation for future development.

It includes:

- User Registration
- Login System
- Bank Account Creation
- Deposit
- Withdrawal
- versions.v0.Session Management
- versions.v0.Validation Rules
- Basic Package Structure

Although the application is still simple, it establishes the architecture that future versions will improve through refactoring and better software design.

Version 0 is not the final destination.

It is the foundation on which every future version will be built.

---

## Next Step
In the next document, we'll explore the system architecture of Version 0 and understand how the different components of the banking system communicate with each other.