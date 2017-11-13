package page;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverSingleton.getDriver;

public class LoginPasswordPage extends PageObject {

    @FindBy(xpath = "//input[@id='id_loginViewPassword']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[(contains(text(), 'Sign in'))]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[(contains(text(), 'Please enter password'))]")
    private WebElement enterPasswordText;

    public LoginPasswordPage(WebDriver driver) {
        super(driver);
    }

    public LoginPasswordPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPasswordPage pressSignInButton() {
        signInButton.click();
        return this;
    }

    public LoginPasswordPage waitForText() {
        waitFor(enterPasswordText);
        return this;
    }

}
