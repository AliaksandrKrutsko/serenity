package page;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewConversationPage extends PageObject {

    WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);

    @FindBy(xpath = "//h2[contains(text(), 'New conversation')]")
    private WebElement newConversationTitle;

    @FindBy(xpath = "//label[@class='accessibility-element' and contains(text(), 'Add participant')]")
    private WebElement addParticipantField;

    @FindBy(xpath = "//button[contains(text(), 'Start')]")
    private WebElement startConversationButton;

    public NewConversationPage(WebDriver driver) {
        super(driver);
    }

    public NewConversationPage waitForNewConversationTitle() {
        wait.until(ExpectedConditions.visibilityOf(newConversationTitle));
        return this;
    }

    public NewConversationPage addParticipant(String userFullName) {
        Actions actions = new Actions(getDriver());
        actions
                .moveToElement(addParticipantField)
                .click()
                .sendKeys(userFullName)
                .build()
                .perform();
        WebElement androidName = getDriver().findElement(By.xpath("//span[@class=\"ui-match\" and contains(text(), '"+userFullName+"')]"));
        androidName.click();
        return this;
    }

    public NewConversationPage clickStartConversation() {
        startConversationButton.click();
        return this;
    }

}
