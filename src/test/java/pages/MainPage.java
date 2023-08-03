package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.TopMenuPage;
import pages.top_menu.ImagePage;
import pages.top_menu.MusicPage;
import pages.top_menu.ProfilePage;
import pages.top_menu.WebPage;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends TopMenuPage<MainPage> {


    @iOSXCUITFindBy(className =  "android.widget.EditText")
    @AndroidFindBy(className =  "android.widget.EditText")
    private WebElement searchField;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement suggest;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView")
    private WebElement logoSwisscows;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    private WebElement firstCriteriaInSuggestion;
    @AndroidFindBy(xpath =  "//android.widget.TextView[@text='My music']")
    private WebElement myMusicInSuggestion;
    @AndroidFindBy(xpath =  "//android.widget.TextView[@text='My images']")
    private WebElement myImagesInSuggestion;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView")
    private WebElement recentSearchesInSuggestion;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup")
    private WebElement loginIcon;
    @AndroidFindBy(className =  "android.widget.ImageView")
    private WebElement avatarOfProfile;


    public MainPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    public MainPage(IOSDriver iosDriver) {
        super(iosDriver);
    }

    public MainPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public MainPage createGeneric() {
        return new MainPage(appiumDriver);
    }

    public boolean loginButtonIsDisplayed() {
        return loginIcon.isDisplayed();
    }
    public boolean logoSwisscowsIsDisplayed() {
        return logoSwisscows.isDisplayed();
    }
    public boolean avatarIsDisplayed() {
        return avatarOfProfile.isDisplayed();
    }
    public MainPage clickSearchField() {
        searchField.click();
        return new MainPage(appiumDriver);
    }
    public MainPage clickLoginIcon() {
      loginIcon.click();
      return new MainPage(appiumDriver);
    }
    public MusicPage clickMyMusicInSuggestion() {
        myMusicInSuggestion.click();
        return new MusicPage(appiumDriver);
    }
    public ImagePage clickMyImagesInSuggestion() {
        myImagesInSuggestion.click();
        return new ImagePage(appiumDriver);
    }
    public ProfilePage clickLoginIconAfterLoggingIn() {
        clickLoginIcon();
        return new ProfilePage(appiumDriver);
    }
    public WebPage clickFirstCriteriaInSuggestion() {
        firstCriteriaInSuggestion.click();
        return new WebPage(appiumDriver);
    }
    public WebPage clickRecentSearchesInSuggestion() {
        recentSearchesInSuggestion.click();
        return new WebPage(appiumDriver);
    }
    public MainPage inputSearchCriteria(String text) {
        searchField.sendKeys(text);
        return this;
    }
    public MainPage waitForSuggestToBeVisible() {
        wait10ElementToBeVisible(suggest);
        return new MainPage(appiumDriver);
    }
    public MainPage waitForAvatarOnMainScreenToBeVisible() {
        wait10ElementToBeVisible(avatarOfProfile);
        return new MainPage(appiumDriver);
    }
    public WebPage clickEnterForAndroid() {
        clickEnterForAndroidPlatform();
        return new WebPage(appiumDriver);
    }

}
