package pages.blog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class BlogPage extends BasePage {

    public BlogPage (WebDriver driver) {super(driver);}

    private final By authorButton = By.xpath("//a[@class='dFej3BqyKZqD']");
    private final By nameInput = By.xpath("//input[@id='author']");
    private final By emailInput= By.xpath("//input[@id='email']");
    private final By commentIInput = By.xpath("//textarea[@id='comment']");
    private final By submitButton = By.xpath("//button[@class='gP70WUzIlX']");
    private final By submitMessage = By.xpath("//div[@id='form-message']");
    private final By nextSliderButton = By.xpath("//button[@class='js-sites-next-sm slick-next slick-arrow']");
    private final By sliderBlock = By.xpath("(//div[@class='OdbTEQXt'])[8]");
    private final By scrollToSlider = By.xpath("(//h2[@class='GCVlCBwtX'])[9]");

    public BlogPage topPostBlogButtonClick (int numButton) {
        By blogButton = By.xpath("(//a[@class='iEYimdnO'])[" + numButton + "]");
        driver.findElement(blogButton).click();
        return this;
    }

    public BlogPage topPostButtonClick (int numButton) {
        By topPostButton = By.xpath("(//a[@class='DXrz_'])[" + numButton + "]");
        driver.findElement(topPostButton).click();
        return this;
    }

    public BlogPage authorButtonClick () {
        driver.findElement(authorButton).click();
        return this;
    }

    public Boolean authorUrlCheck () {
        boolean result = false;
        if (driver.getTitle().contains("Isabelle")) {
            result = true;
        }
        return result;
    }

    public BlogPage enterName (String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public BlogPage enterEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public BlogPage enterComment (String comment) {
        driver.findElement(commentIInput).sendKeys(comment);
        return this;
    }

    public BlogPage submitButtonClick () {
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
        boolean errorsCheck = driver.findElements(By.xpath("//*[@class='ciBsMTK3Kl error']")).size() == 3;
        if (!errorsCheck) {
            waitOneSeconds();
            submitButtonClick();
            waitFiveSeconds();
            errorsCheck = driver.findElements(submitMessage).size() == 3;
        }
        return errorsCheck;
    }

    public BlogPage nextSliderButtonClick () {
        driver.findElement(nextSliderButton).click();
        return this;
    }

    public Boolean sliderBlockVisibleCheck () {
        return elementVisibleCheck(sliderBlock);
    }

    public BlogPage scrollToSlider () {
        scrollToElement(scrollToSlider);
        return this;
    }

}
