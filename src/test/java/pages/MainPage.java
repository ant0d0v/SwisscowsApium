package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.BasePage;

public class MainPage extends BasePage {


    @AndroidFindBy(className =  "android.widget.EditText")
    private WebElement image;

    public MainPage(AndroidDriver driver){
        super(driver);
    }



    @Override
    public boolean isShown() {
        return image.isDisplayed();
    }
}
