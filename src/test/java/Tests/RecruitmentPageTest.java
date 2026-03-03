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
import testUtils.DataProvider;

import java.util.Map;

public class RecruitmentPageTest extends BaseClass {

    @Test(description = "Verify Recruitment creation",
            dataProvider = "ExcelData",
            dataProviderClass = DataProvider.class)
    @Description("This test verifies Recruitment Page")
    @Severity(SeverityLevel.NORMAL)
    @Story("Recruitment Feature")
    @Parameters("Browser")
    public void VerifyRecruitmentTab(Map<String, String> data) throws InterruptedException {
        log.info("Test Started: Verify Recruitment Page.");
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
        String vacancy = data.get("vacancy");
        String email = data.get("email");
        String contactNo = data.get("contactNo");
        String candidateName = data.get("firstName") + " " + data.get("lastName");


        POM05_RecruitmentPage RC = new POM05_RecruitmentPage(getDriver());
        log.info("Admin User is now on the RecruitmentPage");
        RC.ClickOnRecruitmentTab();
        RC.ClickOnAddBtn();
        RC.EnterFirstName(firstName);
        RC.EnterLastName(lastName);
        RC.SelectVacancy(vacancy);
        RC.EnterEmail(email);
        RC.EnterContactNo(contactNo);
        RC.ClickOnSaveButtonn();
        RC.ClickOnCandidatesOpn();
        RC.EnterCandidateName(candidateName);
        RC.ClickOnSearchButtonn();
        RC.ClickOnEyeBtn();
        RC.ClickOnShortlistBtn();
        RC.SaveButn();
    }
}
