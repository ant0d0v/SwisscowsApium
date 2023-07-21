package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.BasePage;

public class EditUserProfilePage extends BasePage {


    @AndroidFindBy(accessibility = "Back")
    private WebElement BackButton;

    public EditUserProfilePage(AndroidDriver driver){
        super(driver);
    }

    @Override
    public boolean isShown() {
        return BackButton.isDisplayed();
    }

}
