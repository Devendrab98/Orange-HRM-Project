package Tests;

import Base.BaseClass;
import Pages.POC01_LoginPage;
import Utils.AllureUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    @Test(description = "Verify login with valid credentials")
    @Description("This test verifies login using correct username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Parameters("Browser")
    public void VerifyLogin() {
        log.info("Test started: verifyLogin.");
        AllureUtils.logInfo("Test Allure");
        POC01_LoginPage lg = new POC01_LoginPage(getDriver());
        lg.EnterUsername("Admin");
        lg.EnterPassword("admin123");
        lg.ClickOnLoginButton();
        lg.GetTitle();
        lg.ClickOnProfile();
        lg.ClickOnLogout();
//        lg.InvalidLogin("Admin", "admin12345");
        String actualTitle = lg.getTitle();
        Assert.assertTrue(actualTitle.contains("OrangeHRM"),
                "Title is not match! the expected title is 'OrangeHRM'" + actualTitle);
        System.out.println("Title is match! User is logout successfully & the title is:" + actualTitle);

        AllureUtils.attachScreenshotWithName(getDriver(), "After Verify login");
    }
}
