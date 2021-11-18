package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AndroidBaseTest {

    public static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";//System.getProperty("appium");
    public static final String ANDROID_PLATFORM_NAME = "Android";
    public static final String TEST_APP = "instagram.apk";
    protected static AndroidDriver driver;

    Logger log = Logger.getLogger(AndroidBaseTest.class.getName());

    @BeforeClass
    public void setUp() {
        driver = initDriver();
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
        driver.resetApp();
    }

    private AndroidDriver initDriver() {
        try {
            driver = new AndroidDriver(new URL(APPIUM_URL), getLocalCapabilities());
            log.info("Appium url: " + APPIUM_URL);
        } catch (Exception ex) {
            throw new RuntimeException("Appium driver could not be initialized." + ex.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    private DesiredCapabilities getLocalCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Nexus_S");
        capabilities.setCapability("platformName", ANDROID_PLATFORM_NAME);
        capabilities.setCapability("app", "/Users/akliuieva/Downloads/alevel/src/main/resources/instagram.apk");
        capabilities.setCapability("autoLaunch", "false");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("appPackage", "com.instagram.android");
        capabilities.setCapability("appActivity", "com.instagram.mainactivity.MainActivity");
        // long timeout is needed for debugging purposes
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        return capabilities;
    }
}
