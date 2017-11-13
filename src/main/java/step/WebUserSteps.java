package step;

import driver.DriverSingleton;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.*;

public class WebUserSteps {

    protected WebDriver driver = DriverSingleton.getDriver();

    MainPage mainPage = new MainPage(driver);
    NewConversationPage newConversationPage = new NewConversationPage(driver);
    ConversationFeedPage conversationFeedPage = new ConversationFeedPage(driver);
    ConversationSelectorPage conversationSelectorPage = new ConversationSelectorPage(driver);

    @Step("User finds himself on the main page")
    public void finds_himself_on_the_main_page() {
        Assert.assertTrue(mainPage.isTitleVisible());
    }

    @Step("User can see the call button")
    public void can_see_the_call_button() {
        conversationFeedPage.assertCallButtonVisible();
    }

    @Step("User creates new conversation with {0}")
    public void creates_new_conversation_with(String participantName) {
        conversationSelectorPage.clickPlus();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conversationSelectorPage.createNewConversation();
        newConversationPage.waitForNewConversationTitle();
        newConversationPage
                .addParticipant(participantName)
                .clickStartConversation();
    }

    @Step("User sends message")
    public void sends_message(String message) {
        conversationFeedPage.sendMessage(message);
    }

    @Step("User sees the sent message")
    public void sees_that_message_is_present_on_the_feed(String message) {
        conversationFeedPage.findMessage(message);
    }

    @Step("User deletes last message")
    public void deletes_last_message() {
        conversationFeedPage
                .pressLastMessageOptions()
                .deleteMessage();
    }

    @Step("User asserts that message was deleted")
    public void asserts_that_message_is_deleted(String message) {
        conversationFeedPage.assertNoMessageIsDisplayed(message);
    }

    @Step("User asserts that message is displayed on feed")
    public void asserts_that_message_is_displayed_on_feed(String message) {
        conversationFeedPage.assertMessageIsDisplayed(message);
    }

    @Step("User edits his message")
    public void edits_his_message(String oldMessage, String newMessage) {
        conversationFeedPage.editMessage();
        conversationFeedPage.highlightAndDeleteMessage(oldMessage);
        conversationFeedPage.sendEditedMessage(newMessage);
    }

}