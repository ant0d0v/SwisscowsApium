package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.BasePage;

public class UserProfilePage extends BasePage {

    @AndroidFindBy(id = "com.instagram.android:id/row_profile_header_edit_profile")
    private WebElement EditProfileButton;

    public UserProfilePage(AndroidDriver driver){
        super(driver);
    }

    @Override
    public boolean isShown() {
        return EditProfileButton.isDisplayed();

    }

    public EditUserProfilePage proceedToEdit(){
        EditProfileButton.click();
        return new EditUserProfilePage(driver);
    }
}
