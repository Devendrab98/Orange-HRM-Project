package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM05_RecruitmentPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RecruitmentPageTest extends BaseClass {

    @Test(description = "Verify Recruitment creation")
    @Description("This test verifies Recruitment Page")
    @Severity(SeverityLevel.NORMAL)
    @Story("Recruitment Feature")
    @Parameters("Browser")
    public void VerifyRecruitmentTab() throws InterruptedException {
        log.info("Test Started: Verify Recruitment Page.");
        log.info("Admin User is now login into account.");

        // --------- Login as Admin ---------
        POM01_LoginPage lp = new POM01_LoginPage(getDriver());
        lp.EnterUsername("Admin");
        lp.EnterPassword("admin123");
        lp.ClickOnLoginButton();
        lp.GetTitle();

        POM05_RecruitmentPage RC = new POM05_RecruitmentPage(getDriver());
        log.info("Admin is now on the RecruitmentPage");
        RC.ClickOnRecruitmentTab();
        RC.ClickOnAddBtn();
        RC.EnterFirstName("Lisa");
        RC.EnterMiddleName("Van");
        RC.EnterLastName("Will");
        RC.SelectVacancy("Software Engineer");
        RC.EnterEmail("Lisa@yopmail.com");
        RC.EnterContactNo("+12345678908");
        RC.ClickOnSaveButtonn();
        RC.ClickOnCandidatesOpn();
        RC.EnterCandidateName("Lisa");
        RC.ClickOnSearchButtonn();
        RC.ClickOnEyeBtn();
        RC.ClickOnShortlistBtn();
        RC.SaveButn();
    }
}
