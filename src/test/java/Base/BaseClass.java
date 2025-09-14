package Base;

import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;

import java.io.IOException;

public class BaseClass {

    public static WebDriver driver;

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
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + Browser);
        }

        driver.manage().window().maximize();

        driver.get(URL);

    }

//    @AfterMethod
//    public void CloseBrowser() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
//    }

}
