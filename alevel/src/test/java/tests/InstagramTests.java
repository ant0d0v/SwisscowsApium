package tests;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;

public class InstagramTests extends AndroidBaseTest {

    @Test
    public void MainScreenWithSearchTest(){
        driver.launchApp();

        GreetingsPage greetingsPage = new GreetingsPage(driver);
        assertTrue(greetingsPage.isShown());

        LoginPage loginPage = greetingsPage.proceedToLoginPage();
        assertTrue(loginPage.isShown());
        loginPage.setEmailField();
        loginPage.setPasswordField();

        MainMenuPage mainMenuPage = loginPage.performLogin();
        assertTrue(mainMenuPage.isShown());

        SearchResultPage searchResultPage = mainMenuPage.performSearch();
        assertTrue(searchResultPage.isShown());
    }

    @Test
    public void EditProfilesTest(){
        driver.launchApp();

        GreetingsPage greetingsPage = new GreetingsPage(driver);
        assertTrue(greetingsPage.isShown());

        LoginPage loginPage = greetingsPage.proceedToLoginPage();
        assertTrue(loginPage.isShown());
        loginPage.setEmailField();
        loginPage.setPasswordField();

        MainMenuPage mainMenuPage = loginPage.performLogin();
        assertTrue(mainMenuPage.isShown());

        UserProfilePage UserPage = mainMenuPage.proceedToUserProfile();
        assertTrue(UserPage.isShown());

        EditUserProfilePage EditUserPage = UserPage.proceedToEdit();
        assertTrue(EditUserPage.isShown());
    }
}
