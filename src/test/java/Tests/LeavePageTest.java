package Tests;

import Base.BaseClass;
import Pages.POC01_LoginPage;
import Pages.POC03_PIMPage;
import Pages.POM04_LeavePage;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

public class LeavePageTest extends BaseClass {

    @Test
    public void VerifyLeaveTab() throws InterruptedException {
        log.info("Test Started: Verify Leave Page.");
        log.info("Admin User is now login into account.");

        // --------- Login as Admin ---------
        POC01_LoginPage lp = new POC01_LoginPage(getDriver());
        lp.EnterUsername("Admin");
        lp.EnterPassword("admin123");
        lp.ClickOnLoginButton();
        lp.GetTitle();

        // --------- Generate Unique Username ---------
        String uniqueUser = "Sam" + System.currentTimeMillis();

        // --------- Create Employee ---------
        POC03_PIMPage Pm = new POC03_PIMPage(getDriver());
        log.info("Admin User in now on PIM Page to create the Employee");
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();
        Pm.EnterFirstName("Sam");
        Pm.EnterMiddleName("Ron");
        Pm.EnterLastName("Wilson");
        Pm.EnterEmployeeID("0007");
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername(uniqueUser);
        Pm.EnterPassword("Sam@1234", "Sam@1234");
        Pm.ClickOnSaveButton();
        Pm.ClickOnEmplyList();

        // --------- Assign Leave to that Employee ---------
        POM04_LeavePage LeavePg = new POM04_LeavePage(getDriver());
        log.info("Admin User in now on Leave Page to create the leave for the Employee");
        LeavePg.ClickOnLeaveTab();
        LeavePg.ClickOnEntitlementsOpn();
        LeavePg.ClickOnAddEntitlementsOpn();
        LeavePg.EnterEmployeeNAme("Sam Ron Wilson");
        LeavePg.SelectLeaveType("CAN - Personal");
        LeavePg.SelectLeavePeriod("2025-01-01 - 2025-31-12");
        LeavePg.EnterEntitlementValue(5);
        LeavePg.ClickOnSaveButton();
        LeavePg.ClickOnConfirmBtn();
        LeavePg.GetResultText();
        LeavePg.ListOFLeave();

    }
}
