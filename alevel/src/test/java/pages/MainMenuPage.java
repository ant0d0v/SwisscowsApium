package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.stream.Stream;

public class MainMenuPage extends BasePage {

    @AndroidFindBy(accessibility = "Search and Explore")
    private AndroidElement SearchAndExploreButton;

    @AndroidFindBy(accessibility = "Home")
    private AndroidElement HomeButton;

    @AndroidFindBy(accessibility = "Profile")
    private AndroidElement ProfileButton;

    @AndroidFindBy(id = "com.instagram.android:id/tab_icon", accessibility = "Camera")
    private AndroidElement CameraButton;

    public MainMenuPage(AndroidDriver driver){
        super(driver);
    }

    public SearchResultPage performSearch(){
        SearchAndExploreButton.click();
        return new SearchResultPage(driver);
    }

    public UserProfilePage proceedToUserProfile(){
        ProfileButton.click();
        return new UserProfilePage(driver);
    }

    @Override
    public boolean isShown() {
        return Stream.of(SearchAndExploreButton, HomeButton, CameraButton, ProfileButton).allMatch(AndroidElement::isDisplayed);
    }
}
