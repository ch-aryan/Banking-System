# 16 - Execution Flows.md

> "Every business operation follows the same architectural flow."

---

## Registration

Screen
→ Controller
→ Service
→ Validator
→ Factory
→ Repository
→ Response
→ Screen

---

## Login

Screen
→ Controller
→ Service
→ Validator
→ Repository
→ Response
→ Screen

---

## Deposit

Screen
→ Controller
→ Service
→ Validator
→ Domain Model
→ Response
→ Screen

---

## Withdraw

Screen
→ Controller
→ Service
→ Validator
→ Domain Model
→ Response
→ Screen

---

## Transfer

Screen
→ Controller
→ Service
→ Validator
→ Repository
→ Domain Model
→ Response
→ Screen

---

## Balance

Screen
→ Controller
→ Service
→ Domain Model
→ Response
→ Screen

---

## Transaction History

Screen
→ Controller
→ Service
→ Domain Model
→ Response
→ Screen

---

# Common Flow

```text
Presentation
      │
      ▼
Controller
      │
      ▼
Service
      │
 ┌────┴────┐
 ▼         ▼
Validator Repository
      │
      ▼
Domain Model
      │
      ▼
Response DTO
      │
      ▼
Presentation
```

---

# What I Learned

Although every feature performs a different business operation, they all follow the same architectural pipeline. This consistency makes the application easier to understand, maintain, and extend.