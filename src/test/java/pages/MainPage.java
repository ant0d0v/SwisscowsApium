package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.TopMenuPage;
import pages.top_menu.WebPage;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends TopMenuPage<MainPage> {


    @AndroidFindBy(className =  "android.widget.EditText")
    private WebElement searchField;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement suggest;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private List<WebElement> allCriteriaInSuggestion;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    private WebElement firstCriteriaInSuggestion;


    public MainPage(AndroidDriver driver){
        super(driver);
    }
    public MainPage createGeneric() {
        return new MainPage(driver);
    }

    public boolean logoIsDisplayed() {

        return searchField.isDisplayed();
    }
    public MainPage clickSearchField() {
        searchField.click();
        return new MainPage(driver);
    }
    public WebPage clickFirstCriteriaInSuggestion() {
        firstCriteriaInSuggestion.click();
        return new WebPage(driver);
    }
    public MainPage inputSearchCriteria(String text) {
        searchField.sendKeys(text);
        return this;
    }
    public MainPage waitForSuggestToBeVisible() {
        wait10ElementToBeVisible(suggest);
        return new MainPage(driver);
    }
    public WebPage inputSearchCriteriaAndEnter(String text) {
        searchField.sendKeys(text);
        clickEnter(searchField);
        return new WebPage(driver);
    }

}
