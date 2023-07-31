package Base;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.MainPage;
import utils.ReportUtils;
import utils.TestUtils;

import java.lang.reflect.Method;
import java.time.Duration;


public class AndroidBaseTest {

    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    public static AndroidDriver driver;
    private WebDriverWait webDriverWait;

    protected AndroidDriver getAndroidDriver() {
        return driver;
    }
    public static String getAppiumUrl() {
        return APPIUM_URL;
    }
    @BeforeSuite
    protected void beforeSuite(ITestContext context) {
        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeClass
    public void setUp(ITestContext context) {
        driver = AndroidBaseUtils.initDriver(getAndroidDriver());
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.closeApp();
            driver.quit();
        }
    }

    @BeforeMethod
    public void setTestApp(Method method, ITestResult result) {
        getAndroidDriver().resetApp();
        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(Method method,ITestResult result) {
        if (!result.isSuccess()) {
            captureScreenshot();
        }
        AndroidBaseUtils.logf("Execution time is %o sec\n\n", (result.getEndMillis() - result.getStartMillis()) / 1000);
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    protected WebDriverWait getWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait;
    }
    protected AndroidDriver getDriver() {
        return driver;
    }
    

    public MainPage openFirstScreen(){
        TestUtils.loadBaseUrlPage(getDriver(), getWait());

        if (TestUtils.isH2HeaderExists(getDriver())) {
            Reporter.log("App was opened successfully ", true);
        } else {
            TestUtils.reLoadBaseUrlPage(getDriver(), getWait());
        }

        return new MainPage(driver);
    }
}
