package tests.base;

import common.CommonActions;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.blog.BlogPage;
import pages.blogCategory.BlogCategoryPage;
import pages.contactUs.ContactUsPage;
import pages.escort.EscortPage;
import pages.localHookup.LocalHookupPage;
import pages.main.MainPage;
import pages.review.ReviewPage;
import pages.reviewCategory.ReviewCategoryPage;
import pages.sugarDaddies.SugarDaddiesPage;

public class BaseTest {

    public BasePage basePage;
    public BlogPage blogPage;
    public BlogCategoryPage blogCategoryPage;
    public EscortPage escortPage;
    public LocalHookupPage localHookupPage;
    public MainPage mainPage;
    public ReviewPage reviewPage;
    public ReviewCategoryPage reviewCategoryPage;
    public SugarDaddiesPage sugarDaddiesPage;
    public ContactUsPage contactUsPage;

    public void startDriver (String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "main" :
            case "findHookup" :
                driver = CommonActions.createDriver("CHROME", 1024, 1366);
                break;
            case "reviewCategory" :
                driver = CommonActions.createDriver("CHROME", 360, 640);
                break;
            case "review" :
                driver = CommonActions.createDriver("CHROME", 640, 360);
                break;
            case "escort" :
                driver = CommonActions.createDriver("CHROME", 768, 1024);
                break;
            case "blogCategory" :
                driver = CommonActions.createDriver("CHROME", 1024, 768);
                break;
            case "blog" :
                driver = CommonActions.createDriver("CHROME", 1024, 1366);
                break;
            case "sugarDaddies" :
                driver = CommonActions.createDriver("CHROME", 1024, 768);
                break;
            case "hookupApps" :
                driver = CommonActions.createDriver("CHROME", 375, 667);
                break;
            case "localHookup" :
                driver = CommonActions.createDriver("CHROME", 667, 375);
                break;
            case "contactUs" :
                driver = CommonActions.createDriver("CHROME", 360, 640);
                break;
        }
        basePage = new BasePage(driver);
        mainPage = new MainPage(driver);
        blogPage = new BlogPage(driver);
        blogCategoryPage = new BlogCategoryPage(driver);
        escortPage = new EscortPage(driver);
        localHookupPage = new LocalHookupPage(driver);
        reviewPage = new ReviewPage(driver);
        reviewCategoryPage = new ReviewCategoryPage(driver);
        sugarDaddiesPage = new SugarDaddiesPage(driver);
        contactUsPage = new ContactUsPage(driver);

    }

    @AfterEach
    public void clearCookiesAndExit () {
        basePage.clearCookiesAndLocalStorageAndClose();
    }
}
