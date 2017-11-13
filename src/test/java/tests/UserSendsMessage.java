package tests;

import driver.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import step.WebUserLoginSteps;

@RunWith(SerenityRunner.class)
public class UserSendsMessage extends TestBase {

    private static final String message = "This is the message" + DateTime.now().getMillis();

    @Steps
    WebUserLoginSteps webUser;

    @Test
    public void userSendsMessage() {
        webUser.signs_in(login, password);
        webUser.finds_himself_on_the_main_page();
        webUser.creates_new_conversation_with(user);
        webUser.sends_message(message);
        webUser.sees_that_message_is_present_on_the_feed(message);
    }



}
