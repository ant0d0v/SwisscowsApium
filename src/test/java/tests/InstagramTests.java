package tests;

import Base.AndroidBaseTest;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class InstagramTests extends AndroidBaseTest {

    @Test
    public void MainScreenWithSearchTest(){
        LoginPage loginPage = new LoginPage(getAndroidDriver());

       openFirstScreen().isShown();
       loginPage
               .proceedToLoginPage()
               .setEmailField()
               .clickPasswordField()
               .setPasswordField()
               .loginButton();

        assertTrue(new MainMenuPage(getAndroidDriver()).isShown());
    }
}