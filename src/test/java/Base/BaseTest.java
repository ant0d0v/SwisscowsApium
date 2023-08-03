package Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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


public class BaseTest {

    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    protected AndroidDriver androidDriver;
    protected IOSDriver iosDriver;
    private WebDriverWait webDriverWait;

    protected AndroidDriver getAndroidDriver() {
        return androidDriver;
    }
    protected IOSDriver getIOSDriver() {
        return iosDriver;
    }
    public static String getAppiumUrl() {
        return APPIUM_URL;
    }
    private void setUpAndroidDriver() {
        androidDriver = AndroidBaseUtils.initDriver(getAndroidDriver());
        webDriverWait = new WebDriverWait(androidDriver, Duration.ofSeconds(20));
    }

    private void setUpIOSDriver() {
        iosDriver = IOSBaseUtils.initDriver(getIOSDriver());
        webDriverWait = new WebDriverWait(iosDriver, Duration.ofSeconds(20));
    }
    @BeforeSuite
    protected void beforeSuite(ITestContext context) {
        Reporter.log(ReportUtils.getReportHeader(context), true);
    }

    @BeforeClass
    public void setUpIOSDriver(ITestContext context) {
        setUpAndroidDriver();
        //
    }

    @AfterClass
    public void tearDown() {
        if (androidDriver != null) {

            androidDriver.closeApp();
            androidDriver.quit();
        }
        if(iosDriver!= null){

            iosDriver.closeApp();
            iosDriver.quit();
        }
    }

    @BeforeMethod
    public void beforeTestMethod(Method method, ITestResult result) {
        if (getAndroidDriver() != null) {
            getAndroidDriver().resetApp();
        } else if (getIOSDriver() != null) {
            getIOSDriver().resetApp();
        }

        Reporter.log(ReportUtils.END_LINE, true);
        Reporter.log("TEST RUN", true);
        Reporter.log(ReportUtils.getClassNameTestName(method, result), true);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestMethod(Method method, ITestResult result) {
        if (!result.isSuccess()) {
            captureScreenshot();
        }
        AndroidBaseUtils.logf("Execution time is %o sec\n\n", (result.getEndMillis() - result.getStartMillis()) / 1000);
        Reporter.log(ReportUtils.getTestStatistics(method, result), true);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] captureScreenshot() {
        if (androidDriver != null) {
            return ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BYTES);
        } else if (iosDriver != null) {
            return ((TakesScreenshot) iosDriver).getScreenshotAs(OutputType.BYTES);
        }
        return null;
    }
    protected WebDriverWait getWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(getAndroidDriver(), Duration.ofSeconds(20));
        }

        return webDriverWait;
    }



    public MainPage openFirstScreen(){
        TestUtils.loadBaseUrlPage(getAndroidDriver(), getWait());

        if (TestUtils.isH2HeaderExists(getAndroidDriver())) {
            Reporter.log("App was opened successfully on Android platform ", true);
        } else {
            TestUtils.reLoadBaseUrlPage(getAndroidDriver(), getWait());
        }
        return new MainPage(getAndroidDriver());
    }
    public MainPage openFirstScreenOnIOS(){
        TestUtils.loadBaseUrlPage(getIOSDriver(), getWait());

        if (TestUtils.isH2HeaderExists(getIOSDriver())) {
            Reporter.log("App was opened successfully on IOS platform ", true);
        } else {
            TestUtils.reLoadBaseUrlPage(getIOSDriver(), getWait());
        }
        return new MainPage(getIOSDriver());
    }
}
