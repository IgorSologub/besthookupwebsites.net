package pages.blogCategory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class BlogCategoryPage extends BasePage {

    public BlogCategoryPage (WebDriver driver) {super(driver);}

    public BlogCategoryPage blogPostClick (int numButton) {
        By blogPost = By.xpath("(//a[@class='bIgc6J6S870'])[" + numButton + "]");
        driver.findElement(blogPost).click();
        return this;
    }

    public BlogCategoryPage topPostBlogButtonClick (int numButton) {
        By blogButton = By.xpath("(//a[@class='iEYimdnO'])[" + numButton + "]");
        driver.findElement(blogButton).click();
        return this;
    }

    public BlogCategoryPage topPostButtonClick (int numButton) {
        By topPostButton = By.xpath("(//a[@class='DXrz_'])[" + numButton + "]");
        driver.findElement(topPostButton).click();
        return this;
    }

}
