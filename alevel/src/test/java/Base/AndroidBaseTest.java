package Base;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
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

    public LoginPage openFirstScreen(){
        getAndroidDriver().launchApp();
        return new LoginPage(driver);
    }
}
