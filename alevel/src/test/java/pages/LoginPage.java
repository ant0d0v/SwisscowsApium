package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.base_abstract.BasePage;

public class LoginPage extends BasePage {

    private String pwd = "Westy123";


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
    private WebElement emailField;

    @AndroidFindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
    private WebElement pwdField;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Log in\"]")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Log in\"]")
    private WebElement ProceedLoginbutton;

    public LoginPage(AndroidDriver driver){
        super(driver);
    }

    public LoginPage setEmailField(){
        emailField.sendKeys("justcasualuser2@gmail.com");
        return this;
    }

    public LoginPage setPasswordField(){
        pwdField.sendKeys("Westy123");
        return this;
    }
    public LoginPage clickPasswordField(){
        pwdField.click();
        return this;
    }

    public MainMenuPage loginButton(){
        ProceedLoginbutton.click();
        return new MainMenuPage(driver);
    }
    public LoginPage proceedToLoginPage(){
        loginButton.click();
        return new LoginPage(driver);
    }
    @Override
    public boolean isShown() {
        return ProceedLoginbutton.isDisplayed();
    }
}
