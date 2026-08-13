# About Version 2

> "Software architecture is not about writing more code.
> It is about assigning the right responsibility to the right place."

---

# Introduction

Version 2 marks one of the biggest turning points in my software engineering journey.

Version 0 taught me how to write Java.

Version 1 taught me how to design objects.

Version 2 taught me how to design software.

This version is not about adding more banking features.

Instead, it focuses on understanding how professional software is organized before introducing enterprise frameworks like Spring Boot.

Rather than directly jumping into Spring Boot annotations such as `@Controller`, `@Service`, or `@Repository`, I wanted to understand why these layers exist and what responsibility each one owns.

My goal was never to build a production-ready banking application.

My goal was to build a strong software engineering foundation that I can confidently apply to every future backend project.

---

# Why Version 2 Exists

After completing Version 1, I realized something important.

Although the application was working correctly, many responsibilities were still tightly connected.

A single feature often handled multiple responsibilities at once.

For example:

- Reading user input
- Validating business rules
- Creating objects
- Updating data
- Displaying output

All these responsibilities existed within the same execution flow.

While this approach is acceptable for learning Java and Object-Oriented Programming, it becomes difficult to maintain as software grows.

Professional software is not built by making one class smarter.

It is built by allowing multiple specialized classes to collaborate together.

That realization became the motivation behind Version 2.

---

# Primary Goal

The primary objective of Version 2 was to understand software engineering principles by designing the project before thinking about implementation.

Instead of asking,

> "How can I write this feature?"

I started asking,

> "Who should own this responsibility?"

That single question changed the way I think about software.

Every architectural decision made in this version was driven by responsibility rather than functionality.

---

# Learning Objectives

Version 2 focuses on understanding:

- Layered Architecture
- Separation of Concerns (SoC)
- SOLID Principles
- Dependency Injection
- Composition Root
- Request / Response DTOs
- Repository Pattern
- Factory Pattern
- Validation Architecture
- Package Design
- Clean Code
- Maintainability
- Extensibility
- Professional Project Structure

The banking system itself is only a medium for learning these concepts.

The real product being built is my understanding of software engineering.

---

# Project Philosophy

This project is intentionally designed as a learning project.

Many architectural decisions were made to maximize learning rather than minimize code.

For example:

- Manual Dependency Injection instead of Spring IoC
- Manual Composition Root instead of automatic bean creation
- Explicit package organization instead of framework conventions
- Console application instead of REST APIs

These decisions allow me to understand the responsibilities that Spring Boot will automate in Version 3.

By implementing these concepts manually first, I can appreciate what the framework is doing behind the scenes rather than simply using annotations without understanding them.

---

# Version Progression

This project is intentionally divided into multiple learning stages.

## Version 0

**Focus:** Core Java

Topics:

- Java Syntax
- Classes
- Objects
- Constructors
- Methods
- Collections
- Basic Console Application

Goal:

Learn how Java programs are built.

---

## Version 1

**Focus:** Object-Oriented Programming

Topics:

- Encapsulation
- Composition
- Aggregation
- Association
- Dependency
- Better Domain Models
- Services
- Repository using HashMap

Goal:

Learn how objects collaborate together.

---

## Version 2

**Focus:** Software Engineering

Topics:

- Layered Architecture
- Service Layer
- Controllers
- DTOs
- Dependency Injection
- Factory
- Repository
- Validators
- Package Responsibilities
- Architectural Decisions

Goal:

Learn how software components collaborate together.

---

## Version 3 (Next)

Version 3 will build upon the architecture created in Version 2.

Instead of redesigning the application again, enterprise technologies will be introduced.

Planned topics include:

- Spring Boot
- Spring MVC
- Spring Security
- PostgreSQL
- Spring Data JPA
- Hibernate
- REST APIs
- JWT Authentication
- Bean Validation

The architecture built in Version 2 is intentionally designed so that it maps naturally to Spring Boot.

Version 3 will focus on replacing manual implementations with framework-supported implementations while preserving the same architectural thinking.

---

# Success Criteria

Version 2 will be considered successful if I can confidently answer the following questions without looking at the code:

- Why does every package exist?
- Why does every class exist?
- Why does every dependency exist?
- Why is each responsibility placed where it is?
- Which SOLID principle influenced each design decision?
- Which design pattern solved each problem?
- How will this architecture evolve naturally into Spring Boot?

If I can answer these questions, then I have not only completed the project but also understood the software architecture behind it.

---

# What I Learned

Version 2 completely changed the way I think about programming.

Previously, I believed writing software meant implementing features.

After completing this version, I realized that writing features is only one part of software engineering.

Designing responsibilities, defining boundaries, reducing coupling, and creating maintainable systems are equally important.

This version became the bridge between learning Java and becoming a software engineer.

It laid the architectural foundation that every future project in my journey will build upon.