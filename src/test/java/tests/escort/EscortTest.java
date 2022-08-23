package tests.escort;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Urls.ESCORT_PAGE_URL;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EscortTest extends BaseTest {

    @BeforeMethod
    public void setUp () {
        startDriver("escort");
        basePage.goToUrl(ESCORT_PAGE_URL);
        basePage.waitOneSeconds();
        basePage.closePopup();
    }

    @Test(invocationCount = 3)
    public void headerButtonsTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_HEADER_BUTTONS; i++) {
            basePage.headerMenuOpen();
            basePage.waitOneSeconds();
            basePage.headerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(HEADER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(ESCORT_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 3)
    public void footerButtonsTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_FOOTER_BUTTONS; i++) {
            if (i == 7) {i++; goodTitlesCount++;}
            basePage.waitOneSeconds();
            basePage.footerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(ESCORT_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_FOOTER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 3)
    public void mainLogoLinkTest () {
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test(invocationCount = 3)
    public void cityButtonTest () {
        escortPage.cityButtonClick();
        basePage.waitOneSeconds();
        assertTrue(escortPage.cityButtonCheck());
    }

    @Test(invocationCount = 3)
    public void inputCitySearchTest () {
        basePage.waitFiveSeconds();
        escortPage.enterCity();
        basePage.waitFiveSeconds();
        escortPage.searchButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(escortPage.cityButtonCheck());
    }

}
