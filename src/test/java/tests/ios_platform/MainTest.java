package tests.ios_platform;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTest {
    @Test

    public void testSuggestEqualsSearchCriteria(){
        MainPage mainPage = new MainPage(iosDriver);

        openFirstScreenOnIOS();
    }
}
