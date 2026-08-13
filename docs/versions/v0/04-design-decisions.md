# Version 0 — Design Decisions

## Decision 1 

### Why create a User class?

Problem

A person in the banking system has multiple pieces of related information, such as name, username, password, user ID, and bank account.

Keeping these values in separate variables would make the program difficult to maintain.

Decision

Create a User class that groups all user-related information into one object.

Benefit

Represents a real customer.
Makes it easy to pass user information between classes.
Improves readability and maintainability.

---

### Decision 2 — Why create a BankAccount class?

Problem

A user's personal information and banking information represent different business concepts.

Mixing account details with login details would violate separation of responsibilities.

Decision

Create a separate BankAccount class.

Benefit

Models the real world more accurately.
Keeps banking logic separate from user identity.
Makes future banking features easier to add.

---

### Decision 3 — Why does User own a BankAccount?
Problem

A bank account should not exist independently in Version 0.

Every bank account belongs to exactly one user.

Decision

Store a BankAccount object inside the User object.

Benefit

Demonstrates object composition.
Represents the business relationship naturally.
Accessing a user's account becomes simple.
     users owns a bankAccount

---

### Decision 4 — Why use an ArrayList?


Problem

The application needs a place to store all registered users while the program is running.

Since Version 0 does not use a database, user information must be stored in memory.

Decision

Use an ArrayList<User>.

Benefit

Easy for beginners to understand.
Allows adding users dynamically.
Supports iteration for login and duplicate username checks.
Provides a simple foundation before introducing repositories or databases.
Why not a Database?

Version 0 focuses on understanding Core Java.

Introducing a database at this stage would add unnecessary complexity and hide the object-oriented concepts we are trying to learn.

Future Improvement

As the number of users grows, searching an ArrayList becomes slower (O(n)).

Future versions will replace it with a dedicated UserRepository, which can later be backed by a database.

---

### Decision 5 — Why pass ArrayList to UserRegistration and UserLogin?

This is an excellent question.

Problem

Both UserRegistration and UserLogin need access to the list of registered users.

Registration checks for duplicate usernames.
Login searches for the requested user.
Decision

Pass the ArrayList<User> to these services.

Benefit

Services work with the same data source.
Avoids creating duplicate user lists.
Demonstrates dependency between objects.
Future Improvement

In Version 1, these services will receive a UserRepository instead of an ArrayList.

---

### Decision 6 — Why pass BankAccount to the User constructor?
Problem

A User should always have an associated bank account.

Creating the account separately could versions.v0.result in incomplete user objects.

Decision

Create the BankAccount first and pass it into the User constructor.

Benefit

Every user is created with a valid bank account.
Prevents partially initialized objects.
Demonstrates constructor-based composition.
BankAccount

↓

User Constructor

↓

User

---

### Decision 7 — Why pass User to DepositService and WithdrawService?
Problem

Money belongs to the user's account.

The deposit versions.v0.service should not know how users are stored.

It only needs to know which user is performing the transaction.

Decision

Pass the User object.

The versions.v0.service retrieves the user's BankAccount internally.

Benefit

The versions.v0.service receives only the required object.
Business logic stays inside the versions.v0.service.
Demonstrates object navigation.
User

↓

getBankAccount()

↓

Update Balance

---

### Decision 8 — Why create Result objects?
Problem

Returning only true or false does not explain why an operation succeeded or failed.

Decision

Create dedicated versions.v0.result classes.

Examples:

UserResult
LoginResult
DepositResult
WithdrawResult
Benefit

Operations return:

Success status
Message
Related object
Additional information

instead of only a boolean value.

---

### Decision 9 — Why create a versions.v0.Session class?
Problem

The application needs to remember which user is currently logged in.

Without a session object, the logged-in user would need to be passed between many methods.

Decision

Create a dedicated versions.v0.Session class.

Benefit

Centralizes login state.
Separates authentication from session management.
Mimics how real applications track logged-in users.
Decision 10 — Why separate business logic into Services?
Problem

If every operation were implemented inside versions.v0.Main, the class would quickly become large and difficult to maintain.

Decision

Move business operations into dedicated versions.v0.service classes.

Benefit
Each versions.v0.service has one primary responsibility.
Business rules stay separate from user interaction.
Makes future refactoring much easier.

---

### Decision 11 — Why create versions.v0.Validation classes?
Problem

versions.v0.Validation logic would otherwise be duplicated across multiple services.

Decision

Move validation into reusable utility classes.

Benefit

versions.v0.Validation is written once.
Business logic remains clean.
Rules can be reused throughout the application.

---

### Decision 12 — Why create an IdGenerator?
Problem

Every new user and bank account requires a unique identifier.

Generating IDs inside the registration versions.v0.service would mix two responsibilities.

Decision

Create a dedicated IdGenerator.

Benefit

Keeps registration focused on registration.
Centralizes ID generation.
Makes future changes to the ID strategy easier.