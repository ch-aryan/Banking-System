package versions.v2;

import versions.v2.application.Application;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
/*
File:
Application.java

Purpose:
Application entry point.

Responsibility:
Starts the application only.

Why it exists:
The JVM needs one class containing main().

Used by:
JVM

Depends on:
ApplicationContext

Design Principle:
Single Responsibility Principle

Design Pattern:
Composition Root entry (through ApplicationContext).

Could it be improved?
Yes / No
Reason:
...
 */