package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base_abstract.BasePage;

import java.time.Duration;

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
    @Step
    public LoginPage setEmailField(){
        emailField.sendKeys("justcasualuser2@gmail.com");
        return this;
    }
    @Step
    public LoginPage setPasswordField(){
        pwdField.sendKeys("Westy123");
        return this;
    }
    @Step
    public LoginPage clickPasswordField(){
        pwdField.click();
        return this;
    }
    @Step
    public MainMenuPage loginButton(){
        ProceedLoginbutton.click();
        return new MainMenuPage(driver);
    }
    @Step
    public LoginPage proceedToLoginPage(){
        loginButton.click();
        return new LoginPage(driver);
    }
    @Step
    public LoginPage waitUntilToBeVisibleLoginScreen(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return new LoginPage(driver);
    }

    @Override
    public boolean isShown() {
        return ProceedLoginbutton.isDisplayed();
    }
}
