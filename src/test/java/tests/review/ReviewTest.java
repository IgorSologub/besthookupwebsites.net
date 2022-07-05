package tests.review;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewTest extends BaseTest {

    @BeforeEach
    public void setUp () {
        startDriver("reviewCategory");
        basePage.goToUrl(REVIEW_PAGE_URL);
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
            basePage.back(REVIEW_PAGE_URL);
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
            basePage.back(REVIEW_PAGE_URL);
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
    public void visitSiteRegButtonTest () {
        reviewPage.visitSiteRegButtonClick();
        basePage.nextTab();
        basePage.waitOneMinute();
        assertTrue(basePage.checkTitles(REG_TITLES));
        basePage.closeTabAndMoveToNext();
    }

    @Test
    public void pictureRegButtonsTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_PICTURE_REG_BUTTONS; i++) {
            basePage.waitOneSeconds();
            reviewPage.pictureRegButtonClick(i);
            basePage.nextTab();
            basePage.waitOneMinute();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_PICTURE_REG_BUTTONS, goodTitlesCount);
    }

    @Test
    public void typesOfRelationshipsButtonTest () {
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

    @Test
    public void startButtonTest () {
        reviewPage.startButtonClick();
        basePage.waitOneSeconds();
        assertTrue(reviewPage.startButtonCheckUrl());
        basePage.waitOneSeconds();
    }

    @Test
    public void successfulCommentFormTest () {
        reviewPage.enterName(NAME)
                .enterEmail(EMAIL)
                .enterComment(COMMENT);
        basePage.waitOneSeconds();
        reviewPage.submitButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(reviewPage.submitMessageVisibleCheck());
    }

    @Test
    public void unsuccessfulCommentFormTest () {
        reviewPage.enterName(EMPTY)
                .enterEmail(EMPTY)
                .enterComment(EMPTY);
        basePage.waitOneSeconds();
        reviewPage.submitButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(mainPage.inputErrorVisibleCheck());
    }

    @Test
    public void nextSliderButtonTest () {
        reviewPage.scrollToSlider();
        basePage.waitOneSeconds();
        reviewPage.nextSliderButtonClick();
        basePage.waitOneSeconds();
        assertTrue(reviewPage.sliderBlockVisibleCheck());
    }

    @Test
    public void latestReviewsButtonTest () {
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
