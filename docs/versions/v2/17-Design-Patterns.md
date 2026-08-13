# 14 - Design Decisions & Patterns.md

> "Good architecture comes from making intentional design decisions."

---

# Design Decisions

- Layered Architecture to separate responsibilities.
- One Service per business use case.
- Controllers remain thin.
- Services orchestrate workflows.
- Validation separated from Services.
- Object creation delegated to UserFactory.
- Repository abstracts data storage.
- Request and Response DTOs separate Presentation from Domain.
- Constructor Injection used throughout the project.
- ApplicationContext acts as the Composition Root.

---

# Design Patterns Used

| Pattern | Where Used |
|----------|------------|
| Layered Architecture | Entire project |
| Composition Root | ApplicationContext |
| Dependency Injection | Constructor Injection |
| Factory Pattern | UserFactory |
| Repository Pattern | UserRepository |
| DTO Pattern | Request / Response classes |
| Service Layer Pattern | All Services |
| Validator Pattern | Validators |
| Context Object | ConsoleContext |

---

# What I Learned

This project helped me understand that design patterns are practical solutions to recurring software problems. They are not added for complexity but to improve maintainability, readability, and scalability.