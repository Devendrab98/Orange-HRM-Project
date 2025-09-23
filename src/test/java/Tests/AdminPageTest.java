package Tests;

import Base.BaseClass;
import Pages.POC01_LoginPage;
import Pages.POC02_AdminPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class AdminPageTest extends BaseClass {

    @Test(description = "Verify Create & delete the admin user")
    @Description("This test verifies the to create the admin user")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User Creations Feature")
    @Parameters("Browser")
    public void VerifyAdminTab() throws InterruptedException {
        log.info("Test Started: Verify Admin Page.");
        POC01_LoginPage lp = new POC01_LoginPage(getDriver());
        lp.EnterUsername("Admin");
        lp.EnterPassword("admin123");
        lp.ClickOnLoginButton();
        lp.GetTitle();

        POC02_AdminPage ad = new POC02_AdminPage(getDriver());
        ad.ClickOnAdmin();

        // User Assert to Verify Admin page URL
        String ActualURL = ad.GetAdminPageURL();
        Assert.assertTrue(ActualURL.contains("viewSystemUsers"),
                "Test Fail expected URL contain 'viewSystemUsers' but got: " + ActualURL);

        System.out.println("Admin Page URL is valid: " + ActualURL);
        Thread.sleep(3000);

        ad.ClickOnAddBtn();
        Thread.sleep(2000);
        // User Assert to Verify Add Uer page URL
        String AddPgUrl = ad.GetAddUserPageURL();
        Assert.assertTrue(AddPgUrl.contains("saveSystemUser"),
                "Test Fail expected URL contain 'saveSystemUser' but got: " + AddPgUrl);

        System.out.println("Add User page URL is valid: " + AddPgUrl);
        Thread.sleep(3000);

        ad.ClickOnUserRoleDropDown("Admin");
        ad.ClickOnStatusDropDown("Enabled");
        ad.EnterPasword("Pass@123");
        ad.EnterEmployeeName("james");
        ad.EnterUsername("Rahulya");
        ad.EnterConfirmPassword("Pass@123");
        ad.ClickOnSaveButton();
        ad.EnterUserNmForSearch("Rahulya");
        ad.ClickOnSearchBtn();

        // Fetch the created user from a list
        String user = ad.UserList();
        String expectedUser = "Rahulya";

        Assert.assertTrue(user.contains(expectedUser),
                "Created user name is '" + expectedUser + "' not in the list:\n" + user);

        System.out.println("User name is in the list. User is created successfully: " + expectedUser);

        ad.DeleteUser();

        // Verify text message after user delete
        String actualText = ad.PrintNoResult();
        Assert.assertEquals(actualText, "No Records Found", "Delete user failed - Text mismatch!");
        System.out.println("User deleted successfully. Verified message: " + actualText);
    }
}
