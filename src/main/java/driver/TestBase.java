package driver;

import helper.DriverConfig;
import org.junit.After;

public class TestBase {

    protected static final String login = DriverConfig.login();
    protected static final String password = DriverConfig.password();
    protected static final String user = DriverConfig.user();

    @After
    public void teardown() {
        DriverSingleton.getDriver().quit();
    }

}
