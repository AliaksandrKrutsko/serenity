package step;

import net.thucydides.core.annotations.Step;
import page.LoginEmailPage;
import page.LoginPasswordPage;

public class WebUserLoginSteps extends WebUserSteps {

    LoginEmailPage loginEmailPage = new LoginEmailPage(driver);
    LoginPasswordPage loginPasswordPage = new LoginPasswordPage(driver);

    @Step("User signs in")
    public void signs_in(String login, String password) {
        loginEmailPage.open();
        loginEmailPage
                .waitForTitleText()
                .enterLogin(login)
                .pressNextButton();
        loginPasswordPage
                .waitForText()
                .enterPassword(password)
                .pressSignInButton();
    }

}
