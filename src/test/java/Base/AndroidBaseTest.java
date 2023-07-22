package Base;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;


public class AndroidBaseTest {

    public static AndroidDriver driver;
    protected AndroidDriver getAndroidDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {

        driver = AndroidBaseUtils.initDriver(getAndroidDriver());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.closeApp();
            driver.quit();
        }
    }

    @BeforeMethod
    public void setTestApp() {
        getAndroidDriver().resetApp();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        if (!result.isSuccess()) {
            captureScreenshot();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public LoginPage openFirstScreen(){
        getAndroidDriver().launchApp();
        return new LoginPage(driver);
    }
}
