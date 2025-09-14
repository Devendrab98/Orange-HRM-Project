package Tests;

import Base.BaseClass;
import Pages.POC01_LoginPage;
import Pages.POC03_PIMPage;
import org.testng.annotations.Test;

public class PIMPageTest extends BaseClass {

    @Test
    public void VerifyPIMTab() throws InterruptedException {
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
        Pm.ClickonSaveButtonn();
        Pm.ClickOnEmplyList();
        Pm.EnterEmpID("0007");
        Pm.ClickOnSearchButtonn();


    }
}
