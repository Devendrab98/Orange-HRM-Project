package Pages;

import Utils.BasePageUtils;
import Utils.WaitUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    WebElement RecruitmentTab;

    // Find Add button Element
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement Addbtn;

    // Find Employee Full First Name field element
    @FindBy(name = "firstName")
    WebElement EmpFirstName;

    // Find Employee Middle Name field element
    @FindBy(name = "middleName")
    WebElement MiddleName;

    // Find Employee Last Name field element
    @FindBy(name = "lastName")
    WebElement LastName;

    // Find Employee Last Name field element
    @FindBy(name = "lastName")
    WebElement Email;

    // Find the resume upload element
//    @FindBy(xpath = "//input[@type='file']")
//    WebElement ResumeUpld;

    private  By resumeUpload = By.xpath("//input[@type='file']");

    // Find the save button element
    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement SaveButtonn;

    // Find the Candidates option element
    @FindBy(xpath = "//a[text()='Candidates']")
    WebElement Candidates;

    // Find Employee name field element
    @FindBy(xpath = "//label[text()='Candidate Name']/../following-sibling::div//input[@placeholder='Type for hints...']")
    WebElement CandidateName;

    // Find the Search button Element on PIM > Employee list page
    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement SearchButtn;

    // Find the Edit button element
    @FindBy(xpath = "//i[@class='oxd-icon bi-eye-fill']") //
    WebElement EyeButton;

    // Find the Edit button element
    @FindBy(xpath = "//button[text()=' Shortlist ']")
    WebElement ShortlistButton;

    // Find the save button element
    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement SaveButton;

    public void ClickOnRecruitmentTab() {
        wait.waitForElementToBeClickable(RecruitmentTab, 10);
        RecruitmentTab.click();
        log.info("Click on Recruitment Tab");
    }

    public void ClickOnAddBtn() {
        wait.waitForElementToBeClickable(Addbtn, 10);
        Addbtn.click();
        log.info("Click on Add Button");
    }

    public void EnterFirstName(String FName) {
        wait.waitForElementToBeVisible(EmpFirstName, 10);
        EmpFirstName.sendKeys(FName);
        log.info("Enter First Name:" + FName);
    }

    public void EnterMiddleName(String MName) {
        wait.waitForElementToBeVisible(MiddleName, 10);
        MiddleName.sendKeys(MName);
        log.info("Enter Middle Name:" + MName);
    }

    public void EnterLastName(String LName) {
        wait.waitForElementToBeVisible(LastName, 10);
        LastName.sendKeys(LName);
        log.info("Enter Last Name:" + LName);
    }

    public void SelectVacancy(String VacancyType) throws InterruptedException {
        Thread.sleep(3000);
        selectDropdownByLabel("Vacancy", VacancyType);
    }

    public void EnterEmail(String Email) throws InterruptedException {
        Thread.sleep(3000);
        enterTextByLabel("Email", Email);
    }

    public void EnterContactNo(String ContactNum) throws InterruptedException {
        Thread.sleep(3000);
        enterTextByLabel("Contact Number", ContactNum);
    }

    public void UploadResume(String upload) {
        WebElement File = wait.waitForPresenceOfElement(By.xpath(String.valueOf(resumeUpload)), 10);
        File.sendKeys(upload);
        log.info("Upload the resume");
    }

    public void ClickOnSaveButtonn() throws InterruptedException {
        wait.waitForElementToBeClickable(SaveButtonn, 10);
        SaveButtonn.click();
        log.info("Click on save button");
        Thread.sleep(3000);
    }

    public void ClickOnCandidatesOpn() throws InterruptedException {
        Thread.sleep(5000);
        wait.waitForElementToBeClickable(Candidates, 10);
        Candidates.click();
    }

    public void EnterCandidateName(String CanName) throws InterruptedException {
        wait.waitForElementToBeVisible(CandidateName, 10);
        CandidateName.sendKeys(CanName);
        Thread.sleep(3000);
        CandidateName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Enter Candidate Name:" + CanName);
    }

    public void ClickOnSearchButtonn() {
        wait.waitForElementToBeClickable(SearchButtn, 10);
        SearchButtn.click();
        log.info("Click on Search button");
    }

    public void ClickOnEyeBtn() {
        wait.waitForElementToBeClickable(EyeButton, 10);
        EyeButton.click();
        log.info("Click on Eye button button");
    }

    public void ClickOnShortlistBtn() throws InterruptedException {
        Thread.sleep(3000);
        wait.waitForElementToBeClickable(ShortlistButton, 10);
        ShortlistButton.click();
        log.info("Click on Shortlist button button");
    }

    public void SaveButn() {
        wait.waitForElementToBeClickable(SaveButton, 10);
        SaveButton.click();
        log.info("Click on Save button");
    }

}


