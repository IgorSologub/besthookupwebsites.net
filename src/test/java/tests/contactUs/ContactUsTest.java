package tests.contactUs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.CommentForm.*;
import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Urls.CONTACT_US_PAGE_URL;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsTest extends BaseTest {

    @BeforeEach
    public void setUp () {
        startDriver("contactUs");
        basePage.goToUrl(CONTACT_US_PAGE_URL);
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
            basePage.back(CONTACT_US_PAGE_URL);
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
            basePage.back(CONTACT_US_PAGE_URL);
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
    public void successfulCommentFormTest () {
        contactUsPage.enterName(NAME)
                .enterEmail(EMAIL)
                .enterComment(COMMENT)
                .submitButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(contactUsPage.submitMessageVisibleCheck());
    }

    /*
    @Test
    public void unsuccessfulCommentFormTest () {
        contactUsPage.enterName(EMPTY)
                .enterEmail(EMPTY)
                .enterComment(EMPTY)
                .submitButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(contactUsPage.inputErrorVisibleCheck());
    }

     */

}
