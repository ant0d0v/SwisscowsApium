package pages.top_menu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.base_abstract.TopMenuPage;

import java.util.ArrayList;
import java.util.List;

public class WebPage extends TopMenuPage<WebPage> {
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement firstResultOfWebSearch;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
    private WebElement buttonShowMore;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private List<WebElement> allResultOfWebSearch;
    public WebPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    public  WebPage (IOSDriver iosDriver) {
        super(iosDriver);
    }
    public WebPage (AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public WebPage createGeneric() {
        return new WebPage(appiumDriver);
    }
    public WebPage waitUntilVisibilityWebResult() {
        wait10ElementToBeVisible(firstResultOfWebSearch);
        return this;
    }
    public List<String> getTextAllTitlesOfWebResult() {
       return getTexts(allResultOfWebSearch);
    }

    public WebPage scrollToButtonShowMoreResult() {
        return new WebPage(appiumDriver);
    }
    public WebPage waitUntilVisibilityButtonShowMoreResult(){
        wait10ElementToBeVisible(buttonShowMore);
        return this;
    }

}
