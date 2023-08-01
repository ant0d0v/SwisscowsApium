package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.TopMenuPage;

public class MainPage extends TopMenuPage<MainPage> {


    @AndroidFindBy(className =  "android.widget.EditText")
    private WebElement searchField;

    public MainPage(AndroidDriver driver){
        super(driver);
    }
    public MainPage createGeneric() {
        return new MainPage(driver);
    }

    public boolean logoIsDisplayed() {
       return searchField.isDisplayed();
    }

}
