package Base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class AndroidBaseUtils {
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static final String ANDROID_PLATFORM_NAME = "Android";
    private static final String TEST_APP = "instagram.apk";
    private static final Logger log = Logger.getLogger(AndroidBaseTest.class.getName());

    public static String getAppiumUrl() {
        return APPIUM_URL;
    }

    static AndroidDriver initDriver(AndroidDriver driver) {
        try {
            driver = new AndroidDriver(new URL(APPIUM_URL), getLocalCapabilities());
            log.info("Appium url: " + APPIUM_URL);
        } catch (Exception ex) {
            throw new RuntimeException("Appium driver could not be initialized." + ex.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }


    private static DesiredCapabilities getLocalCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Pixel_3a");
        capabilities.setCapability("platformName", ANDROID_PLATFORM_NAME);
        capabilities.setCapability("app", "/Users/antonudovycenko/IdeaProjects/AppiumInstagramDemo/alevel/src/test/resources/" + TEST_APP);
        capabilities.setCapability("autoLaunch", "false");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("appPackage", "com.instagram.android");
        capabilities.setCapability("appActivity", "com.instagram.mainactivity.MainActivity");
        // long timeout is needed for debugging purposes
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        return capabilities;
    }
}
