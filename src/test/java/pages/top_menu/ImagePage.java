package pages.top_menu;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.TopMenuPage;

public class ImagePage extends TopMenuPage<ImagePage> {
    @iOSXCUITFindBy(accessibility = "button_login")
    @AndroidFindBy(xpath =  "//com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement errorImageNoImage;

public ImagePage(AppiumDriver appiumDriver) {
    super(appiumDriver);
}
    public  ImagePage (IOSDriver iosDriver) {
        super(iosDriver);
    }
    public ImagePage (AndroidDriver androidDriver) {
        super(androidDriver);
    }
    public ImagePage createGeneric() {

        return new ImagePage(appiumDriver);
    }
    public ImagePage waitUntilToBeVisibleErrorImageNoImage(){
        wait10ElementToBeVisible(errorImageNoImage);
        return new ImagePage(appiumDriver);
    }
    public boolean errorImage_NoImage_IsDisplayed(){
        return errorImageNoImage.isDisplayed();
    }
}
