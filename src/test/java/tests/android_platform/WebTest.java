package tests.android_platform;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base_abstract.BasePage;
import pages.top_menu.WebPage;

import static org.testng.Assert.assertEquals;

public class WebTest extends BaseTest {
    @Test
    public void testOpenSearchResultAsAnonymousPreview() {
        WebPage webPage = new WebPage(androidDriver);

        openFirstScreen()
                .clickSearchField()
                .inputSearchCriteria("ivan")
                .clickEnterForAndroid()
                .waitUntilVisibilityWebResult()
                .holdThreeSecond()
                .waitUntilVisibilityImageInPreview()
                .clickOpenButtonInWebPreview();

        Assert.assertTrue(webPage.getTextSearchField().contains("wikipedia"));
        Assert.assertTrue(webPage.headerSwisscowsAppIsDisplayed());
    }
    @Test
    public void testOpenYoutubeVideoInWidgetRedirectToCorrespondingApp() {
        WebPage webPage = new WebPage(androidDriver);

        openFirstScreen()
                .clickSearchField()
                .inputSearchCriteria("iphone video")
                .clickEnterForAndroid()
                .waitUntilVisibilityWebResult()
                .clickFirstVideoInWidget();
    }
}
