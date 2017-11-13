package page;

import com.google.common.base.Predicate;
import driver.DriverSingleton;
import helper.DriverConfig;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverSingleton.getDriver;

@DefaultUrl("https://10.6.238.222")
public class LoginEmailPage extends PageObject {

    @FindBy(xpath = "//input[@id='id_loginViewEmail']")
    private WebElement emailField;

    @FindBy(xpath = "//button[(contains(text(), 'Next'))]")
    private WebElement nextButton;

    @FindBy(xpath = "//h2[(contains(text(), 'Sign in to your Circuit account'))]")
    private WebElement titleText;


    public LoginEmailPage(WebDriver driver) {
        super(driver);
    }

    public LoginEmailPage enterLogin(String login) {
        emailField.sendKeys(login);
        return this;
    }

    public LoginPasswordPage pressNextButton() {
        nextButton.click();
        return new LoginPasswordPage(getDriver());
    }

    public LoginEmailPage waitForTitleText() {
        element(titleText).waitUntilVisible();
        return this;
    }

}
