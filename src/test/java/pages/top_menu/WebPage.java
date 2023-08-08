package pages.top_menu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.TopMenuPage;

import java.util.List;

public class WebPage extends TopMenuPage<WebPage> {
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement firstResultOfWebSearch;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
    private WebElement buttonShowMore;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private List<WebElement> allResultOfWebSearch;
    @iOSXCUITFindBy(id = "search btn")
    @AndroidFindBy(className=  "android.widget.Image")
    private WebElement imageOfPreview;
    @iOSXCUITFindBy(id = "search btn")
    @AndroidFindBy(xpath=  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView")
    private WebElement firstVideoInWidget;
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
    public WebPage waitUntilVisibilityImageInPreview() {
        wait10ElementToBeVisible(imageOfPreview);
        return this;
    }
    public WebPage holdThreeSecond(){
        hold(firstResultOfWebSearch,3);
        return new WebPage(getAppiumDriver());
    }
    public WebPage clickFirstVideoInWidget(){
        firstVideoInWidget.click();
        return new WebPage(getAppiumDriver());
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
