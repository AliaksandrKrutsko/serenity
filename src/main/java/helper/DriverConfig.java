package helper;

import org.openqa.selenium.remote.BrowserType;

import java.io.InputStream;
import java.util.Properties;

public class DriverConfig {


    public static String browser() {
        return Props.BROWSER.get();
    }

    public static String geckodriver() {
        return Props.GECKODRIVER.get();
    }

    public static String chromedriver() {
        return Props.CHROMEDRIVER.get();
    }

    public static String login() {
        return Props.LOGIN.get();
    }

    public static String user() {
        return Props.USER.get();
    }

    public static String password() {
        return Props.PASSWORD.get();
    }

    public static int timeout() {
        return Integer.parseInt(Props.TIMEOUT.get());
    }

}
