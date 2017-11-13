package page;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverSingleton.getDriver;

public class ConversationSelectorPage extends PageObject {

    WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);

    @FindBy(css = "[class='component control-strip'")
    private WebElement newConversationPlus;

    @FindBy(xpath = "//div[@class='popover top']//li[@role='presentation']/a[contains(text(), 'Conversation')]")
    private WebElement createNewConversation;

    public ConversationSelectorPage(WebDriver driver) {
        super(driver);
    }

    public ConversationSelectorPage clickPlus() {
        newConversationPlus.click();
        return this;
    }

    public ConversationSelectorPage createNewConversation() {
        createNewConversation.click();
        return this;
    }

    public ConversationSelectorPage waitForCreateConversationToAppear() {
        wait.until(ExpectedConditions.visibilityOf(createNewConversation));
        return this;
    }

}
