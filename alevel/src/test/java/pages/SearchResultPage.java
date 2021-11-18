package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.stream.Stream;

public class SearchResultPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@text=\"For You\"]")
    private AndroidElement ForYouFeedPage;

    public SearchResultPage(AndroidDriver driver){
        super(driver);
    }

    @Override
    public boolean isShown() {
        return Stream.of(ForYouFeedPage).allMatch(AndroidElement::isDisplayed);
    }
}
