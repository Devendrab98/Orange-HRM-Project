package Tests;

import Base.BaseClass;
import Pages.POC01_LoginPage;
import Pages.POC03_PIMPage;
import Pages.POM04_LeavePage;
import org.testng.annotations.Test;

public class LeavePageTest extends BaseClass {

    @Test
    public void VerifyLeaveTab() throws InterruptedException {
        log.info("Test Started: Verify Leave Page.");
        POC01_LoginPage log = new POC01_LoginPage(driver);
        log.EnterUsername("Admin");
        log.EnterPassword("admin123");
        log.ClickOnLoginButton();
        log.GetTitle();

        POC03_PIMPage Pm= new POC03_PIMPage(driver);
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();
        Pm.EnterFirstName("Sam");
        Pm.EnterMiddleName("Ron");
        Pm.EnterLastName("Wilson");
        Pm.EnterEmployeeID("0007");
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername("Sam123");
        Pm.EnterPassword("Sam@1234", "Sam@1234" );
        Pm.ClickonSaveButtonn();
        Pm.ClickOnEmplyList();

        POM04_LeavePage lp = new POM04_LeavePage(driver);
        lp.ClickOnLeaveTab();
        lp.ClickOnEntitlementsOpn();
        lp.ClickOnAddEntitlementsOpn();
        lp.EnterEmployeeNAme("Sam Ron Wilson");
        lp.SelectLeaveType("US - Personal");
        lp.SelectLeavePeriod("2025-01-01 - 2025-12-31");
        lp.EnterEntitlementValue(5);
        lp.ClickOnSaveButton();

    }
}
