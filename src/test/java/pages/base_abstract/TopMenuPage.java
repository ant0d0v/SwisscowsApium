package pages.base_abstract;
import io.appium.java_client.android.AndroidDriver;


public abstract class TopMenuPage<Generic> extends BasePage {


    public TopMenuPage(AndroidDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();
}