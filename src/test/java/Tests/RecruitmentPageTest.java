package Tests;

import Base.BaseClass;
import Pages.POM01_LoginPage;
import Pages.POM05_RecruitmentPage;
import TestData.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
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
        lp.EnterUsername(TestData.loginID);
        lp.EnterPassword(TestData.loginPass);
        lp.ClickOnLoginButton();
        lp.GetTitle();

        POM05_RecruitmentPage RC = new POM05_RecruitmentPage(getDriver());
        log.info("Admin User is now on the RecruitmentPage");
        RC.ClickOnRecruitmentTab();
        RC.ClickOnAddBtn();
        RC.EnterFirstName(TestData.RecFirstName);
        RC.EnterMiddleName(TestData.RecMiddName);
        RC.EnterLastName(TestData.RecLastName);
        RC.SelectVacancy(TestData.Vacancy);
        RC.EnterEmail(TestData.Email);
        RC.EnterContactNo(TestData.ContactNo);
        RC.ClickOnSaveButtonn();
        RC.ClickOnCandidatesOpn();
        RC.EnterCandidateName(TestData.CandidateName);
        RC.ClickOnSearchButtonn();
        RC.ClickOnEyeBtn();
        RC.ClickOnShortlistBtn();
        RC.SaveButn();
    }
}
