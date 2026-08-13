# Repository Layer

> "The Repository is responsible for storing and retrieving data, not making business decisions."

---

# Purpose

The Repository Layer abstracts data storage from the business logic.

Services never know where or how data is stored.

They simply ask the Repository to save, retrieve, or search data.

---

# Repository Structure

```text
repository
└── UserRepository
```

Version 2 uses an in-memory repository to simulate persistent storage.

This keeps the focus on software architecture rather than database technologies.

---

# Responsibilities

The Repository is responsible for:

- Storing users
- Retrieving users
- Searching users
- Verifying credentials

The Repository is **not responsible** for:

- Business validation
- Banking rules
- User interaction
- Workflow orchestration

---

# Design Decisions

- Business logic never accesses collections directly.
- Services communicate only with the Repository.
- Storage implementation remains hidden from the Domain Layer.
- The Repository can later be replaced without affecting Services.

---

# Why Is Repository a Separate Layer?

Separating persistence from business logic reduces coupling.

If the storage technology changes in the future, only the Repository changes.

The Services remain exactly the same.

---

# Spring Boot Mapping

| Version 2 | Spring Boot |
|------------|-------------|
| UserRepository | `JpaRepository<User, Long>` |
| HashMap Storage | PostgreSQL Database |

---

# What I Learned

I learned that storing data is a technical responsibility, not a business responsibility.

By introducing a Repository Layer, I separated persistence from business logic, making the architecture easier to maintain and ready for Spring Data JPA.