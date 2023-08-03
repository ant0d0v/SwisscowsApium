package Base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class IOSBaseUtils {
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static final String IOS_PLATFORM_NAME = "iOS";
    private static final Logger log = Logger.getLogger(BaseTest.class.getName());


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
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "16.4");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("bundleId", "com.swisscows.search");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("automationName", "XCUITest");
        return capabilities;
    }
}
