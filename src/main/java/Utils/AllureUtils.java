package Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureUtils {


    /**
     * Attach a plain text log into Allure report.
     */
    @Attachment(value = "{0}", type = "text/plain")
    public static String logInfo(String message) {
        return message;
    }

    /**
     * Attach screenshot in Allure report.
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public static void attachScreenshot(WebDriver driver) {
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Alternative way using lifecycle (if you prefer dynamic attachment).
     */
    public static void attachScreenshotWithName(WebDriver driver, String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
