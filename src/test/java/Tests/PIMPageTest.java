package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM03_PIMPage;
import Utils.TestDataUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class PIMPageTest extends BaseClass {

    @Test(description = "Verify Create & Update the Employee")
    @Description("This test verifies the to create Create & Update the Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Employee Creations Feature")
    @Parameters("Browser")
    public void VerifyPIMTab() throws InterruptedException, IOException {
        log.info("Test Started: Verify PIM Page.");

        // ========= 1. Prepare unique test data =========

        String employeeId = TestDataUtils.UniqueID();   // unique employee ID
        String adminUsername = "Waan" + (char) ('A' + new Random().nextInt(26));   // unique admin user

        POM01_LoginPage lp = new POM01_LoginPage(getDriver());
        lp.EnterUsername("Admin");
        lp.EnterPassword("admin123");
        lp.ClickOnLoginButton();
        lp.GetTitle();

        POM03_PIMPage Pm = new POM03_PIMPage(getDriver());
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();
        Pm.EnterFirstName("Sam");
        Pm.EnterMiddleName("Ron");
        Pm.EnterLastName("Wilson");
        Pm.EnterEmployeeID(employeeId);
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername(adminUsername);
        Pm.EnterPassword("Sam@1234", "Sam@1234");
        Pm.ClickOnSaveButton();
//        Pm.EnterEmpID("0007");
        Pm.ClickOnJobOpn();
        Pm.SelectJobTitle("QA Engineer");
        Pm.ClickonSaveBtn();
        Pm.ClickOnEmplyListOpn();
        Pm.EmployeeNameField("Sam Ron Wilson");
        Pm.ClickOnSearchButtonn();
//        Pm.ListOFFUsers();
        Pm.ClickOnDelIcon();
        Pm.DeleteUserr();
    }
}
