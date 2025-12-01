package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM03_PIMPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class PIMPageTest extends BaseClass {

    @Test(description = "Verify Create & Update the Employee")
    @Description("This test verifies the to create Create & Update the Employee")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Employee Creations Feature")
    @Parameters("Browser")
    public void VerifyPIMTab() throws InterruptedException, IOException {
        log.info("Test Started: Verify PIM Page.");
        POM01_LoginPage lp = new POM01_LoginPage(getDriver());
        lp.EnterUsername("Admin");
        lp.EnterPassword("admin123");
        lp.ClickOnLoginButton();
        lp.GetTitle();

        POM03_PIMPage Pm= new POM03_PIMPage(getDriver());
        Pm.ClickOnPimTab();
        Pm.ClickOnAddBtn();
        Pm.GetPimTabTitle();
//        Pm.UploadProfile("D:\\SShot.png");
        Pm.EnterFirstName("Sam");
        Pm.EnterMiddleName("Ron");
        Pm.EnterLastName("Wilson");
        Pm.EnterEmployeeID("0007");
        Pm.EnableCreateLoginSwitch();
        Pm.EnterUsername("Sam123");
        Pm.EnterPassword("Sam@1234", "Sam@1234" );
        Pm.ClickOnSaveButton();
        Pm.ClickOnEmplyListOpn();
        Pm.EmployeeNameField("Sam Ron Wilson");
//        Pm.EnterEmpID("0007");
        Pm.ClickOnSearchButtonn();
        Pm.ClickOnEditBtn();
        Pm.ClickOnJobOpn();
        Pm.SelectJobTitle("QA Engineer");
        Pm.ClickonSaveBtn();
    }
}
