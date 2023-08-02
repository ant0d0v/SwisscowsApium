package pages.base_abstract;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.top_menu.WebPage;

import java.util.ArrayList;
import java.util.List;


public abstract class TopMenuPage<Generic> extends BasePage {
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement suggest;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView")
    private WebElement logoSwisscows;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private List<WebElement> allCriteriaInSuggestion;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")
    private WebElement placeholderOfSearchField;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private List<WebElement> iconsInSuggestion;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
            + "android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    private WebElement emailField;
   // @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText")
   // private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    private WebElement passwordField; //real device
    @AndroidFindBy(xpath =  "//android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    private WebElement loginButton;
    @AndroidFindBy(className =  "android.widget.EditText")
    private WebElement searchField;

    public TopMenuPage(AndroidDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();

    public  boolean suggestIsDisplayed(){
        return suggest.isDisplayed();
    }
    public MainPage clickSwisscowsLogo() {
        logoSwisscows.click();
        return new MainPage(driver);
    }
    public List<String> getAllTextOfElementsInSuggest() {
        List<String> textList = new ArrayList<>();
        for (WebElement element : allCriteriaInSuggestion) {
            textList.add(element.getText().toLowerCase());
        }
        return textList;
    }
    public String getTextOfPlaceholder() {
        return placeholderOfSearchField.getText();
    }
    public String getTextSearchField() {

        return getText(searchField);
    }
    public boolean iconsInSuggestAreDisplayed() {
        return areElementsInListDisplayed(iconsInSuggestion) ;
    }
    public MainPage loginToAccount(String email, String password){
        wait10ElementToBeVisible(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }
}