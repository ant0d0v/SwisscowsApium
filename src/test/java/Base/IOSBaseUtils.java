package Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class IOSBaseUtils {
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static final String USERNAME = "oauth-gosu1203-b638e";
    //    private static final String ACCESS_KEY = "d12a01b0-33d2-4575-80ae-5a0817a307e2";
//    private static final String APPIUM_URL = "https://" + USERNAME + ":" + ACCESS_KEY
//            + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    private static final String ANDROID_PLATFORM_NAME = "IOS";
    private static final String TEST_APP = "instagram.apk";
    private static final Logger log = Logger.getLogger(BaseTest.class.getName());

    public static String getAppiumUrl() {
        return APPIUM_URL;
    }

    static IOSDriver initDriver(IOSDriver driver) {
        try {
            driver = new IOSDriver(new URL(APPIUM_URL), getLocalCapabilities());
            log.info("Appium url: " + APPIUM_URL);
        } catch (Exception ex) {
            throw new RuntimeException("Appium driver could not be initialized." + ex.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    public static void logf(String str, Object... arr) {
        System.out.printf(str, arr);
        System.out.println();
    }


    private static DesiredCapabilities getLocalCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_3a");
        capabilities.setCapability("platformName", ANDROID_PLATFORM_NAME);
        capabilities.setCapability("autoLaunch", "false");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("appPackage", "com.swisscows.search");
        capabilities.setCapability("appActivity", "com.swisscows.search.MainActivity");
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("waitForIdleTimeout", 0);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        return capabilities;
    }

    private static DesiredCapabilities getSourceLabsCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appiumVersion", "1.22.3");
        capabilities.setCapability("deviceName", "Galaxy S10 WQHD GoogleAPI Emulator");
        capabilities.setCapability("platformName", ANDROID_PLATFORM_NAME);
        capabilities.setCapability("app", "storage:filename=" + TEST_APP);
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("autoLaunch", "false");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.instagram.android");
        capabilities.setCapability("appActivity", "com.instagram.mainactivity.MainActivity");
        return capabilities;
    }

    public static DesiredCapabilities getRealDeviceCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy S10");
        capabilities.setCapability("platformName", ANDROID_PLATFORM_NAME);
        capabilities.setCapability("autoLaunch", "false");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("appPackage", "com.swisscows.search");
        capabilities.setCapability("appActivity", "com.swisscows.search.MainActivity");
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("waitForIdleTimeout", 0);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
//        capabilities.setCapability("uiautomator2ServerInstallTimeout", 60000);
        return capabilities;
    }


}
