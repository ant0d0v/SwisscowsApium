package tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.top_menu.ImagePage;
import pages.top_menu.MusicPage;
import utils.ProjectConstants;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTest {

    @Test
    public void testSuggestEqualsSearchCriteria(){
        MainPage mainPage = new MainPage(androidDriver);

        final List<String> actualSuggestion = openFirstScreen()
                .inputSearchCriteria("ivan")
                .clickSearchField()
                .inputSearchCriteria("ivan")
                .waitForSuggestToBeVisible()
                .getAllTextOfElementsInSuggest();

        final int actualSizeSuggest = mainPage.getAllTextOfElementsInSuggest().size();

        for (String searchCriteria : actualSuggestion) {
            assertTrue(actualSizeSuggest >= 5 );
            assertTrue(searchCriteria.contains("ivan"));
        }
            assertTrue(mainPage.suggestIsDisplayed());
    }
    @Test
    public void testNothingIsInSuggestAfterInstallationApp(){
        MainPage mainPage = new MainPage(androidDriver);
        final List<String> expectedSuggestion = List.of(
                "my images",
                "my music"
        );

        final List<String> actualSuggestion = openFirstScreen()
                .clickSearchField()
                .waitForSuggestToBeVisible()
                .getAllTextOfElementsInSuggest();

        final int actualSizeSuggest = mainPage.getAllTextOfElementsInSuggest().size();

        assertEquals(actualSizeSuggest, 2);
        assertEquals(actualSuggestion,expectedSuggestion);
        assertTrue(mainPage.suggestIsDisplayed());
        assertTrue(mainPage.iconsInSuggestAreDisplayed());
    }
    @Test
    public void testSuggestAfterSearch(){
        MainPage mainPage = new MainPage(androidDriver);
        final List<String> expectedSuggestion = List.of(
                "my images",
                "my music",
                "ivan"
        );

        final List<String> actualSuggestion = openFirstScreen()
                .clickSearchField()
                .inputSearchCriteria("ivan")
                .clickEnterForAndroid()
                .waitUntilVisibilityWebResult()
                .clickSwisscowsLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible()
                .getAllTextOfElementsInSuggest();

        final int actualSizeSuggest = mainPage.getAllTextOfElementsInSuggest().size();

        assertEquals(actualSizeSuggest, 3);
        assertEquals(actualSuggestion,expectedSuggestion);
        assertTrue(mainPage.suggestIsDisplayed());
        assertTrue(mainPage.iconsInSuggestAreDisplayed());
    }
    @Test
    public void testSearchWithQueryFromSuggest() {

       final String actualTextInSearchResult = openFirstScreen()
                 .inputSearchCriteria("ivan")
                 .clickSearchField()
                 .inputSearchCriteria("ivan")
                 .waitForSuggestToBeVisible()
                 .clickFirstCriteriaInSuggestion()
                 .waitUntilVisibilityWebResult()
                 .getTextSearchField();

        assertEquals(actualTextInSearchResult, "ivana trump");
    }
    @Test
    public void testMyMusicQueryFromSuggestRedirectToCorrespondingScreen() {

        final String actualTextInSearchResult = openFirstScreen()
                .clickSearchField()
                .waitForSuggestToBeVisible()
                .clickMyMusicInSuggestion()
                .waitUntilToBeVisibleErrorImageNoTrack()
                .getTextSearchField();

        assertEquals(actualTextInSearchResult, "My music");
        assertTrue(new MusicPage(androidDriver).errorImage_NoTracks_IsDisplayed());
    }
    @Test
    public void testMyImagesQueryFromSuggestRedirectToCorrespondingScreen() {

        final String actualTextInSearchResult = openFirstScreen()
                .clickSearchField()
                .waitForSuggestToBeVisible()
                .clickMyImagesInSuggestion()
                .waitUntilToBeVisibleErrorImageNoImage()
                .getTextSearchField();

        assertTrue(new ImagePage(androidDriver).errorImage_NoImage_IsDisplayed());
        assertEquals(actualTextInSearchResult, "My images");
    }
    @Test
    public void testSearchWithQueryFromRecent() {

        final String actualTextInSearchResult  = openFirstScreen()
                .clickSearchField()
                .inputSearchCriteria("ivan")
                .clickEnterForAndroid()
                .waitUntilVisibilityWebResult()
                .clickSwisscowsLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible()
                .clickRecentSearchesInSuggestion()
                .waitUntilVisibilityWebResult()
                .getTextSearchField();;

        assertEquals(actualTextInSearchResult,"ivan");
    }
    @Test
    public void testPlaceholderOfSearchField() {
        MainPage mainPage = new MainPage(androidDriver);

        final String actualTextOfPlaceholder = openFirstScreen()
                .getTextOfPlaceholder();

        Assert.assertTrue(mainPage.loginButtonIsDisplayed());
        Assert.assertTrue(mainPage.logoSwisscowsIsDisplayed());
        assertEquals(actualTextOfPlaceholder, "Search...");
    }
    @Test
    public void testLoginToAccountUsingLoginIcon() {
        MainPage mainPage = new MainPage(androidDriver);

         openFirstScreen()
                .clickLoginIcon()
                .loginToAccount(ProjectConstants.SWISSCOWS_EMAIL_USER,ProjectConstants.PASSWORD)
                .waitForAvatarOnMainScreenToBeVisible();

         assertTrue(mainPage.avatarIsDisplayed() );
    }
    @Test
    public void testOpenUserProfileAfterLoginToAccount() {

        final String actualTitle = openFirstScreen()
                .clickLoginIcon()
                .loginToAccount(ProjectConstants.SWISSCOWS_EMAIL_USER,ProjectConstants.PASSWORD)
                .waitForAvatarOnMainScreenToBeVisible()
                .clickLoginIconAfterLoggingIn()
                .getTitleProfile();

        assertEquals(actualTitle, "Your Profile");
    }
}
