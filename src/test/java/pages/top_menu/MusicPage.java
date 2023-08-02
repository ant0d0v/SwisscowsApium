package pages.top_menu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.base_abstract.TopMenuPage;

public class MusicPage extends TopMenuPage<MusicPage> {
    @AndroidFindBy(xpath =  "//com.horcrux.svg.GroupView/com.horcrux.svg.GroupView[2]/com.horcrux.svg.MaskView")
    private WebElement errorImageNoTrack;
    public MusicPage(AndroidDriver driver){
        super(driver);
    }
    public MusicPage createGeneric() {

        return new MusicPage(androidDriver);
    }
    public MusicPage waitUntilToBeVisibleErrorImageNoTrack(){
        wait10ElementToBeVisible(errorImageNoTrack);
        return new MusicPage(androidDriver);
    }
    public boolean errorImage_NoTracks_IsDisplayed(){
        return errorImageNoTrack.isDisplayed();
    }
}
