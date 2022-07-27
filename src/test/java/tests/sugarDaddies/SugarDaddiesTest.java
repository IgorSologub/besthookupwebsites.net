package tests.sugarDaddies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reg.*;
import static constants.Constant.Reviews.*;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static constants.Constant.Urls.SUGAR_DADDIES_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SugarDaddiesTest extends BaseTest {

    @BeforeEach
    public void setUp () {
        startDriver("sugarDaddies");
        basePage.goToUrl(SUGAR_DADDIES_PAGE_URL);
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
            basePage.back(SUGAR_DADDIES_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }


    @Test
    public void footerButtonsTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= 8; i++) {
            if (i == 7) {i++; goodTitlesCount++;}
            basePage.waitOneSeconds();
            basePage.footerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(SUGAR_DADDIES_PAGE_URL);
        }
        assertEquals(8, goodTitlesCount);
    }


    @Test
    public void mainLogoLinkTest () {
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test
    public void visitSiteRegButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 4; i <= 6; i++) {
            basePage.waitOneSeconds();
            sugarDaddiesPage.visitSiteRegButtonClick(i);
            basePage.nextTab();
            basePage.waitOneMinute();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_VISIT_SITE_REG_BUTTONS_SUGAR_DADDIES_PAGE, goodTitlesCount);
    }

    @Test
    public void visitSiteRegButtonInTopSitesForSugarDatingTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_VISIT_SITE_REG_BUTTONS_IN_TOP_SITES_FOR_SUGAR_DATING_SUGAR_DADDIES_PAGE; i++) {
            basePage.waitOneSeconds();
            sugarDaddiesPage.visitSiteRegButtonInTopSitesForSugarDatingClick(i);
            basePage.nextTab();
            basePage.waitOneMinute();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_VISIT_SITE_REG_BUTTONS_IN_TOP_SITES_FOR_SUGAR_DATING_SUGAR_DADDIES_PAGE, goodTitlesCount);
    }

    @Test
    public void sendMessageRegButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_SEND_MESSAGE_REG_BUTTONS_SUGAR_DADDIES_PAGE; i++) {
            basePage.waitOneSeconds();
            sugarDaddiesPage.sendMessageRegButtonClick(i);
            basePage.nextTab();
            basePage.waitOneMinute();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_SEND_MESSAGE_REG_BUTTONS_SUGAR_DADDIES_PAGE, goodTitlesCount);
    }

    @Test
    public void loadMoreRegButtonTest () {
        basePage.waitOneSeconds();
        sugarDaddiesPage.loadMoreRegButtonClick();
        basePage.nextTab();
        basePage.waitOneMinute();
        assertTrue(basePage.checkTitles(REG_TITLES));
        basePage.waitOneSeconds();
        basePage.closeTabAndMoveToNext();
    }

    @Test
    public void addProfilesRegButtonTest () {
        basePage.waitOneSeconds();
        sugarDaddiesPage.addProfilesRegButtonClick();
        basePage.nextTab();
        basePage.waitOneMinute();
        assertTrue(basePage.checkTitles(REG_TITLES));
        basePage.waitOneSeconds();
        basePage.closeTabAndMoveToNext();
    }

    @Test
    public void startButtonTest () {
        basePage.waitOneSeconds();
        sugarDaddiesPage.startButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(sugarDaddiesPage.startButtonCheck());
    }

    @Test
    public void findSugarCityButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_FIND_SUGAR_CITIES_SUGAR_DADDIES_PAGE; i++) {
            basePage.waitOneSeconds();
            sugarDaddiesPage.findSugarCityButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(CITIES_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(SUGAR_DADDIES_PAGE_URL);
        }
        assertEquals(NUMBER_OF_FIND_SUGAR_CITIES_SUGAR_DADDIES_PAGE, goodTitlesCount);
    }

    @Test
    public void readReviewButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 4; i <= 6; i++) {
            basePage.waitOneSeconds();
            sugarDaddiesPage.readReviewButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(SUGAR_DADDIES_PAGE_URL);
        }
        assertEquals(NUMBER_OF_READ_REVIEW_SUGAR_DADDIES_PAGE, goodTitlesCount);
    }

    @Test
    public void readFullReviewButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_READ_FULL_REVIEW_SUGAR_DADDIES_PAGE; i++) {
            basePage.waitOneSeconds();
            sugarDaddiesPage.readFullReviewButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(SUGAR_DADDIES_PAGE_URL);
        }
        assertEquals(NUMBER_OF_READ_FULL_REVIEW_SUGAR_DADDIES_PAGE, goodTitlesCount);
    }

}
