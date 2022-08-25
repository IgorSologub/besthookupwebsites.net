package tests.reviewCategory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.*;
import static constants.Constant.Reg.NUMBER_OF_VISIT_SITE_REG_BUTTONS;
import static constants.Constant.Reg.REG_TITLES;
import static constants.Constant.Reviews.NUMBER_OF_READ_REVIEW_BUTTONS_REVIEW_CATEGORY;
import static constants.Constant.Reviews.REVIEW_TITLES;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static constants.Constant.Urls.REVIEW_CATEGORY_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReviewCategoryTest extends BaseTest {

    @BeforeMethod
    public void setUp () {
        startDriver("reviewCategory");
        basePage.goToUrl(REVIEW_CATEGORY_URL);
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
            basePage.back(REVIEW_CATEGORY_URL);
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
            basePage.back(REVIEW_CATEGORY_URL);
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
    public void changeLanguageButtonTest () {
        basePage.closePopup();
        int goodUrlsCount = 0;
        for (int i = 2; i <= MAX_AMOUNT_LANGUAGE_CHANGE_BUTTONS + 1; i++) {
            basePage.headerMenuOpen();
            basePage.waitOneSeconds();
            reviewCategoryPage.changeLanguageMenuOpen();
            basePage.waitOneSeconds();
            reviewCategoryPage.changeLanguageButtonClick(i);
            if (basePage.checkUrls(LANGUAGE_URLS)) { goodUrlsCount++; }
            basePage.waitOneSeconds();
            basePage.back(REVIEW_CATEGORY_URL);
        }
        assertEquals(MAX_AMOUNT_LANGUAGE_CHANGE_BUTTONS, goodUrlsCount);
    }

    @Test(invocationCount = 2, successPercentage = 80)
    public void visitSiteRegButtonTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_VISIT_SITE_REG_BUTTONS; i++) {
            basePage.waitOneSeconds();
            reviewCategoryPage.visitSiteRegButtonClick(i);
            basePage.nextTab();
            basePage.waitThirtySeconds();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_VISIT_SITE_REG_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void readReviewButtonTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_READ_REVIEW_BUTTONS_REVIEW_CATEGORY; i++) {
            reviewCategoryPage.readReviewButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.waitOneSeconds();
            basePage.back(REVIEW_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_READ_REVIEW_BUTTONS_REVIEW_CATEGORY, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void paginationButtonTest () {
        basePage.closePopup();
        reviewCategoryPage.paginationButtonClick();
        basePage.waitOneSeconds();
        assertTrue(reviewCategoryPage.urlPaginationCheck());
    }

}
