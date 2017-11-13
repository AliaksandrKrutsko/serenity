package page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

    @FindBy(xpath = "//div[(contains(text(), 'for WC_Common'))]")
    private WebElement title;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleVisible() {
        return title.isDisplayed();
    }

}
