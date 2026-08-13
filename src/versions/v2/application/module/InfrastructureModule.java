package versions.v2.application.module;

import versions.v2.presentation.console.io.ConsoleContext;
import versions.v2.presentation.console.io.ConsolePrinter;
import versions.v2.presentation.console.io.ConsoleReader;
import versions.v2.repository.UserRepository;

import java.util.Scanner;

/*
=========================================================
Class : InfrastructureModule

Layer
Application

Responsibility
Creates all shared infrastructure objects
required by the application.

Creates

Scanner

ConsoleReader

ConsolePrinter

ConsoleContext

UserRepository

Design Principle

Single Responsibility Principle

Architectural Role

Infrastructure Module

Version
2.0
=========================================================
*/

    public class  InfrastructureModule {

        // ============================================
        // Shared Console Objects
        // ============================================

        private final Scanner scanner;

        private final ConsoleReader reader;

        private final ConsolePrinter printer;

        private final ConsoleContext consoleContext;

        // ============================================
        // Repository
        // ============================================

        private final UserRepository userRepository;

        public InfrastructureModule() {

            scanner = new Scanner(System.in);

            reader = new ConsoleReader(scanner);

            printer = new ConsolePrinter();

            consoleContext =
                    new ConsoleContext(
                            reader,
                            printer
                    );

            userRepository =
                    new UserRepository();

        }

        // ============================================
        // Getters
        // ============================================

        public ConsoleContext getConsoleContext() {

            return consoleContext;

        }

        public UserRepository getUserRepository() {

            return userRepository;

        }

    }




