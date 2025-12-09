package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM03_PIMPage;
import Pages.POM04_LeavePage;
import TestData.TestData;
import Utils.TestDataUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeavePageTest extends BaseClass {

    @Test(description = "Verify Create the leave for the Employee")
    @Description("This test verifies the to Create the leave for the Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Story("leave Creations Feature")
    @Parameters("Browser")
    public void VerifyLeaveTab() throws InterruptedException {
        log.info("Test Started: Verify Leave Page.");
        log.info("Admin User is now login into account.");

        // --------- Login as Admin ---------
        POM01_LoginPage lp = new POM01_LoginPage(getDriver());
        lp.EnterUsername(TestData.loginID);
        lp.EnterPassword(TestData.loginPass);
        lp.ClickOnLoginButton();
        lp.GetTitle();


        // --------- Create Employee ---------
        POM03_PIMPage Pm = new POM03_PIMPage(getDriver());
        log.info("Admin User in now on PIM Page to create the Employee");
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();
        Pm.EnterFirstName(TestData.EmployeeFirName);
        Pm.EnterMiddleName(TestData.EmployeeMidName);
        Pm.EnterLastName(TestData.EmployeeLstName);
        Pm.EnterEmployeeID(TestData.employeeId);
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername(TestData.uniqueUser);
        Pm.EnterPassword(TestData.PIMUserPass, TestData.PIMUserCofmPass);
        Pm.ClickOnSaveButton();
        Pm.ClickOnEmplyListOpn();

        // --------- Assign Leave to that Employee ---------
        POM04_LeavePage LeavePg = new POM04_LeavePage(getDriver());
        log.info("Admin User in now on Leave Page to create the leave for the Employee");
        LeavePg.ClickOnLeaveTab();
        LeavePg.ClickOnEntitlementsOpn();
        LeavePg.ClickOnAddEntitlementsOpn();
        LeavePg.EnterEmployeeNAme(TestData.LveEmplyName);
        LeavePg.SelectLeaveType(TestData.LeaveType);
        LeavePg.SelectLeavePeriod(TestData.LeavePeriod);
        LeavePg.EnterEntitlementValue(TestData.EntitlementValue);
        LeavePg.ClickOnSaveButton();
        LeavePg.ClickOnConfirmBtn();
        LeavePg.GetResultText();
        LeavePg.ListOFLeave();
    }
}
