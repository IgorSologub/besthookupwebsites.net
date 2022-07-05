package pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {super(driver);}

    private final By learnMoreRegButton = By.xpath("//a[contains(@class,'gP70WUzIlX A3U9LrZBmhvH')]");
    private final By loadMoreButton = By.xpath("//button[@class='VrGB7Bp vDem2WzgPNOq js-showner-more js-showner-sortgroups']");
    private final By cityNameText = By.xpath("//div[normalize-space()='Chicago']");
    private final By nameInput = By.xpath("//input[@id='author']");
    private final By emailInput= By.xpath("//input[@id='email']");
    private final By commentIInput = By.xpath("//textarea[@id='comment']");
    private final By submitButton = By.xpath("//button[@class='gP70WUzIlX']");
    private final By submitMessage = By.xpath("//div[@id='form-message']");
    private final By nextBlogSliderButton = By.xpath("//button[@class='js-articles-next-lg slick-next slick-arrow']");
    private final By blogSlide = By.xpath("(//div[@class='nnMZcumvH'])[5]");
    private final By scrollToBlogSlider = By.xpath("(//h2[@class='GCVlCBwtX'])[6]");

    public MainPage changeLanguageButtonClick (int numButton) {
        By changeLanguageButton = By.xpath("(//span[@class='wpml-ls-native'])[" + numButton + "]");
        driver.findElement(changeLanguageButton).click();
        return this;
    }

    public MainPage learnMoreRegButtonClick () {
        driver.findElement(learnMoreRegButton).click();
        return this;
    }

    public MainPage downloadAppRegButtonClick (int numButton) {
        By downloadAppRegButton = By.xpath("(//a[contains(@class,'gP70WUzIlX iAGmbz')])[" + numButton + "]");
        driver.findElement(downloadAppRegButton).click();
        return this;
    }

    public MainPage readReviewButtonClick (int numButton) {
        By readReviewButton = By.xpath("(//a[@class='lVjPz11EHlZ'])[" + numButton + "]");
        driver.findElement(readReviewButton).click();
        return this;
    }

    public MainPage readArticleButtonClick (int numButton) {
        By readArticle = By.xpath("(//a[@class='UeqIxG'])[" + numButton + "]");
        driver.findElement(readArticle).click();
        return this;
    }

    public MainPage loadMoreButtonClick () {
        driver.findElement(loadMoreButton).click();
        return this;
    }

    public Boolean cityNameTextVisibleCheck () {
        return elementVisibleCheck(cityNameText);
    }

    public MainPage faqCollapseButtonClick (int numButton) {
        By faqButton = By.xpath("(//div[@class='OqhP_G8IaDg'])[" + numButton + "]");
        driver.findElement(faqButton).click();
        return this;
    }

    public Boolean faqTextVisibleCheck (int numButton) {
        By faqText = By.xpath("(//div[@class='iknsDjftcPJW'])[" + numButton + "]");
        return driver.findElement(faqText).isDisplayed();
    }

    public MainPage enterName (String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public MainPage enterEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public MainPage enterComment (String comment) {
        driver.findElement(commentIInput).sendKeys(comment);
        return this;
    }

    public MainPage submitButtonClick () {
        driver.findElement(submitButton).click();
        return this;
    }

    public Boolean submitMessageVisibleCheck () {
        boolean isVisible = driver.findElements(submitMessage).size() > 0;
        if (!isVisible) {
            waitOneSeconds();
            submitButtonClick();
            waitFiveSeconds();
            isVisible = driver.findElements(submitMessage).size() > 0;
        }
        return isVisible;
    }


    public Boolean inputErrorVisibleCheck () {
        boolean errorsCheck = driver.findElements(By.xpath("//*[@class='NYwIqTgOkCM error']")).size() == 3;
        if (!errorsCheck) {
            waitOneSeconds();
            submitButtonClick();
            waitFiveSeconds();
            errorsCheck = driver.findElements(submitMessage).size() == 3;
        }
        return errorsCheck;
    }

    public MainPage scrollToBlogSlider () {
        scrollToElement(scrollToBlogSlider);
        return this;
    }

    public MainPage nextBlogSliderButtonClick () {
        driver.findElement(nextBlogSliderButton).click();
        return this;
    }

    public Boolean blogSliderVisibleCheck () {
        return elementVisibleCheck(blogSlide);
    }

}
