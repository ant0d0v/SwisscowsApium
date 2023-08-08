package pages.base_abstract;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;


public abstract class TopMenuPage<Generic> extends BasePage {

    @iOSXCUITFindBy(id = "search btn")
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement suggest;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView")
    private WebElement logoSwisscows;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private List<WebElement> allCriteriaInSuggestion;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")
    private WebElement placeholderOfSearchField;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]"
            + "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private List<WebElement> iconsInSuggestion;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
            + "android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    private WebElement emailField;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(className=  "android.widget.Image")
    private WebElement imageOfScreenshot;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(xpath=   "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
            + "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]"
            + "/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
    private WebElement openButtonInWebPreview;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(xpath=   "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
            + "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]"
            + "/android.view.ViewGroup[2]/android.view.ViewGroup[2]")
    private WebElement copyButtonInWebPreview;
    @iOSXCUITFindBy (id = "search btn")
    @AndroidFindBy(xpath=   "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
            + "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]"
            + "/android.view.ViewGroup[2]/android.view.ViewGroup[3]")
    private WebElement shareButtonInWebPreview;
    @AndroidFindAll(value = {
            @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
                     + "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
    }
    )
    private WebElement passwordField;
    @AndroidFindAll(value = {
            @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
                    + "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button")
    }
    )
    private WebElement loginButton;
    @AndroidFindBy(className =  "android.widget.EditText")
    private WebElement searchField;
    @AndroidFindBy(xpath =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    private WebElement headerSwisscowsApp;

    public TopMenuPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    public TopMenuPage(IOSDriver iosDriver) {
        super(iosDriver);
    }

    public TopMenuPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    public abstract Generic createGeneric();

    public  boolean suggestIsDisplayed(){
        return suggest.isDisplayed();
    }
    public MainPage clickSwisscowsLogo() {
        logoSwisscows.click();
        return new MainPage(appiumDriver);
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
    public void clickOpenButtonInWebPreview() {
         openButtonInWebPreview.click();
    }
    public boolean iconsInSuggestAreDisplayed() {
        return areElementsInListDisplayed(iconsInSuggestion) ;
    }
    public boolean headerSwisscowsAppIsDisplayed() {
        return headerSwisscowsApp.isDisplayed() ;
    }
    public MainPage loginToAccount(String email, String password){
        wait10ElementToBeVisible(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new MainPage(appiumDriver);
    }

}