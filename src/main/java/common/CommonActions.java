package common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver (String browser, int width, int height) {
        WebDriver driver = null;
        switch (browser) {
            case "CHROME" :
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Igor\\Desktop\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
                driver = new ChromeDriver(options);
                break;
            case "OPERA" :
                System.setProperty("webdriver.opera.driver", "src\\main\\resources\\operadriver.exe");
                driver = new OperaDriver();
                break;
            case "MOZILLA" :
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "EDGE" :
                System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }
        if (width == 0 && height == 0) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(width, height));
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
