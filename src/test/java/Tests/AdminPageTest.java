package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM02_AdminPage;
import Pages.POM03_PIMPage;
import Utils.TestDataUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class AdminPageTest extends BaseClass {

    @Test(description = "Verify Create & delete the admin user")
    @Description("This test verifies the to create the admin user")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User Creations Feature")
    @Parameters("Browser")
    public void VerifyAdminTab() throws InterruptedException {
        log.info("Test Started: Verify Admin Page.");

        // ========= 1. Prepare unique test data =========

        String employeeId = TestDataUtils.UniqueID();   // unique employee ID
        String employeeLoginUser = TestDataUtils.UniqueUsername("E");  // unique login for employee
        String adminUsername = "Samm" + (char)('A' + new Random().nextInt(26));   // unique admin user
        String password = "Pass@123";

        // ========= 2. Login =========
        POM01_LoginPage lp = new POM01_LoginPage(getDriver());
        lp.EnterUsername("Admin");
        lp.EnterPassword("admin123");
        lp.ClickOnLoginButton();
        lp.GetTitle();

        // ========= 3. Create Employee in PIM =========
        POM03_PIMPage Pm= new POM03_PIMPage(getDriver());
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();

        // Employee names can stay fixed; only ID + login must be unique
        Pm.EnterFirstName("Sam");
        Pm.EnterMiddleName("Ron");
        Pm.EnterLastName("Wilson");


        Pm.EnterEmployeeID(employeeId);
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername(employeeLoginUser);
        Pm.EnterPassword("Sam@1234", "Sam@1234" );
        Pm.ClickOnSaveButton();
        Pm.ClickOnEmplyListOpn();

        // ========= 4. Go to Admin and create Admin User =========
        POM02_AdminPage ad = new POM02_AdminPage(getDriver());
        ad.ClickOnAdmin();

        // User Assert to Verify Admin page URL
        String ActualURL = ad.GetAdminPageURL();
        Assert.assertTrue(ActualURL.contains("viewSystemUsers"),
                "Test Fail expected URL contain 'viewSystemUsers' but got: " + ActualURL);

        log.info("Admin Page URL is valid: {}", ActualURL);
        ad.ClickOnAddBtn();

        // User Assert to Verify Add Uer page URL
        String AddPgUrl = ad.GetAddUserPageURL();
        Assert.assertTrue(AddPgUrl.contains("saveSystemUser"),
                "Test Fail expected URL contain 'saveSystemUser' but got: " + AddPgUrl);

        log.info("Add User Page URL is valid: {}", AddPgUrl);

        // Fill Add User form
        ad.ClickOnUserRoleDropDown("Admin");
        ad.ClickOnStatusDropDown("Enabled");
        ad.EnterPasword(password);

        // This searches existing employee we just created
        ad.EnterEmployeeName("Sam Ron Wilson");

        // Unique admin username
        ad.EnterUsername(adminUsername);
        ad.EnterConfirmPassword(password);
        ad.ClickOnSaveButton();

        // ========= 5. Search created Admin user =========
        ad.EnterUserNmForSearch(adminUsername);
        ad.ClickOnSearchBtn();

        // Fetch the created user from a list
        String user = ad.UserList();

        Assert.assertTrue(user.contains(adminUsername),
                "Created user name is '" + adminUsername + "' not in the list:\n" + user);

        System.out.println("User name is in the list. User is created successfully: " + adminUsername);

        // ========= 6. Delete created user =========
        ad.ClickOnDeleteIcon();
        ad.DeleteUrs();

        // Verify text message after user delete
        String actualText = ad.PrintNoResult();
        Assert.assertEquals(actualText, "No Records Found", "Delete user failed - Text mismatch!");
        log.info("User deleted successfully. Verified message: {}", actualText);
    }
}
