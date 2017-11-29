package driver;

import helper.DriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static String driverType = DriverConfig.browser();
    private static WebDriver driver = null;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {

            switch (driverType) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", DriverConfig.geckodriver());
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", DriverConfig.chromedriver());
                    driver = new ChromeDriver();
                    break;
                default:
                    System.setProperty("webdriver.gecko.driver", DriverConfig.geckodriver());
                    driver = new FirefoxDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(DriverConfig.timeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(DriverConfig.timeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(DriverConfig.timeout(), TimeUnit.SECONDS);
        }
        return driver;
    }

}
