package tests;

import driver.TestBase;
import helper.DriverConfig;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import step.*;

@RunWith(SerenityRunner.class)
public class UserSignsIn extends TestBase {

    private static final String login = DriverConfig.login();
    private static final String password = DriverConfig.password();

    @Steps
    WebUserLoginSteps webUser;

    @Test
    public void user_should_sign_in() {
        webUser.signs_in(login, password);
        webUser.finds_himself_on_the_main_page();
    }

}
