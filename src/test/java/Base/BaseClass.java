package Base;

import Utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;

import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class BaseClass {

    public static WebDriver driver;

    // Correct logger instance for Log4j2
    public static Logger log = LogManager.getLogger(BaseClass.class);


    ConfigReader configReader;

    {
        try {
            configReader = new ConfigReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setup() {

        String URL = configReader.getUrl();
        String Browser = configReader.getBrowser();

        switch (Browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                log.info("Chrome browser launched successfully.");
                break;

            case "firefox":
                driver = new FirefoxDriver();
                log.info("FireFox browser launched successfully.");
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + Browser);
        }

        driver.manage().window().maximize();
        log.info("Browser window maximized.");

        driver.get(URL);
        log.info("Navigated to URL:"+URL);

    }

    @AfterMethod
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        log.info("Browser closed successfully");
    }

}
