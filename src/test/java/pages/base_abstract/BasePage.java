package pages.base_abstract;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
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

public abstract class BasePage {

    protected AndroidDriver driver;
    private WebDriverWait webDriverWait10;
    private Actions actions;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver,  Duration.ofSeconds(10)), this);
    }
    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }
    protected Actions getActions() {
        if (actions == null) {
            actions = new Actions(driver);
        }

        return actions;
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
    protected void clickEnter(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    protected void performScroll() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2 ;
        int endX = size.getWidth() ;
        int startY = size.getHeight()  ;
        int endY = (int) (size.getHeight () * 0.01);
        performScrollUsingSequence(startX,startY,endX,endY);
    }
    protected void scrollToElement() {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
    }
    protected void  performScrollUsingSequence(int startX, int startY,int endX, int endY){
        PointerInput finger = new PointerInput (PointerInput. Kind. TOUCH, "first-finger");
        Sequence sequence = new Sequence(finger,  0)
                .addAction (finger.createPointerMove(Duration.ZERO, PointerInput. Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg() ))
                .addAction (finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) (driver)) .perform(Collections.singletonList (sequence));
    }


}
