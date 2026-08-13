# Version 0 — Future Improvements

Version 0 provides a solid foundation, but several improvements have already been identified.

---

## Improve versions.v0.Main.java

Problem

versions.v0.Main coordinates too many responsibilities.

Future Solution

Introduce an application controller or better separation of responsibilities.

---

## Remove Static Fields from LoginResult

Problem

LoginResult currently stores state using static fields.

Future Solution

Convert it into a normal object where each login has its own independent versions.v0.result.

---

## Introduce Repository Layer

Problem

Services directly access the ArrayList of users.

Future Solution

Move data management into a dedicated repository.

---

## Transaction History

Currently deposits and withdrawals update the balance only.

Future versions will introduce Transaction objects.

---

## Better Exception Handling

versions.v0.Validation currently returns simple messages.

Future versions will introduce custom exceptions.

---

## Persistent Storage

Currently all data exists only in memory.

Future versions will store information in a database.