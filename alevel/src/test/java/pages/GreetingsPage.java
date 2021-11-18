package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.stream.Stream;

public class GreetingsPage extends BasePage {

    @AndroidFindBy(id = "com.instagram.android:id/log_in_button")
    private AndroidElement loginButton;

    public GreetingsPage(AndroidDriver driver){
        super(driver);
    }

    public LoginPage proceedToLoginPage(){
        loginButton.click();
        return new LoginPage(driver);
    }

    @Override
    public boolean isShown() {
        return Stream.of(loginButton).allMatch(AndroidElement::isDisplayed);
    }
}
