package Tests;

import Base.BaseClass;
import Pages.POC01_LoginPage;
import Pages.POC03_PIMPage;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

public class PIMPageTest extends BaseClass {

    @Test
    public void VerifyPIMTab() throws InterruptedException {
        log.info("Test Started: Verify PIM Page.");
        POC01_LoginPage lp = new POC01_LoginPage(driver);
        lp.EnterUsername("Admin");
        lp.EnterPassword("admin123");
        lp.ClickOnLoginButton();
        lp.GetTitle();

        POC03_PIMPage Pm= new POC03_PIMPage(driver);
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
        Pm.ClickonSaveButtonn();
        Pm.ClickOnEmplyList();
        Pm.EmployeeNameField("Sam Ron Wilson");
//        Pm.EnterEmpID("0007");
        Pm.ClickOnSearchButtonn();
        Pm.ClickOnEditBtn();
        Pm.ClickOnJobOpn();
        Pm.SelectJobTitle("QA Engineer");
        Pm.ClickonSaveBtn();




    }
}
