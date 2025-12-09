package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM03_PIMPage;
import TestData.TestData;
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

        POM01_LoginPage lp = new POM01_LoginPage(getDriver());
        lp.EnterUsername(TestData.loginID);
        lp.EnterPassword(TestData.loginPass);
        lp.ClickOnLoginButton();
        lp.GetTitle();

        POM03_PIMPage Pm = new POM03_PIMPage(getDriver());
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();
        Pm.EnterFirstName(TestData.EmployeeFName);
        Pm.EnterMiddleName(TestData.EmployeeMName);
        Pm.EnterLastName(TestData.EmployeeLName);
        Pm.EnterEmployeeID(TestData.employeeId);
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername(TestData.adUsername);
        Pm.EnterPassword(TestData.PIMUserPass, TestData.PIMUserCofmPass);
        Pm.ClickOnSaveButton();
//        Pm.EnterEmpID("0007");
        Pm.ClickOnJobOpn();
        Pm.SelectJobTitle(TestData.JobTitle);
        Pm.ClickonSaveBtn();
        Pm.ClickOnEmplyListOpn();
        Pm.EmployeeNameField(TestData.EmployeeName);
        Pm.ClickOnSearchButtonn();
//        Pm.ListOFFUsers();
        Pm.ClickOnDelIcon();
        Pm.DeleteUserr();
    }
}
