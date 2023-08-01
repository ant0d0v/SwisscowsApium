package tests;

import Base.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.*;
import pages.top_menu.WebPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class MainTest extends AndroidBaseTest {

    @Test
    public void testSuggestEqualsSearchCriteria(){
        MainPage mainPage = new MainPage(driver);

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
        MainPage mainPage = new MainPage(driver);
        final List<String> expectedSuggestion = List.of(
                "my images",
                "my music"
        );

        final List<String> actualSuggestion = openFirstScreen()
                .clickSearchField()
                .waitForSuggestToBeVisible()
                .getAllTextOfElementsInSuggest();

        final int actualSizeSuggest = mainPage.getAllTextOfElementsInSuggest().size();

        Assert.assertEquals(actualSizeSuggest, 2);
        Assert.assertEquals(actualSuggestion,expectedSuggestion);
        assertTrue(mainPage.suggestIsDisplayed());
        assertTrue(mainPage.iconsInSuggestAreDisplayed());
    }
    @Test
    public void testSuggestAfterSearch(){
        MainPage mainPage = new MainPage(driver);
        final List<String> expectedSuggestion = List.of(
                "my images",
                "my music",
                "ivan"
        );

        final List<String> actualSuggestion = openFirstScreen()
                .inputSearchCriteriaAndEnter("ivan")
                .waitUntilVisibilityWebResult()
                .clickSwisscowsLogo()
                .clickSearchField()
                .waitForSuggestToBeVisible()
                .getAllTextOfElementsInSuggest();

        final int actualSizeSuggest = mainPage.getAllTextOfElementsInSuggest().size();

        Assert.assertEquals(actualSizeSuggest, 3);
        Assert.assertEquals(actualSuggestion,expectedSuggestion);
        assertTrue(mainPage.suggestIsDisplayed());
        assertTrue(mainPage.iconsInSuggestAreDisplayed());
    }
    @Test
    public void testSearchWithQueryFromSuggest() {

       final String actualTextOfTitlesInWebResult = openFirstScreen()
                 .inputSearchCriteria("ivan")
                 .clickSearchField()
                 .inputSearchCriteria("ivan")
                 .waitForSuggestToBeVisible()
                 .clickFirstCriteriaInSuggestion()
                 .waitUntilVisibilityWebResult()
                 .scrollToButtonShowMoreResult()
                 .getTextSearchField();

        Assert.assertEquals(actualTextOfTitlesInWebResult, "ivana trump");
    }
}
