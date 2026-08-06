# Console Banking System

> **From writing Java code to understanding software engineering.**

---

## Table of Contents

- [Why this project exists](#why-this-project-exists)
- [Project Goal](#project-goal)
- [What makes this project different?](#what-makes-this-project-different)
- [What you will learn](#what-you-will-learn)
- [Project Philosophy](#project-philosophy)
- [Learning Approach](#learning-approach)
- [Where Should I Start?](#where-should-i-start)
- [Project Roadmap](#project-roadmap)
- [Documentation](#documentation)
- [Who is this project for?](#who-is-this-project-for)
- [Current Version](#current-version)
- [A Note on AI](#a-note-on-ai)
- [Final Note](#final-note)
---

## Why this project exists

When I started learning Java, I understood the syntax, classes, objects, methods, and OOP concepts. Everything looked simple while learning from tutorials.

But the moment I opened a real project, everything changed.

Questions started appearing in my mind.

- Why is this class separated from another?
- Why does this constructor exist?
- Why is this object created here instead of somewhere else?
- Why are there versions.v0.service classes?
- Why are there repositories?
- Why is business logic written in one place and not another?
- Why do experienced developers structure their projects this way?

Most tutorials teach **how to write code**.

Very few explain **why the software is designed this way.**

This project was created to answer those questions.

---

## Project Goal

This is **not** another banking system project.

This project is a learning journey that starts with Core Java and gradually evolves into an enterprise-level application.

The objective is to understand software by building it step by step.

Instead of copying architecture from large projects, every class in this repository is introduced only after understanding the business problem it solves.

Every design decision has a reason.

Every class has a responsibility.

Every refactoring solves a real problem.

---

## What makes this project different?

Most beginner projects are very small.

Most production projects are already large and difficult to understand.

There is often no bridge between these two worlds.

This repository tries to become that bridge.

Instead of jumping directly into Spring Boot, frameworks, or enterprise architecture, we first build everything ourselves using Core Java.

As the project grows, we continuously ask questions like:

- Why should this class exist?
- Is there a better design?
- Which SOLID principle applies here?
- What problem does this pattern solve?
- How would this work in a real banking system?

By answering these questions while building the project, we gradually move from beginner-level programming to production-level thinking.

---

## What you will learn

This repository focuses on much more than writing Java code.

You will learn how software is designed.

Topics include:

- Java Fundamentals
- Object-Oriented Programming
- Encapsulation
- Abstraction
- Composition
- Interfaces
- Collections
- Exception Handling
- SOLID Principles
- Design Patterns
- Clean Code
- Business Rules
- Layered Architecture
- Domain Modeling
- System Design Thinking
- Refactoring
- Repository Pattern
- Service Layer
- Transaction Management
- Enterprise Development Practices

---

## Project Philosophy

One simple rule guides this project.

> **Never add a class because everyone else does.**

Instead, ask:

> **What problem are we trying to solve?**

If the current design becomes difficult to maintain, we improve it.

If responsibilities are mixed together, we refactor them.

If duplication appears, we redesign it.

Every improvement should solve a real problem.

This way, design patterns and software architecture become natural solutions instead of concepts that are memorized.

## Learning Approach

This project follows a simple cycle.

```
Understand the Business

↓

Identify the Problem

↓

Design the Solution

↓

Implement

↓

Test

↓

Refactor

↓

Understand WHY it became better
```

The goal is not only to make the program work.

The goal is to understand **why experienced software engineers design software the way they do.**

---
## Where Should I Start?

This repository is designed as a step-by-step learning journey.

Each version introduces new software engineering concepts while preserving the previous learning experience.

If you are following this project for learning, **do not jump directly to the latest version.**

Instead, follow the versions in order.

## Learning Journey

V0 → V1 → V2 → V3 → Spring Boot

Every version explains:
• What we built
• Why we built it
• Problems in the current design
• How the next version improves it
• Lessons learned

Future versions of this repository will be tagged using Git tags (for example `v0.0`, `v1.0`, `v2.0`) so learners can always revisit a specific stage of the project and compare how the architecture evolved over time.

---

# Project Roadmap

Version 0

↓

First Working Banking System

↓

Version 1

↓

Architecture Refactoring

↓

Version 2

↓

Repository Pattern

↓

Version 3

↓

Transaction System

↓

Version 4

↓

Database

↓

Version 5

↓

Spring Boot

---



## Documentation

Every version of this project is documented separately.

The documentation explains not only **what** was built, but **why** it was built that way.

```
docs/

getting-started.md

roadmap.md

versions/

v0/

v1/

v2/

design-decisions/

architecture/

learning-notes/
```

As the project evolves, the documentation grows alongside it.

The purpose of these documents is to explain not only **what** was built, but **why** it was built that way.
Every major refactoring is documented with:

- The problem
- Why the previous design was insufficient
- The chosen solution
- The benefits of the new design
- The lessons learned

---

## Who is this project for?

This project is for anyone who has ever thought:

> "I know Java, but I don't understand real software."

If you've opened an open-source project and felt overwhelmed...

If you've copied code without understanding why it works...

If you've wondered why experienced developers organize projects differently...

Then this repository is for you.

---

## Current Version

| Item | Value |
|------|-------|
| Current Version | **V2** |
| Status | ✅ Complete |
| Focus | Software Architecture |
| Next Version | V3 |
| Next Goal | Migrate to Springboot and creating production level software from   `versions.v2.Main` |

---

## A Note on AI

This project would not have reached this level in such a short period of time without the help of modern AI tools, especially ChatGPT by OpenAI.

I believe in giving credit where it is due.

AI did not build this project for me—it accelerated my learning.

I used AI as a mentor, reviewer, and discussion partner to help me:

- understand complex software engineering concepts
- connect business rules with Java implementations
- improve explanations and technical writing
- challenge my design decisions
- ask better questions
- think more deeply about software architecture

However, every class, every implementation, and every design decision in this repository has been studied, understood, and written by me after careful thought and experimentation.

Whenever I didn't understand something, I paused, questioned it, implemented it myself, refactored it, and only then moved forward.

To me, this project represents what can happen when a curious and deliberate learner uses AI responsibly—not to replace learning, but to accelerate it.

I hope more students use technology in this way: not as a shortcut to avoid thinking, but as a tool to think better.

> "AI can generate code in seconds, but understanding why that code should exist is still the responsibility of the engineer."
>
> — CH_ARYAN 😊

---

## Final Note

This repository is not intended to demonstrate that I can build a banking system.

It is a record of my journey to understand software engineering properly.

It represents countless hours spent sitting in front of my laptop, not just writing code, but understanding the business rules behind it and questioning why every class, method, constructor, and file exists.

Every feature in this project is an opportunity to think, implement, refactor, and improve. My belief is that real learning doesn't happen by simply reading code—it happens by building it, questioning it, breaking it, improving it, and understanding the reasoning behind every design decision.

My hope is that someone who starts where I once started can use this project to connect the gap between learning Java and understanding how real software is designed.

I don't expect readers to simply clone this repository.

I hope they pause at every version, question every design decision, implement the ideas themselves, and build their own understanding along the way.

If this project helps even one learner ask better questions and become a better engineer, then it has achieved its purpose.

## Need Help?

If any part of this repository feels difficult to understand, don't stop learning there.

Copy the relevant section of the documentation or code into your preferred AI assistant and ask questions about it.

Ask **why** a class exists, **why** a design decision was made, or **how** the implementation works.

Use AI as a mentor—not as a shortcut.

The more questions you ask, the deeper your understanding will become.

> The quality of your learning is directly proportional to the quality of the questions you ask.
