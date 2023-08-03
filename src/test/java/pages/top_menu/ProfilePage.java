package pages.top_menu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.TopMenuPage;

public class ProfilePage extends TopMenuPage<ProfilePage> {
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
            + "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private WebElement titleProfile;
    public ProfilePage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    public  ProfilePage (IOSDriver iosDriver) {
        super(iosDriver);
    }
    public ProfilePage (AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public ProfilePage createGeneric() {
        return new ProfilePage(appiumDriver);
    }

    public String getTitleProfile() {

        return getText(titleProfile);
    }
}
