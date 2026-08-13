package versions.v2.application;

public class Application {

    private final ApplicationContext applicationContext;

    public Application() {

        applicationContext = new ApplicationContext();

    }

    public void start() {

        applicationContext
                .getConsoleApplication()
                .start();

    }

}

