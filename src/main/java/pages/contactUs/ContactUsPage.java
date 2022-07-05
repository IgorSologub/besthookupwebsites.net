package pages.contactUs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ContactUsPage extends BasePage {

    public ContactUsPage (WebDriver driver) {super(driver);}

    private final By nameInput = By.xpath("//input[@id='author']");
    private final By emailInput= By.xpath("//input[@id='email']");
    private final By commentIInput = By.xpath("//textarea[@id='comment']");
    private final By submitButton = By.xpath("//button[@class='gP70WUzIlX']");
    private final By submitMessage = By.xpath("//div[@class='submit-message']");

    public ContactUsPage enterName (String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public ContactUsPage enterEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public ContactUsPage enterComment (String comment) {
        driver.findElement(commentIInput).sendKeys(comment);
        return this;
    }

    public ContactUsPage submitButtonClick () {
        driver.findElement(submitButton).click();
        return this;
    }

    public Boolean submitMessageVisibleCheck () {
        boolean isVisible = driver.findElements(submitMessage).size() == 1;
        if (!isVisible) {
            waitOneSeconds();
            submitButtonClick();
            waitFiveSeconds();
            isVisible = driver.findElements(submitMessage).size() == 1;
        }
        return isVisible;
    }


    public Boolean inputErrorVisibleCheck () {
        boolean errorsCheck = driver.findElements(By.xpath("//input[@class='NYwIqTgOkCM error']")).size() == 2;
        if (!errorsCheck) {
            waitOneSeconds();
            submitButtonClick();
            waitFiveSeconds();
            errorsCheck = driver.findElements(By.xpath("//input[@class='NYwIqTgOkCM error']")).size() == 2;
        }
        return errorsCheck;
    }

}
