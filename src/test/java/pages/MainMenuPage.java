package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.BasePage;

public class MainMenuPage extends BasePage {

    @AndroidFindBy(accessibility = "Search and Explore")
    private WebElement SearchAndExploreButton;

    @AndroidFindBy(accessibility = "Home")
    private WebElement HomeButton;

    @AndroidFindBy(accessibility = "Profile")
    private WebElement ProfileButton;

    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
    private WebElement image;

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
        return image.isDisplayed();
    }
}
