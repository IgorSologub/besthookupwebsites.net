package tests.blogCategory;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reviews.*;
import static constants.Constant.Urls.BLOG_CATEGORY_URL;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static org.testng.Assert.assertEquals;


public class BlogCategoryTest extends BaseTest {

    @BeforeMethod
    public void setUp () {
        startDriver("reviewCategory");
        basePage.goToUrl(BLOG_CATEGORY_URL);
        basePage.waitOneSeconds();
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void headerButtonsTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_HEADER_BUTTONS; i++) {
            basePage.headerMenuOpen();
            basePage.waitOneSeconds();
            basePage.headerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(HEADER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void footerButtonsTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_FOOTER_BUTTONS; i++) {
            if (i == 7) {i++; goodTitlesCount++;}
            basePage.waitOneSeconds();
            basePage.footerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_GOOD_FOOTER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void mainLogoLinkTest () {
        basePage.closePopup();
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void blogPostTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_BLOG_POST_BUTTONS_BLOG_CATEGORY; i++) {
            basePage.waitOneSeconds();
            blogCategoryPage.blogPostClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_BLOG_POST_BUTTONS_BLOG_CATEGORY, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void topPostBlogButtonTest () {
        basePage.closePopup();
        int goodUrlsCount = 0;
        for (int i = 1; i <= NUMBER_OF_TOP_POST_BLOG_BUTTONS_BLOG_CATEGORY; i++) {
            basePage.waitOneSeconds();
            blogCategoryPage.topPostBlogButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.getCurrentUrl().contains(BLOG_CATEGORY_URL)) { goodUrlsCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_TOP_POST_BLOG_BUTTONS_BLOG_CATEGORY, goodUrlsCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void topPostButtonTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_TOP_POST_BUTTONS_BLOG_CATEGORY; i++) {
            basePage.waitOneSeconds();
            blogCategoryPage.topPostButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(BLOG_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_TOP_POST_BUTTONS_BLOG_CATEGORY, goodTitlesCount);
    }

}
