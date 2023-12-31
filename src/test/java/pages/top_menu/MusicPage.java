package pages.top_menu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.base_abstract.TopMenuPage;

public class MusicPage extends TopMenuPage<MusicPage> {
    @AndroidFindBy(xpath =  "//com.horcrux.svg.GroupView/com.horcrux.svg.GroupView[2]/com.horcrux.svg.MaskView")
    private WebElement errorImageNoTrack;
    public MusicPage(AppiumDriver appiumDriver){
        super(appiumDriver);
    }
    public  MusicPage (IOSDriver iosDriver) {
        super(iosDriver);
    }
    public MusicPage (AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public MusicPage createGeneric() {

        return new MusicPage(appiumDriver);
    }
    public MusicPage waitUntilToBeVisibleErrorImageNoTrack(){
        wait10ElementToBeVisible(errorImageNoTrack);
        return new MusicPage(appiumDriver);
    }
    public boolean errorImage_NoTracks_IsDisplayed(){
        return errorImageNoTrack.isDisplayed();
    }
}
