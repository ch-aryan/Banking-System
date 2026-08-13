package versions.v2.application.module;

import versions.v2.presentation.console.io.ConsoleContext;
import versions.v2.presentation.console.screen.*;
import versions.v2.presentation.controller.banking.BalanceController;
import versions.v2.presentation.controller.banking.DepositController;
import versions.v2.presentation.controller.banking.TransactionHistoryController;
import versions.v2.presentation.controller.banking.TransferController;
import versions.v2.presentation.controller.banking.WithdrawController;
import versions.v2.presentation.controller.authentication.LoginController;
import versions.v2.presentation.controller.authentication.RegistrationController;
import versions.v2.presentation.console.navigation.BankingNavigator;
import versions.v2.presentation.console.navigation.MainMenuNavigator;

/*
=========================================================
Class : ConsoleModule

Layer
Application

Responsibility

Creates every Console UI component.

Creates

Screens

Navigation Controllers

ConsoleApplication

Collaborates With

InfrastructureModule

PresentationModule

Design Principle

Single Responsibility Principle

Architectural Role

Console Module

Version
2.0
=========================================================
*/

public class ConsoleModule {

    // =====================================================
    // Screens
    // =====================================================
    private final WelcomeScreen welcomeScreen;

    private final RegistrationScreen registrationScreen;

    private final LoginScreen loginScreen;

    private final DepositScreen depositScreen;

    private final WithdrawScreen withdrawScreen;

    private final TransferScreen transferScreen;

    private final BalanceScreen balanceScreen;

    private final TransactionHistoryScreen transactionHistoryScreen;

    private final MainMenuScreen mainMenuScreen;

    private final BankingMenuScreen bankingMenuScreen;

    // =====================================================
    // Navigation Controllers
    // =====================================================

    private final BankingNavigator bankingNavigator;

    private final MainMenuNavigator mainMenuNavigator;

    // =====================================================
    // Console Application
    // =====================================================

//    private final ConsoleApplication consoleApplication;

    public ConsoleModule(
            InfrastructureModule infrastructureModule,
            PresentationModule presentationModule) {

        // =====================================================
        // Shared Console Objects
        // =====================================================

        ConsoleContext consoleContext =
                infrastructureModule.getConsoleContext();

        // =====================================================
        // Controllers
        // =====================================================


        RegistrationController registrationController =
                presentationModule.getRegistrationController();

        LoginController loginController =
                presentationModule.getLoginController();

        DepositController depositController =
                presentationModule.getDepositController();

        WithdrawController withdrawController =
                presentationModule.getWithdrawController();

        TransferController transferController =
                presentationModule.getTransferController();

        BalanceController balanceController =
                presentationModule.getBalanceController();

        TransactionHistoryController transactionHistoryController =
                presentationModule.getTransactionHistoryController();

        // =====================================================
        // Screens
        // =====================================================
        welcomeScreen =
                new WelcomeScreen(consoleContext.getPrinter());

        registrationScreen =
                new RegistrationScreen(
                        consoleContext,
                        registrationController
                );

        loginScreen =
                new LoginScreen(
                        consoleContext,
                        loginController
                );

        depositScreen =
                new DepositScreen(
                        consoleContext,
                        depositController
                );

        withdrawScreen =
                new WithdrawScreen(
                        consoleContext,
                        withdrawController
                );

        transferScreen =
                new TransferScreen(
                        consoleContext,
                        transferController
                );

        balanceScreen =
                new BalanceScreen(
                        consoleContext,
                        balanceController
                );

        transactionHistoryScreen =
                new TransactionHistoryScreen(
                        consoleContext,
                        transactionHistoryController
                );
        mainMenuScreen =
                new MainMenuScreen(
                        consoleContext
                );

        bankingMenuScreen =
                new BankingMenuScreen(
                        consoleContext
                );

        // =====================================================
        // Navigation Controllers
        // =====================================================

        bankingNavigator =
                new BankingNavigator(

                        bankingMenuScreen,
                        depositScreen,
                        withdrawScreen,
                        transferScreen,
                        balanceScreen,
                        transactionHistoryScreen
                );

        mainMenuNavigator =
                new MainMenuNavigator(
                        mainMenuScreen,
                        registrationScreen,
                        loginScreen,
                        bankingNavigator
                );

        // =====================================================
        // Console Application
        // =====================================================

//        consoleApplication =
//                new ConsoleApplication(
//                        mainMenuNavigator
//                );
    }

    // =====================================================
    // Getter
    public WelcomeScreen getWelcomeScreen() {

        return welcomeScreen;

    }

    public MainMenuNavigator getMainMenuNavigator() {

        return mainMenuNavigator;

    }
    // =====================================================

//    public ConsoleApplication getConsoleApplication() {
//        return consoleApplication;
//    }

}
