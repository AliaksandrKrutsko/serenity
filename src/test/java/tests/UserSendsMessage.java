package tests;

import driver.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import step.WebUserSteps;

@RunWith(SerenityRunner.class)
public class UserSendsMessage extends TestBase {

    private static final String message = "This is the message" + DateTime.now().getMillis();

    @Steps
    WebUserSteps webUser;

    @Test
    public void userSendsMessage() {
        webUser.signs_in(login, password);
        webUser.is_on_the_main_page();
        webUser.create_new_conversation_with(user);
        webUser.send_message(message);
        webUser.see_that_message_is_present_on_the_feed(message);
    }



}
