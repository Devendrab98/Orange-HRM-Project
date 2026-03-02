package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM02_AdminPage;
import Pages.POM03_PIMPage;
import TestData.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class DDT_AdminTest extends BaseClass {

    @Test(description = "Verify Create & delete the admin user",
            dataProvider = "ExcelData",
            dataProviderClass = Utils.DataProvider.class)
    @Description("This test verifies the to create the admin user")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User Creations Feature")
    @Parameters("Browser")
    public void VerifyAdminTab(Map<String, String> data) throws InterruptedException {
        log.info("Test Started: Verify Admin Page.");

        String loginUser = data.get("loginUsername");
        String loginPass = data.get("loginPassword");

        String userRole = data.get("userRole");
        String status = data.get("status");
//        String empName = data.get("employeeName");
        String empName = data.get("firstName") + " " + data.get("lastName");
        String pimUsername = data.get("pimUsername");
        String adminUsername = data.get("adminUsername");
        String password = data.get("password");
        String confirm = data.get("confirmPassword");


        // ========= 1. Login =========
        POM01_LoginPage lp = new POM01_LoginPage(getDriver());
        lp.EnterUsername(loginUser);
        lp.EnterPassword(loginPass);
        lp.ClickOnLoginButton();
        lp.GetTitle();

        // ========= 2. Create Employee in PIM =========
        POM03_PIMPage Pm = getPom03PimPage(
                data.get("firstName"),
                data.get("middleName"),
                data.get("lastName"),
                pimUsername,
                data.get("empId"),
                password,
                confirm
        );

        Pm.ClickOnEmplyListOpn();

        // ========= 3. Go to Admin and create Admin User =========
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
        ad.ClickOnUserRoleDropDown(userRole);
        ad.ClickOnStatusDropDown(status);
        ad.EnterPasword(password);

        // This searches existing employee we just created
        ad.EnterEmployeeName(empName);

        // Unique admin username
        ad.EnterUsername(adminUsername);
        ad.EnterConfirmPassword(confirm);
        ad.ClickOnSaveButton();

        // ========= 4. Search created Admin user =========
        ad.EnterUserNmForSearch(adminUsername);
        ad.ClickOnSearchBtn();

        // Fetch the created user from a list
        String user = ad.UserList();

        Assert.assertTrue(user.contains(adminUsername),
                "Created user name is '" + adminUsername + "' not in the list:\n" + user);

        System.out.println("User name is in the list. User is created successfully: " + adminUsername);

        // ========= 5. Delete created user =========
        ad.ClickOnDeleteIcon();
        ad.DeleteUrs();

        // Verify text message after user delete
        String actualText = ad.PrintNoResult();
        Assert.assertEquals(actualText, "No Records Found", "Delete user failed - Text mismatch!");
        log.info("User deleted successfully. Verified message: {}", actualText);
    }

    private static POM03_PIMPage getPom03PimPage(
            String Fname, String Mname, String Lname, String Username, String empId, String passwrd, String CnfPass) {
        POM03_PIMPage Pm = new POM03_PIMPage(getDriver());
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();

        // Employee names can stay fixed; only ID + login must be unique
        Pm.EnterFirstName(Fname);
        // Pm.EnterMiddleName(Mname);
        Pm.EnterLastName(Lname);


        Pm.EnterEmployeeID(empId);
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername(Username);
        Pm.EnterPassword(passwrd, CnfPass);
        Pm.ClickOnSaveButton();
        return Pm;
    }
}
