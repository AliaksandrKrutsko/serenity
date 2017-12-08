package driver;

import helper.DriverConfig;
import net.serenitybdd.core.pages.PageObject;
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
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

}
