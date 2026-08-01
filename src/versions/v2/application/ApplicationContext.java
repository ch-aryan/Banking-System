package versions.v2.application;

import versions.v2.application.module.ConsoleApplication;
import versions.v2.application.module.ConsoleModule;
import versions.v2.application.module.DomainModule;
import versions.v2.application.module.InfrastructureModule;
import versions.v2.application.module.PresentationModule;

/*
=========================================================
Class : ApplicationContext

Layer
Application Layer

Responsibility

Acts as the Composition Root of the application.

Creates every application module.

Wires the complete object graph.

Exposes only the top-level application object.

Design Pattern

Composition Root

Manual Dependency Injection

Version
2.0
=========================================================
*/

public class ApplicationContext {

    // =====================================================
    // Modules
    // =====================================================

    private final InfrastructureModule infrastructureModule;

    private final DomainModule domainModule;

    private final PresentationModule presentationModule;

    private final ConsoleModule consoleModule;

    // =====================================================
    // Application
    // =====================================================

    private final Bootstrap bootstrap;

    private final ConsoleApplication consoleApplication;

    public ApplicationContext() {

        // =====================================================
        // Infrastructure
        // =====================================================

        infrastructureModule =
                new InfrastructureModule();

        // =====================================================
        // Domain
        // =====================================================

        domainModule =
                new DomainModule(
                        infrastructureModule
                );

        // =====================================================
        // Presentation
        // =====================================================

        presentationModule =
                new PresentationModule(
                        domainModule
                );

        // =====================================================
        // Console
        // =====================================================

        consoleModule =
                new ConsoleModule(
                        infrastructureModule,
                        presentationModule
                );

        // =====================================================
        // Bootstrap
        // =====================================================

        bootstrap =
                new Bootstrap(
                        infrastructureModule.getUserRepository()
                );

        // =====================================================
        // Console Application
        // =====================================================

        consoleApplication =
                new ConsoleApplication(
                        bootstrap,
                        consoleModule.getWelcomeScreen(),
                        consoleModule.getMainMenuNavigator()
                );

    }

    // =====================================================
    // Getter
    // =====================================================

    public ConsoleApplication getConsoleApplication() {

        return consoleApplication;

    }

}