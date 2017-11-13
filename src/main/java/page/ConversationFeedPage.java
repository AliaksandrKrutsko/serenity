package page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ConversationFeedPage extends PageObject {

    @FindBy(css = "[class='action-button start voice'")
    private WebElement callButton;

    @FindBy(xpath = "//div[@id='input-field'][@contenteditable='true']")
    private WebElement inputField;

    @FindBy(xpath = "(//button[@class='more'])[last()]")
    private WebElement lastMessageThreeDotsOptions;

    @FindBy(xpath = "//a[@role=\"menuitem\" and contains(text(), 'Delete')]")
    private WebElement deleteMessage;

    @FindBy(xpath = "//button[@class=\"button medium light-background primary\"]")
    private WebElement confirmDeleteAlert;

    @FindBy(xpath = "//div[@class=\"firefinder-match\"]")
    private WebElement editInputField;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    private WebElement saveEditedMessage;

    @FindBy(xpath = "//a[contains(text(), 'Edit')]")
    private WebElement editMessage;

    public ConversationFeedPage(WebDriver driver) {
        super(driver);
    }

    public ConversationFeedPage assertCallButtonVisible() {
        assertTrue(callButton.isDisplayed());
        return this;
    }

    public ConversationFeedPage sendMessage(String message) {
        inputField.click();
        inputField.sendKeys(message);
        inputField.sendKeys(Keys.ENTER);
        return this;
    }

    public ConversationFeedPage findMessage(String message) {
        WebElement messageXpath = getDriver().findElement(By.xpath("//div[@class='message-wrapper']/div/span[contains(text(), '"+message+"')]"));
        assertTrue(messageXpath.isDisplayed());
        return this;
    }

    public ConversationFeedPage pressLastMessageOptions() {
        lastMessageThreeDotsOptions.click();
        return this;
    }

    public ConversationFeedPage deleteMessage() {
        deleteMessage.click();
        confirmDeleteAlert.click();
        return this;
    }

    public ConversationFeedPage assertNoMessageIsDisplayed(String message) {
        WebElement messageXpath = getDriver().findElement(By.xpath("//div[@class='message-wrapper']/div/span[contains(text(), '"+message+"')]"));
        assertFalse(messageXpath.isDisplayed());
        return this;
    }

    public ConversationFeedPage assertMessageIsDisplayed(String message) {
        WebElement messageXpath = getDriver().findElement(By.xpath("//div[@class='message-wrapper']/div/span[contains(text(), '"+message+"')]"));
        assertTrue(messageXpath.isDisplayed());
        return this;
    }

    public ConversationFeedPage highlightAndDeleteMessage(String message) {
        WebElement messageXpath = getDriver().findElement(By.xpath("//div[contains(text(), '"+message+"'"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(messageXpath, 0, 0)
                .clickAndHold()
                .moveByOffset(50, 0)
                .release()
                .perform();
        messageXpath.sendKeys(Keys.DELETE);
        return this;
    }

    public ConversationFeedPage sendEditedMessage(String message) {
        editInputField.sendKeys(message);
        saveEditedMessage.click();
        return this;
    }

    public ConversationFeedPage editMessage() {
        lastMessageThreeDotsOptions.click();
        editMessage.click();
        return this;
    }

}
