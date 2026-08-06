package versions.v2.application.module;

import versions.v2.application.Bootstrap;
import versions.v2.presentation.console.screen.WelcomeScreen;
import versions.v2.presentation.console.navigation.MainMenuNavigator;

public class  ConsoleApplication {

    private final Bootstrap bootstrap;
    private final WelcomeScreen welcomeScreen;
    private final MainMenuNavigator mainMenuNavigator;

    public ConsoleApplication(
            Bootstrap bootstrap,
            WelcomeScreen welcomeScreen,
            MainMenuNavigator mainMenuNavigator) {

        this.bootstrap = bootstrap;
        this.welcomeScreen = welcomeScreen;
        this.mainMenuNavigator = mainMenuNavigator;
    }

    public void start() {

        bootstrap.initialize();

        welcomeScreen.show();

        mainMenuNavigator.start();
    }
}