package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.stream.Stream;

public class EditUserProfilePage extends BasePage {


    @AndroidFindBy(accessibility = "Back")
    private AndroidElement BackButton;

    public EditUserProfilePage(AndroidDriver driver){
        super(driver);
    }

    @Override
    public boolean isShown() {
        return Stream.of(BackButton).allMatch(AndroidElement::isDisplayed);
    }

}
