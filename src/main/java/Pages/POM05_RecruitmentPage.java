package Pages;

import Utils.BasePageUtils;
import Utils.WaitUtils;
import com.aventstack.extentreports.util.Assert;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

@Slf4j
public class POM05_RecruitmentPage extends BasePageUtils {

    WebDriver driver;
    WaitUtils wait;

    public POM05_RecruitmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
        log.info("Recruitment Page initialized successfully.");
    }

    // Find Leave tab element
    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement RecruitmentTab;

    // Find Add button Element
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement Addbtn;

    // Find Employee Full First Name field element
    @FindBy(name = "firstName")
    private WebElement EmpFirstName;

    // Find Employee Middle Name field element
    @FindBy(name = "middleName")
    private WebElement MiddleName;

    // Find Employee Last Name field element
    @FindBy(name = "lastName")
    private WebElement LastName;

    // Find Employee Last Name field element
    @FindBy(name = "lastName")
    private WebElement Email;

    // Find the resume upload element
//    @FindBy(xpath = "//input[@type='file']")
//    private WebElement ResumeUpld;

    private  By resumeUpload = By.xpath("//input[@type='file']");

    //label[text()='Resume']/../following-sibling::div//input[@type='file']

    // Find the save button element
    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement SaveButtonn;

    // Find the Candidates option element
    @FindBy(xpath = "//a[text()='Candidates']")
    private WebElement Candidates;

    // Find Employee name field element
    @FindBy(xpath = "//label[text()='Candidate Name']/../following-sibling::div//input[@placeholder='Type for hints...']")
    private WebElement CandidateName;

    // Find the Search button Element on PIM > Employee list page
    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement SearchButtn;

    // Find the Edit button element
    @FindBy(xpath = "//i[@class='oxd-icon bi-eye-fill']") //
    private WebElement EyeButton;

    // Find the Edit button element
    @FindBy(xpath = "//button[text()=' Shortlist ']")
    private WebElement ShortlistButton;

    // Find the save button element
    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement SaveButton;

    @Step("Click on the Recruitment tab")
    public void ClickOnRecruitmentTab() {
        wait.waitForElementToBeClickable(RecruitmentTab, WaitUtils.TIMEOUT);
        RecruitmentTab.click();
        log.info("Click on Recruitment Tab");
    }

    @Step("Click on Add Button")
    public void ClickOnAddBtn() {
        wait.waitForElementToBeClickable(Addbtn, WaitUtils.TIMEOUT);
        Addbtn.click();
        log.info("Click on Add Button");
    }

    @Step("Enter First Name: {0}")
    public void EnterFirstName(String FName) {
        wait.waitForElementToBeVisible(EmpFirstName, WaitUtils.TIMEOUT);
        EmpFirstName.sendKeys(FName);
        log.info("Enter First Name:" + FName);
    }

    @Step("Enter Middle Name: {0}")
    public void EnterMiddleName(String MName) {
        wait.waitForElementToBeVisible(MiddleName, WaitUtils.TIMEOUT);
        MiddleName.sendKeys(MName);
        log.info("Enter Middle Name:" + MName);
    }

    @Step("Enter Last Name: {0}")
    public void EnterLastName(String LName) {
        wait.waitForElementToBeVisible(LastName, WaitUtils.TIMEOUT);
        LastName.sendKeys(LName);
        log.info("Enter Last Name:" + LName);
    }

    @Step("Select Vacancy: {0}")
    public void SelectVacancy(String VacancyType) throws InterruptedException {
        Thread.sleep(3000);
        selectDropdownByLabel("Vacancy", VacancyType);
    }

    @Step("Enter Email: {0}")
    public void EnterEmail(String Email) throws InterruptedException {
        Thread.sleep(3000);
        enterTextByLabel("Email", Email);
    }

    @Step("Enter Contact Number: {0}")
    public void EnterContactNo(String ContactNum) throws InterruptedException {
        Thread.sleep(3000);
        enterTextByLabel("Contact Number", ContactNum);
    }

    public void UploadResume(String upload) {
        WebElement File = wait.waitForPresenceOfElement(By.xpath(String.valueOf(resumeUpload)), WaitUtils.TIMEOUT);
        File.sendKeys(upload);
        log.info("Upload the resume");
    }

    @Step("Click on the save button")
    public void ClickOnSaveButtonn() throws InterruptedException {
        wait.waitForElementToBeClickable(SaveButtonn, WaitUtils.TIMEOUT);
        SaveButtonn.click();
        log.info("Click on save button");
        Thread.sleep(3000);
    }

    @Step("Click On Candidates Option")
    public void ClickOnCandidatesOpn() throws InterruptedException {
        Thread.sleep(3000);
        wait.waitForElementToBeClickable(Candidates, WaitUtils.TIMEOUT);
        Candidates.click();
    }

    @Step("Enter Candidate Name: {0}")
    public void EnterCandidateName(String CanName) throws InterruptedException {
        wait.waitForElementToBeVisible(CandidateName, WaitUtils.TIMEOUT);
        CandidateName.sendKeys(CanName);

        // Wait for auto-suggest dropdown instead of fixed 5 seconds
        WebDriverWait dropdownWait = new WebDriverWait(driver, Duration.ofSeconds(WaitUtils.TIMEOUT));
        dropdownWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@role='option']"))
        );

        Thread.sleep(2000);
        CandidateName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Enter Candidate Name:" + CanName);
    }

    @Step("Click On Search Button")
    public void ClickOnSearchButtonn(){
        clickButtonByText("Search");
    }

    @Step("Click on Eye button button")
    public void ClickOnEyeBtn() {
        wait.waitForElementToBeClickable(EyeButton, WaitUtils.TIMEOUT);
        EyeButton.click();
        log.info("Click on Eye button button");
    }

    @Step("Click on Shortlist button")
    public void ClickOnShortlistBtn() {
        clickButtonByText("Shortlist");
        log.info("Click on Shortlist button");
    }

    @Step("Click on the save button")
    public void SaveButn() throws InterruptedException {
        clickButtonByText("Save");
        log.info("Click on Save button");
    }
}


