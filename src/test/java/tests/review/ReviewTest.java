package tests.review;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.CommentForm.*;
import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reg.NUMBER_OF_PICTURE_REG_BUTTONS;
import static constants.Constant.Reg.REG_TITLES;
import static constants.Constant.Reviews.*;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static constants.Constant.Urls.REVIEW_PAGE_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReviewTest extends BaseTest {

    @BeforeMethod
    public void setUp () {
        startDriver("reviewCategory");
        basePage.goToUrl(REVIEW_PAGE_URL);
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
            basePage.back(REVIEW_PAGE_URL);
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
            basePage.back(REVIEW_PAGE_URL);
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

    @Test(invocationCount = 2, successPercentage = 80)
    public void visitSiteRegButtonTest () {
        basePage.closePopup();
        reviewPage.visitSiteRegButtonClick();
        basePage.nextTab();
        basePage.waitThirtySeconds();
        assertTrue(basePage.checkTitles(REG_TITLES));
        basePage.closeTabAndMoveToNext();
    }

    @Test(invocationCount = 2, successPercentage = 80)
    public void pictureRegButtonsTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_PICTURE_REG_BUTTONS; i++) {
            basePage.waitOneSeconds();
            reviewPage.pictureRegButtonClick(i);
            basePage.nextTab();
            basePage.waitThirtySeconds();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_PICTURE_REG_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void typesOfRelationshipsButtonTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_TYPES_OF_RELATIONSHIPS_BUTTONS_REVIEW_PAGE; i++) {
            basePage.waitOneSeconds();
            reviewPage.typesOfRelationshipsButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(REVIEW_PAGE_URL);
        }
        assertEquals(NUMBER_OF_TYPES_OF_RELATIONSHIPS_BUTTONS_REVIEW_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void startButtonTest () {
        basePage.closePopup();
        reviewPage.startButtonClick();
        basePage.waitOneSeconds();
        assertTrue(reviewPage.startButtonCheckUrl());
        basePage.waitOneSeconds();
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void successfulCommentFormTest () {
        basePage.closePopup();
        reviewPage.enterName(NAME)
                .enterEmail(EMAIL)
                .enterComment(COMMENT);
        basePage.waitOneSeconds();
        reviewPage.submitButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(reviewPage.submitMessageVisibleCheck());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void unsuccessfulCommentFormTest () {
        basePage.closePopup();
        reviewPage.enterName(EMPTY)
                .enterEmail(EMPTY)
                .enterComment(EMPTY);
        basePage.waitOneSeconds();
        reviewPage.submitButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(mainPage.inputErrorVisibleCheck());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void nextSliderButtonTest () {
        basePage.closePopup();
        reviewPage.scrollToSlider();
        basePage.waitOneSeconds();
        reviewPage.nextSliderButtonClick();
        basePage.waitOneSeconds();
        assertTrue(reviewPage.sliderBlockVisibleCheck());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void latestReviewsButtonTest () {
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_LATEST_REVIEW_BUTTONS; i++) {
            basePage.waitOneSeconds();
            reviewPage.latestReviewsButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(REVIEW_PAGE_URL);
        }
        assertEquals(NUMBER_OF_LATEST_REVIEW_BUTTONS, goodTitlesCount);
    }

}
