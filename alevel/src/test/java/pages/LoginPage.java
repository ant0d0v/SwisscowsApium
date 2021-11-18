package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.stream.Stream;

public class LoginPage extends BasePage {

    private String pwd = "Westy123";
    private String email = "justcasualuser2@gmail.com";

    @AndroidFindBy(id = "com.instagram.android:id/login_username")
    private AndroidElement emailField;

    @AndroidFindBy(id = "com.instagram.android:id/password")
    private AndroidElement pwdField;

    @AndroidFindBy(id = "com.instagram.android:id/button_text")
    private AndroidElement ProceedLoginbutton;

    public LoginPage(AndroidDriver driver){
        super(driver);
    }

    public LoginPage setEmailField(){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage setPasswordField(){
        pwdField.sendKeys(pwd);
        return this;
    }

    public MainMenuPage performLogin(){
        ProceedLoginbutton.click();
        return new MainMenuPage(driver);
    }

    @Override
    public boolean isShown() {
        return Stream.of(emailField, pwdField, ProceedLoginbutton).allMatch(AndroidElement::isDisplayed);
    }
}
