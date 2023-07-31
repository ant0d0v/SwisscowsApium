package tests;

import Base.AndroidBaseTest;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class InstagramTests extends AndroidBaseTest {

    @Test
    public void MainScreenWithSearchTest(){

       openFirstScreen();

        assertTrue(new MainMenuPage(getAndroidDriver()).isShown());
    }
}
