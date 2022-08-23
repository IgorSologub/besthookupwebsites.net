package tests.localHookup;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reg.*;
import static constants.Constant.Reviews.*;
import static constants.Constant.Urls.LOCAL_HOOKUP_URL;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LocalHookupTest extends BaseTest {

    @BeforeMethod
    public void setUp () {
        startDriver("localHookup");
        basePage.goToUrl(LOCAL_HOOKUP_URL);
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
            basePage.back(LOCAL_HOOKUP_URL);
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
            basePage.back(LOCAL_HOOKUP_URL);
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
    public void learnMoreButtonTest () {
        basePage.waitOneSeconds();
        localHookupPage.learnMoreButtonClick();
        basePage.nextTab();
        basePage.waitThirtySeconds();
        assertTrue(basePage.checkTitles(REG_TITLES));
        basePage.waitOneSeconds();
        basePage.closeTabAndMoveToNext();
    }

    @Test(invocationCount = 3)
    public void loadMoreButtonTest () {
        basePage.waitOneSeconds();
        localHookupPage.loadMoreButtonClick();
        basePage.waitFiveSeconds();
        localHookupPage.loadMoreButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(localHookupPage.cityBlockCheck());
    }

    @Test(invocationCount = 3)
    public void visitSiteButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_VISIT_SITE_REG_BUTTONS_LOCAL_HOOKUP_PAGE; i++) {
            basePage.waitOneSeconds();
            localHookupPage.visitSiteButtonClick(i);
            basePage.nextTab();
            basePage.waitThirtySeconds();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_VISIT_SITE_REG_BUTTONS_LOCAL_HOOKUP_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 3)
    public void readReviewButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_RED_REVIEW_LOCAL_HOOKUP_PAGE; i++) {
            basePage.waitOneSeconds();
            localHookupPage.readReviewButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(LOCAL_HOOKUP_URL);
        }
        assertEquals(NUMBER_OF_RED_REVIEW_LOCAL_HOOKUP_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 3)
    public void latestNewsButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_LATEST_REVIEW_BUTTONS; i++) {
            basePage.waitOneSeconds();
            localHookupPage.latestNewsButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(LOCAL_HOOKUP_URL);
        }
        assertEquals(NUMBER_OF_LATEST_REVIEW_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 3)
    public void loadMoreReviewButtonTest () {
        basePage.waitOneSeconds();
        localHookupPage.loadMoreReviewButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(localHookupPage.reviewBlockCheck());
    }

    @Test(invocationCount = 3)
    public void visitSiteInTextButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_VISIT_SITE_IN_TEXT_REG_BUTTON; i++) {
            basePage.waitOneSeconds();
            localHookupPage.visitSiteInTextButtonClick(i);
            basePage.nextTab();
            basePage.waitThirtySeconds();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            basePage.waitOneSeconds();
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_VISIT_SITE_IN_TEXT_REG_BUTTON, goodTitlesCount);
    }

    @Test(invocationCount = 3)
    public void readFullReviewButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_READ_FULL_REVIEW_LOCAL_HOOKUP_PAGE; i++) {
            basePage.waitOneSeconds();
            localHookupPage.readFullReviewButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(LOCAL_HOOKUP_URL);
        }
        assertEquals(NUMBER_OF_READ_FULL_REVIEW_LOCAL_HOOKUP_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 3)
    public void faqCollapseButtonTest () {
        basePage.waitOneSeconds();
        localHookupPage.faqCollapseButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(localHookupPage.faqCollapseTextCheck());
    }

    @Test(invocationCount = 3)
    public void articlesButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_ARTICLES_LOCAL_HOOKUP_PAGE; i++) {
            basePage.waitOneSeconds();
            localHookupPage.articlesButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(LOCAL_HOOKUP_URL);
        }
        assertEquals(NUMBER_OF_ARTICLES_LOCAL_HOOKUP_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 3)
    public void authorButtonTest () {
        basePage.waitOneSeconds();
        localHookupPage.authorButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(localHookupPage.authorCheck());
    }

    @Test(invocationCount = 3)
    public void blogSliderTest () {
        localHookupPage.scrollToBlogSlider();
        basePage.waitOneSeconds();
        localHookupPage.nextBlogSliderButtonClick();
        basePage.waitOneSeconds();
        assertTrue(localHookupPage.blogSliderVisibleCheck());
    }

}
