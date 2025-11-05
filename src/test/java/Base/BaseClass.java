package Base;

import Utils.AllureUtils;
import Utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseClass {

    WebDriver webDriver;

    // ThreadLocal driver (safe for parallel execution)
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

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
    @Parameters("Browser")
    public void setup(String browser) {
        String URL = configReader.getUrl();
        String Browser = configReader.getBrowser();

        webDriver = initializeBrowser(browser);

        driver.set(webDriver);   //  store driver in ThreadLocal

        getDriver().manage().window().maximize();
        log.info("Browser window maximized.");

        getDriver().get(URL);
        log.info("Navigated to URL: " + URL);
    }

    private WebDriver initializeBrowser(String browser) {

        // Check if headless mode is enabled via Jenkins or Maven
        boolean isHeadless = System.getProperty("headless", "false").equalsIgnoreCase("true");

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();

                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                webDriver = new ChromeDriver(chromeOptions);
                log.info("Chrome browser launched successfully."+isHeadless);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                webDriver = new FirefoxDriver();
                log.info("Firefox browser launched successfully."+isHeadless);
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        return webDriver;
    }

    @AfterMethod
    public void CloseBrowser(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            AllureUtils.attachScreenshot(getDriver());  // automatic screenshot on failure
            log.error("Test failed. Screenshot attached.");
        }

        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();   //  remove ThreadLocal reference
            log.info("Browser closed successfully.");
        }
    }

    public static WebDriver getDriver() {
        return driver.get();   // always use this in tests/POMs
    }
}
