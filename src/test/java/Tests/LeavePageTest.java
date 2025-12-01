package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM03_PIMPage;
import Pages.POM04_LeavePage;
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
        lp.EnterUsername("Admin");
        lp.EnterPassword("admin123");
        lp.ClickOnLoginButton();
        lp.GetTitle();

        // --------- Generate Unique Username ---------
        String uniqueUser = "Sam" + System.currentTimeMillis();

        // --------- Generate Unique EmployeeId ---------
        String employeeId = TestDataUtils.UniqueID();

        // --------- Create Employee ---------
        POM03_PIMPage Pm = new POM03_PIMPage(getDriver());
        log.info("Admin User in now on PIM Page to create the Employee");
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();
        Pm.EnterFirstName("Sam");
        Pm.EnterMiddleName("Bob");
        Pm.EnterLastName("Wilson");
        Pm.EnterEmployeeID(employeeId);
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername(uniqueUser);
        Pm.EnterPassword("Sam@1234", "Sam@1234");
        Pm.ClickOnSaveButton();
        Pm.ClickOnEmplyListOpn();

        // --------- Assign Leave to that Employee ---------
        POM04_LeavePage LeavePg = new POM04_LeavePage(getDriver());
        log.info("Admin User in now on Leave Page to create the leave for the Employee");
        LeavePg.ClickOnLeaveTab();
        LeavePg.ClickOnEntitlementsOpn();
        LeavePg.ClickOnAddEntitlementsOpn();
        LeavePg.EnterEmployeeNAme("Sam Bob Wilson");
        LeavePg.SelectLeaveType("CAN - Personal");
        LeavePg.SelectLeavePeriod("2025-01-01 - 2025-31-12");
        LeavePg.EnterEntitlementValue(5);
        LeavePg.ClickOnSaveButton();
        LeavePg.ClickOnConfirmBtn();
        LeavePg.GetResultText();
        LeavePg.ListOFLeave();

    }
}
