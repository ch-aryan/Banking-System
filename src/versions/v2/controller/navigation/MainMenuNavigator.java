package versions.v2.controller.navigation;

import versions.v2.console.screen.LoginScreen;
import versions.v2.console.screen.MainMenuScreen;
import versions.v2.console.screen.RegistrationScreen;
import versions.v2.contract.response.LoginResponse;

/*
=========================================================
Class : MainMenuNavigator

Layer
Presentation Layer

Responsibility

Controls the application's main navigation.

Displays the Main Menu.

Navigates the user to Registration or Login.

Ends the application when the user selects Exit.

Design Principle

Single Responsibility Principle

Architectural Role

Navigation Controller

Version
2.0
=========================================================
*/

public class MainMenuNavigator {

    private final MainMenuScreen mainMenuScreen;

    private final RegistrationScreen registrationScreen;

    private final LoginScreen loginScreen;

    private final BankingNavigator bankingNavigator;

    public MainMenuNavigator(
            MainMenuScreen mainMenuScreen,
            RegistrationScreen registrationScreen,
            LoginScreen loginScreen,
            BankingNavigator bankingNavigator) {

        this.mainMenuScreen = mainMenuScreen;
        this.registrationScreen = registrationScreen;
        this.loginScreen = loginScreen;
        this.bankingNavigator = bankingNavigator;

    }

    /**
     * Starts the application's main menu.
     */
    public void start() {

        boolean running = true;

        while (running) {

            int choice =
                    mainMenuScreen.show();

            running =
                    processChoice(choice);

        }

    }

    /**
     * Processes the selected menu option.
     */
    private boolean processChoice(
            int choice) {

        switch (choice) {

            case 1 -> registrationScreen.show();

            case 2 -> {

                LoginResponse response =
                        loginScreen.show();

                if (response.isSuccess()) {

                    bankingNavigator.start(
                            response.getUser());

                }

            }

            case 3 -> {

                return false;

            }

            default -> {

                // We'll improve invalid choice handling later.

            }

        }

        return true;

    }

}