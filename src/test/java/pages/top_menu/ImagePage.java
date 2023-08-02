package pages.top_menu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.TopMenuPage;

public class ImagePage extends TopMenuPage<ImagePage> {
    @AndroidFindBy(xpath =  "//com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement errorImageNoImage;
    public ImagePage(AndroidDriver driver){
        super(driver);
    }
    public ImagePage createGeneric() {

        return new ImagePage(driver);
    }
    public ImagePage waitUntilToBeVisibleErrorImageNoImage(){
        wait10ElementToBeVisible(errorImageNoImage);
        return new ImagePage(driver);
    }
    public boolean errorImage_NoImage_IsDisplayed(){
        return errorImageNoImage.isDisplayed();
    }
}
