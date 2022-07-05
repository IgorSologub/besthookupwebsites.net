package tests.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Common.NUMBER_OF_FAQ_COLLAPSE_BUTTONS;
import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.*;
import static constants.Constant.Reg.NUMBER_OF_DOWNLOAD_APP_REG_BUTTONS;
import static constants.Constant.Reg.REG_TITLES;
import static constants.Constant.Reviews.*;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {

    @BeforeEach
    public void setUp () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
        basePage.waitOneSeconds();
        basePage.closePopup();
    }

    @Test
    public void headerButtonsTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_HEADER_BUTTONS; i++) {
            basePage.headerMenuOpen();
            basePage.waitOneSeconds();
            basePage.headerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(HEADER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test
    public void footerButtonsTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_FOOTER_BUTTONS; i++) {
            if (i == 7) {i++; goodTitlesCount++;}
            basePage.waitOneSeconds();
            basePage.footerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_FOOTER_BUTTONS, goodTitlesCount);
    }

    @Test
    public void mainLogoLinkTest () {
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test
    public void changeLanguageButtonTest () {
        int goodUrlsCount = 0;
        for (int i = 2; i <= MAX_AMOUNT_LANGUAGE_CHANGE_BUTTONS + 1; i++) {
            basePage.waitOneSeconds();
            basePage.headerMenuOpen();
            basePage.waitOneSeconds();
            basePage.languageMenuOpen();
            basePage.waitOneSeconds();
            mainPage.changeLanguageButtonClick(i);
            if (basePage.checkUrls(LANGUAGE_URLS)) { goodUrlsCount++; }
            basePage.waitOneSeconds();
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(MAX_AMOUNT_LANGUAGE_CHANGE_BUTTONS, goodUrlsCount);
    }

    @Test
    public void learnMoreRegButtonTest () {
        mainPage.learnMoreRegButtonClick();
        basePage.nextTab();
        basePage.waitOneMinute();
        assertTrue(basePage.checkTitles(REG_TITLES));
        basePage.closeTabAndMoveToNext();
    }

    @Test
    public void downloadAppRegButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_DOWNLOAD_APP_REG_BUTTONS; i++) {
            basePage.waitOneSeconds();
            mainPage.downloadAppRegButtonClick(i);
            basePage.nextTab();
            basePage.waitOneMinute();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_DOWNLOAD_APP_REG_BUTTONS, goodTitlesCount);
    }

    @Test
    public void readReviewButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_READ_REVIEW_BUTTONS_MAIN_PAGE; i++) {
            basePage.waitOneSeconds();
            mainPage.readReviewButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_READ_REVIEW_BUTTONS_MAIN_PAGE, goodTitlesCount);
    }

    @Test
    public void readArticleButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_READ_ARTICLE_BUTTONS_MAIN_PAGE; i++) {
            basePage.waitOneSeconds();
            mainPage.readArticleButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(AUTHORS_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_READ_ARTICLE_BUTTONS_MAIN_PAGE, goodTitlesCount);
    }

    @Test
    public void loadMoreButtonTest () {
        mainPage.loadMoreButtonClick();
        basePage.waitOneSeconds();
        mainPage.loadMoreButtonClick();
        basePage.waitOneSeconds();
        assertTrue(mainPage.cityNameTextVisibleCheck());
    }

    @Test
    public void faqButtonTest () {
        int visibleTextCount = 0;
        for (int i = 1; i <= NUMBER_OF_FAQ_COLLAPSE_BUTTONS; i++) {
            basePage.waitOneSeconds();
            mainPage.faqCollapseButtonClick(i);
            basePage.waitOneSeconds();
            if (mainPage.faqTextVisibleCheck(i)) { visibleTextCount++; }
        }
        assertEquals(NUMBER_OF_FAQ_COLLAPSE_BUTTONS, visibleTextCount);
    }

    @Test
    public void blogSliderTest () {
        mainPage.scrollToBlogSlider();
        mainPage.nextBlogSliderButtonClick();
        basePage.waitOneSeconds();
        assertTrue(mainPage.blogSliderVisibleCheck());
    }

}
