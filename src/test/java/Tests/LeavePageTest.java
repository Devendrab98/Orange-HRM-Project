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

import java.util.Map;

public class LeavePageTest extends BaseClass {

    @Test(description = "Verify Create the leave for the Employee",
    dataProvider = "ExcelData",
    dataProviderClass = Utils.DataProvider.class)
    @Description("This test verifies the to Create the leave for the Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Story("leave Creations Feature")
    @Parameters("Browser")
    public void VerifyLeaveTab(Map<String, String>data) throws InterruptedException {
        log.info("Test Started: Verify Leave Page.");
        log.info("Admin User is now login into account.");

        String loginUser = data.get("loginUsername");
        String loginPass = data.get("loginPassword");

        // --------- Login as Admin ---------
        POM01_LoginPage lp = new POM01_LoginPage(getDriver());
        lp.EnterUsername(loginUser);
        lp.EnterPassword(loginPass);
        lp.ClickOnLoginButton();
        lp.GetTitle();

        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String empId = data.get("empId");
        String pimUsername = data.get("pimUsername");
        String password = data.get("password");
        String confirm = data.get("confirmPassword");


        // --------- Create Employee ---------
        POM03_PIMPage Pm = new POM03_PIMPage(getDriver());
        log.info("Admin User in now on PIM Page to create the Employee");
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();
        Pm.EnterFirstName(firstName);
        Pm.EnterLastName(lastName);
        Pm.EnterEmployeeID(empId);
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername(pimUsername);
        Pm.EnterPassword(password, confirm);
        Pm.ClickOnSaveButton();
        Pm.ClickOnEmplyListOpn();


        String employeeName = data.get("firstName") + " " + data.get("lastName");
        String leaveType = data.get("leaveType");
        String leavePeriod = data.get("leavePeriod");
        int entitlementValue = Integer.parseInt(data.get("entitlementValue"));


        // --------- Assign Leave to that Employee ---------
        POM04_LeavePage LeavePg = new POM04_LeavePage(getDriver());
        log.info("Admin User in now on Leave Page to create the leave for the Employee");
        LeavePg.ClickOnLeaveTab();
        LeavePg.ClickOnEntitlementsOpn();
        LeavePg.ClickOnAddEntitlementsOpn();
        LeavePg.EnterEmployeeNAme(employeeName);
        LeavePg.SelectLeaveType(leaveType);
        LeavePg.SelectLeavePeriod(leavePeriod);
        LeavePg.EnterEntitlementValue(entitlementValue);
        LeavePg.ClickOnSaveButton();
        LeavePg.ClickOnConfirmBtn();
        LeavePg.GetResultText();
        LeavePg.ListOFLeave();
    }
}
