package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM03_PIMPage;
import TestData.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static Base.BaseClass.getDriver;
import static Base.BaseClass.log;

public class DDT_PIMPageTest extends BaseClass {

    @Test(description = "Verify Create & Update the Employee",
            dataProvider = "ExcelData",
            dataProviderClass = Utils.DataProvider.class)
    @Description("This test verifies the to create Create & Update the Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Employee Creations Feature")
    @Parameters("Browser")
    public void VerifyPIMTab(Map<String, String> data) throws InterruptedException, IOException {
        log.info("Test Started: Verify PIM Page.");

        String loginUser = data.get("loginUsername");
        String loginPass = data.get("loginPassword");

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
        String jobTitle = data.get("jobTitle");

        POM03_PIMPage Pm = new POM03_PIMPage(getDriver());
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
        Pm.ClickOnJobOpn();
        Pm.SelectJobTitle(jobTitle);
        Pm.ClickonSaveBtn();
        Pm.ClickOnEmplyListOpn();
        String employeeName = data.get("firstName") + " " + data.get("lastName");
        Pm.EmployeeNameField(employeeName);
        Pm.ClickOnSearchButtonn();
        Pm.ClickOnDelIcon();
        Pm.DeleteUserr();
    }
}