package tests;

import driver.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import step.*;

@RunWith(SerenityRunner.class)
public class UserCreatesNewConversation extends TestBase {

    @Steps
    WebUserSteps webUser;

    @Test
    public void user_creates_new_conversation() {
        webUser.signs_in(login, password);
        webUser.is_on_the_main_page();
        webUser.create_new_conversation_with(user);
        webUser.can_see_the_call_button();
    }

}
