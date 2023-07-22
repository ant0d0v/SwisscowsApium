package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.BasePage;

public class GreetingsPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Log in\"]")
    private WebElement loginButton;

    public GreetingsPage(AndroidDriver driver){
        super(driver);
    }


    @Override
    public boolean isShown() {
        return loginButton.isDisplayed();
    }
}
