package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import TestData.TestData;
import Utils.AllureUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    @Test(priority = 1, description = "Verify login with valid credentials")
    @Description("This test verifies login using correct username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    @Parameters("Browser")
    public void VerifyLogin() {
        log.info("Test started: verifyLogin.");
        AllureUtils.logInfo("Test Allure");
        POM01_LoginPage lg = new POM01_LoginPage(getDriver());
        lg.EnterUsername(TestData.loginID);
        lg.EnterPassword(TestData.loginPass);
        lg.ClickOnLoginButton();

        String actualHeader = lg.GetTitle();
        Assert.assertEquals(actualHeader,"Dashboard", "Login failed! Dashboard header not found." +actualHeader);
        log.info("Login successful. Proceeding to Logout.");

        // Logout Flow
        lg.ClickOnProfile();
        lg.ClickOnLogout();

        String loginTitle = lg.getTitle();
        Assert.assertTrue(loginTitle.contains("OrangeHRM"), "Logout failed!" +loginTitle);
        log.info("Logout successful.");
    }


    @Test(priority = 2, description = "Verify login with Invalid credentials")
    @Description("This test verifies login using Incorrect username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Feature")
    public void InvalidCredTest(){
        log.info("Invalid Test started: Verify login Functionality with invalid Credentials");
        POM01_LoginPage lg = new POM01_LoginPage(getDriver());
        lg.InvalidLogin(TestData.Invalid_Id, TestData.Invalid_Pass);

        String errorText = lg.getErrorMessage();
        Assert.assertEquals(errorText, "Invalid credentials", "Error message mismatch!");
    }
}
