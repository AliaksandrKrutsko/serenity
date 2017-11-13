package tests;

import driver.TestBase;
import helper.DriverConfig;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import step.*;

@RunWith(SerenityRunner.class)
public class UserCreatesNewConversation extends TestBase {

    @Steps
    WebUserLoginSteps webUser;

    @Test
    public void user_creates_new_conversation() {
        webUser.signs_in(login, password);
        webUser.finds_himself_on_the_main_page();
        webUser.creates_new_conversation_with(user);
        webUser.can_see_the_call_button();
    }

}
