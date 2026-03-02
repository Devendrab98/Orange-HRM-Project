package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import TestData.TestData;
import Utils.AllureUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPageTest extends BaseClass {

    @Test(priority = 1,
            description = "Verify login with valid credentials",
            dataProvider = "ExcelData",
            dataProviderClass = Utils.DataProvider.class)
    @Description("Login with user: {0} expected: {2}")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Parameters("Browser")
    public void VerifyLogin(Map<String, String> data) throws InterruptedException {
        log.info("Test started: verifyLogin.");
        AllureUtils.logInfo("Test Allure");

        String username = data.get("loginUsername");
        String password = data.get("loginPassword");
        String expected = data.get("expected");

        POM01_LoginPage lg = new POM01_LoginPage(getDriver());
        lg.EnterUsername(username);
        lg.EnterPassword(password);
        lg.ClickOnLoginButton();

        if (expected.equalsIgnoreCase("valid")) {
            String actualHeader = lg.GetTitle();
            Assert.assertEquals(actualHeader, "Dashboard", "Login failed! Dashboard header not found." + actualHeader);
            log.info("Login successful. Proceeding to Logout.");

            // Logout Flow
            lg.ClickOnProfile();
            lg.ClickOnLogout();

            String loginTitle = lg.getTitle();
            Assert.assertTrue(loginTitle.contains("OrangeHRM"), "Logout failed!" + loginTitle);
            log.info("Logout successful.");
        } else if (expected.equalsIgnoreCase("invalid")) {
            Assert.assertEquals(lg.getErrorMessage(), "Invalid credentials");
        }
    }


    @Test(priority = 2,
            enabled = false,
            description = "Verify login with Invalid credentials",
            dataProvider = "ExcelData",
            dataProviderClass = Utils.DataProvider.class
    )
    @Description("This test verifies login using Incorrect username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    public void InvalidCredTest(String UserName, String Password, String expected) {
        log.info("Invalid Test started: Verify login Functionality with invalid Credentials");
        POM01_LoginPage lg = new POM01_LoginPage(getDriver());
        lg.InvalidLogin(UserName, Password);

        if (expected.equalsIgnoreCase("invalid")) {
            String errorText = lg.getErrorMessage();
            Assert.assertEquals(errorText, "Invalid credentials", "Error message mismatch!");
        } else {
            System.out.println("Test Failed");
        }
    }
}
