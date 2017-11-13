package driver;

import helper.DriverConfig;
import net.thucydides.core.annotations.Managed;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    protected static final String login = DriverConfig.login();
    protected static final String password = DriverConfig.password();
    protected static final String user = DriverConfig.user();

    @After
    public void teardown() {
        DriverSingleton.getDriver().quit();
    }

}
