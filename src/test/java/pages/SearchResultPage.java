package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.BasePage;

public class SearchResultPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@text=\"For You\"]")
    private WebElement ForYouFeedPage;

    public SearchResultPage(AndroidDriver driver){
        super(driver);
    }

    @Override
    public boolean isShown() {
        return ForYouFeedPage.isDisplayed();
    }
}
