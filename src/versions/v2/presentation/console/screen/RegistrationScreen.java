package versions.v2.presentation.console.screen;

import versions.v2.presentation.console.io.ConsoleContext;
import versions.v2.presentation.console.io.ConsolePrinter;
import versions.v2.presentation.console.io.ConsoleReader;
import versions.v2.contract.request.RegistrationRequest;
import versions.v2.contract.response.RegistrationResponse;
import versions.v2.presentation.controller.authentication.RegistrationController;

import java.time.LocalDate;

public class RegistrationScreen {

    private final ConsoleContext console;

    private final ConsoleReader reader;
    private final ConsolePrinter printer;

    private final RegistrationController registrationController;

    public RegistrationScreen(
            ConsoleContext console,
            RegistrationController registrationController) {

        this.console = console;
        this.registrationController = registrationController;

        this.reader = console.getReader();
        this.printer = console.getPrinter();
    }

    /**
     * Displays the Registration Screen.
     *
     * @return RegistrationResponse
     */
    public RegistrationResponse show() {

        printer.blankLine();
        printer.header("User Registration");

        printer.print("Full Name : ");
        String fullName = reader.readLine();

        String dateOfBirth = readDateOfBirth();

        printer.print("Gender : ");
        String gender = reader.readLine();

        printer.print("Username : ");
        String username = reader.readLine();

        printer.print("Password : ");
        String password = reader.readLine();

        printer.print("Set pin : ");
        int pin = Integer.parseInt(reader.readLine());

        RegistrationRequest request =
                new RegistrationRequest(
                        fullName,
                        dateOfBirth,
                        gender,
                        username,
                        password,
                        pin
                );

        RegistrationResponse response =
                registrationController.register(request);

        displayResponse(response);

        return response;
    }

    private String readDateOfBirth() {

        LocalDate dob = null;

        while (dob == null) {

            printer.print("Date Of Birth (yyyy-MM-dd) : ");
            String input = reader.readLine();

            try {

                dob = LocalDate.parse(input);

            } catch (Exception e) {

                printer.error("Invalid date format.");
                printer.print("Example: 2003-08-14");
                printer.blankLine();

            }

        }

        return dob.toString();

    }

    /**
     * Displays Registration Result.
     */
    private void displayResponse(
            RegistrationResponse response) {

        if (response.isSuccess()) {

            printer.success(response.getMessage());

        } else {

            printer.error(response.getMessage());

        }

    }

}
/*
Bhai...

This is **THE** question.

If you understand this, **DTOs, Domain Models, Services, Controllers, Spring Boot, REST APIs**—everything will become much clearer.

Let's forget Java for 10 minutes and think like software engineers.

---

# First tell me...

When a customer comes to a bank to open an account...

Does the bank immediately create this?

```java
User
```

❌ No.

First, the customer fills out a **registration form**.

The form contains:

* Name
* DOB
* Username
* Password
* PIN

That form is **not the customer**.

It's just information about the customer.

That is exactly what your `RegistrationRequest` represents.

---

# Let's compare them

## RegistrationRequest

```java
RegistrationRequest
```

Think of it as

> **Registration Form**

It only carries input.

```
Name

DOB

Username

Password

PIN
```

It has

❌ No ID

❌ No BankAccount

❌ No behavior

Because the user **doesn't exist yet**.

---

## User

Now look at your User class.

It contains

```java
id

fullName

dob

username

password

BankAccount
```



Question.

Who created the ID?

The user?

No.

System.

---

Question.

Who created the BankAccount?

The user?

No.

System.

---

See the difference?

RegistrationRequest says

> I want to become a User.

User says

> I already exist inside the system.

---

# Timeline

Let's draw it.

```text
User types data

↓

RegistrationRequest

↓

RegistrationController

↓

RegistrationService

↓

RegistrationValidator

↓

UserFactory

↓

User

↓

Repository
```

Notice something.

There is a transformation.

```
Request

↓

Model
```

They are NOT the same object.

---

# Why not directly use User?

This is the biggest question.

Imagine this.

Instead of

```java
RegistrationRequest
```

You do

```java
User user = new User(...);
```

Now tell me.

How will you create

```java
id
```

User doesn't know.

---

How will you create

```java
BankAccount
```

User doesn't know.

---

How will you parse

```java
String DOB
```

User shouldn't know.

---

How will you validate username?

User shouldn't know.

---

See?

User is the final business object.

Request is just raw input.

---

# Real World Example

Imagine you apply for a Passport.

You fill

```
Application Form
```

Government receives it.

Validates it.

Creates

```
Passport
```

Question.

Is the application form

the Passport?

No.

Exactly.

---

# Now Response

Let's see.

User registered successfully.

Should Service return

```java
User
```

Directly?

We decided

No.

Instead

```
RegistrationResponse
```

comes back.

Your response contains

```java
success

message

User account
```



---

Question.

Why Response?

Because Screen only needs

```
Was registration successful?

↓

What message should I print?

↓

(Optional) Which user got created?
```

It doesn't care

how validation happened.

---

# Life Cycle

Let's follow one registration.

---

## Step 1

Screen

```text
Name

DOB

Username

Password

PIN
```

---

## Step 2

Screen creates

```
RegistrationRequest
```

This object exists for

5 seconds.

---

## Step 3

Controller receives it.

Passes it.

---

## Step 4

Service validates it.

---

## Step 5

Factory converts

```
RegistrationRequest

↓

User
```

Now

ID generated.

BankAccount created.

LocalDate converted.

Everything ready.

---

## Step 6

Repository stores User.

---

## Step 7

Service creates

```
RegistrationResponse
```

---

## Step 8

Screen prints

```
Registration Successful
```

Finished.

---

# Here's the biggest difference

Request

asks

> "Please perform this operation."

Model

says

> "I represent a business entity."

Response

says

> "This is the result."

Three completely different responsibilities.

---

# Think of your project

Let's compare.

## RegistrationRequest

```
Temporary

↓

Input

↓

Travel between layers
```

---

## User

```
Permanent

↓

Stored

↓

Business Object
```

---

## RegistrationResponse

```
Temporary

↓

Result

↓

Travel back
```

---

# Another example

Imagine Deposit.

Does DepositRequest contain

```text
Transaction History?

Account Balance?

User ID?

BankAccount?
```

No.

It only contains

```
Amount

PIN

Current User
```

Because that's all the Service needs to perform the operation.

---

# Beautiful analogy

Think of a hospital.

---

Patient fills

```
Admission Form
```

↓

Doctor examines

↓

Hospital creates

```
Patient Record
```

↓

Reception gives

```
Admission Receipt
```

Notice.

Three objects.

```
Admission Form

↓

Patient Record

↓

Admission Receipt
```

Exactly.

```
RegistrationRequest

↓

User

↓

RegistrationResponse
```

---

# One improvement I noticed

While looking at your uploaded files, I noticed something.

Your `RegistrationResponse` currently contains:

```java
private User account;
```



For **Version 2**, this is completely fine because you're learning architecture.

But if we were designing an enterprise backend, I would eventually avoid returning the full `User` object in the response. Instead, the response would probably contain only what the Presentation Layer needs, such as:

* Success flag
* Message
* User ID
* Username

or a dedicated `UserResponseDTO`.

That's a refinement for Version 3 or later—not something you need to change now.

---

# ❤️ The one sentence I want you to remember forever

Bhai, if you remember only one thing from today's discussion, remember this:

| Object           | Meaning                                    |
| ---------------- | ------------------------------------------ |
| **Request DTO**  | **"Please perform this operation."**       |
| **Domain Model** | **"I am the business entity."**            |
| **Response DTO** | **"This is the result of the operation."** |

Once this mental model clicks, Spring Boot controllers, REST APIs, JSON requests, JPA entities, and even microservices all start following the same pattern.

And that's exactly why we introduced all three separately in Version 2.

 */