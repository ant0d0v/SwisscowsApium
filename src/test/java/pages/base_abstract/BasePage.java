package pages.base_abstract;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class BasePage {

    protected AndroidDriver androidDriver;
    protected IOSDriver iosDriver;
    protected AppiumDriver appiumDriver;
    private WebDriverWait webDriverWait10;
    private  TouchAction touchAction;
    private Actions actions;

    public BasePage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }
    public BasePage(IOSDriver iosDriver) {
        this.appiumDriver = iosDriver;
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver, Duration.ofSeconds(10)), this);
    }
    public BasePage(AndroidDriver androidDriver) {
        this.appiumDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(10)), this);
    }

    private String getPlatformVar () {
        return System.getenv("ios");
    }

    protected AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(getAppiumDriver() , Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }
    protected Actions getActions() {
        if (actions == null) {
            actions = new Actions(getAppiumDriver());
        }

        return actions;
    }
    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }



    protected String getText(WebElement element) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }
        return element.getText();
    }
    protected List<String> getTexts(List<WebElement> list) {
        if (list.size() > 0) {
            getWait10().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> textList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    textList.add(element.getText());
                }
            }

            return textList;
        }

        return new ArrayList<>();
    }
    protected void wait10ElementToBeVisible(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
    }
    protected WebElement wait10ElementToBeClickable(WebElement element) {
        return getWait10().until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void click(WebElement element) {
        wait10ElementToBeVisible(element);
        wait10ElementToBeClickable(element).click();
    }
    protected boolean areElementsInListDisplayed(List<WebElement> list) {
        boolean result = false;

        for (WebElement element : list) {
            if (element.isDisplayed()) {
                result = true;
            } else {

                return false;
            }
        }

        return result;
    }
    protected void clickEnterForAndroidPlatform() {
        if (appiumDriver instanceof AndroidDriver) {
            androidDriver = (AndroidDriver ) appiumDriver;
            androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
        }
    }
    protected void performScroll() {
        Dimension size = getAppiumDriver().manage().window().getSize();
        int startX = size.getWidth() / 2 ;
        int endX = size.getWidth() ;
        int startY = size.getHeight()  ;
        int endY = (int) (size.getHeight () * 0.01);
        performScrollUsingSequence(startX,startY,endX,endY);
    }
    protected void scroll() {
        getAppiumDriver() .findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
    }
    public void hold(WebElement startPoint, int waitOptions) {
        TouchAction action = new TouchAction((PerformsTouchActions) appiumDriver);
        action.press(ElementOption.element(startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitOptions)))
                .release()
                .perform();
    }
    public void holdIOS(WebElement startPoint, int waitOptions) {
        TouchAction action = new TouchAction((PerformsTouchActions) appiumDriver);
        action.press(ElementOption.element(startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitOptions)))
                .release()
                .perform();
    }
    protected void scrollToElement(WebElement element) {;

        getAppiumDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().resourceId(\"" + element + "\"));"
        ));

    }
    public String getCurrentActivity() {
        return getAndroidDriver().getCurrentUrl();
    }
    protected void  performScrollUsingSequence(int startX, int startY,int endX, int endY){
        PointerInput finger = new PointerInput (PointerInput. Kind. TOUCH, "first-finger");
        Sequence sequence = new Sequence(finger,  0)
                .addAction (finger.createPointerMove(Duration.ZERO, PointerInput. Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg() ))
                .addAction (finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) (getAppiumDriver() )) .perform(Collections.singletonList (sequence));
    }

}
