package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.stream.Stream;

public class UserProfilePage extends BasePage {

    @AndroidFindBy(id = "com.instagram.android:id/row_profile_header_edit_profile")
    private AndroidElement EditProfileButton;

    public UserProfilePage(AndroidDriver driver){
        super(driver);
    }

    @Override
    public boolean isShown() {
        return Stream.of(EditProfileButton).allMatch(AndroidElement::isDisplayed);

    }

    public EditUserProfilePage proceedToEdit(){
        EditProfileButton.click();
        return new EditUserProfilePage(driver);
    }
}
