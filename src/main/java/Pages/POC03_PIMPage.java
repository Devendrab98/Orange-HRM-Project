package Pages;

import Utils.BasePageUtils;
import Utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v136.page.model.Screenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class POC03_PIMPage extends BasePageUtils {
    WebDriver driver;
    WaitUtils wait;

    public POC03_PIMPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtils(driver);
        log.info("PIM Page initialized successfully.");
    }

    // Find PIM tab element
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement PimTab;

    // Find Add button Element
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement AddButton;

    // Find PIM tab tile element
    @FindBy(xpath = "//h6[text()='PIM']")
    private WebElement PIMTabTitle;

    // Find Profile picture element
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@type='file']")
    private WebElement Profile;

    // Find Employee Full First Name field element
    @FindBy(name = "firstName")
    private WebElement EmpFirstName;

    // Find Employee Middle Name field element
    @FindBy(name = "middleName")
    private WebElement MiddleName;

    // Find Employee Last Name field element
    @FindBy(name = "lastName")
    private WebElement LastName;

    // Find Employee ID field element on Create employee page
    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    private WebElement EmpID;

    // Find the Create login details switch
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    private WebElement CreateLogin;

    // Find the User name element under create login details
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    private WebElement UserNAme;

    // Find the Password field element
    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div//input[@type='password']")
    private WebElement Password;

    // Find the Confirm Password field element
    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div//input[@type='password']")
    private WebElement ConfirmPassword;

    // Find the save button element
    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement SaveButtonn;

    // Find Employee list option element
    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement EmpListopt;

    // Find Employee ID field element on Employee list page
    @FindBy(xpath = "//label[@class='oxd-label']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    private WebElement EmployeeIDD;

    // Find Employee name field element
    @FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input[@placeholder='Type for hints...']")
    private WebElement EmployeeNamefl;

    // Find the Search button Element on PIM > Employee list page
    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement SearchButtn;

    // Find the Edit button element
    @FindBy(xpath = "//i[@class='oxd-icon bi-pencil-fill']")
    private WebElement EditButton;

    // Find the Job option Element
    @FindBy(xpath = "//a[normalize-space()='Job']")
    private WebElement JobOption;

    // Find Job title dropdown element
    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div//div[text()='-- Select --']")
    private WebElement JobTitle;

    // Find the dropdown option element
    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement DropdownOptions;

    // Find the save button element from job option
    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement SaveBtn;

    // Find the Employee name field element to search created user
    @FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input[@placeholder='Type for hints...']")
    private WebElement EmployeeName;


    @Step("Click on the PIM tab")
    public void ClickOnPimTab() {
        wait.waitForElementToBeClickable(PimTab, 10);
        PimTab.click();
        log.info("Click on PIM Tab");
    }

    @Step("Click on Add Button")
    public void ClickOnAddBtn() {
        wait.waitForElementToBeClickable(AddButton, 10);
        AddButton.click();
        log.info("Click on Add Button");
    }

    @Step("Get PIM page title")
    public void GetPimTabTitle() {
        wait.waitForElementToBeVisible(PIMTabTitle, 10);
        System.out.println("PIM page title: " + PIMTabTitle.getText());
    }

//    public void UploadProfile(String Picture) throws InterruptedException {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@type='file']")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", Profile);
//        Thread.sleep(2000);
//        Profile.sendKeys(Picture);
//    }

    @Step("Enter First Name: {0}")
    public void EnterFirstName(String FName) {
        wait.waitForElementToBeVisible(EmpFirstName, 10);
        EmpFirstName.sendKeys(FName);
        log.info("Enter First Name:" + FName);
    }

    @Step("Enter Middle Name: {0}")
    public void EnterMiddleName(String MName) {
        wait.waitForElementToBeVisible(MiddleName, 10);
        MiddleName.sendKeys(MName);
        log.info("Enter Middle Name:" + MName);
    }

    @Step("Enter Last Name: {0}")
    public void EnterLastName(String LName) {
        wait.waitForElementToBeVisible(LastName, 10);
        LastName.sendKeys(LName);
        log.info("Enter Last Name:" + LName);
    }

//    public void EnterEmployeeID(String EmployeeID) throws InterruptedException {
//        wait.waitForElementToBeVisible(EmpID, 10);
//        EmpID.sendKeys(EmployeeID);
//        log.info("Enter Employee ID:" + EmployeeID);
//    }

    @Step("Enter Employee Id: {0}")
    public void EnterEmployeeID(String EmpId){
        enterTextByLabel("Employee Id", EmpId);
    }

    @Step("Enable Create login switch to create the password for the create user")
    public void EnableCreateLoginSwitch() {
        wait.waitForElementToBeClickable(CreateLogin, 10);
        CreateLogin.click();
        log.info("Enable Create login switch to create the password for the create user");
    }

//    public void EnterUsername(String UName) {
//        wait.waitForElementToBeVisible(UserNAme, 10);
//        UserNAme.sendKeys(UName);
//        log.info("Enter the User name:" + UName);
//    }

    @Step("Enter User Name: {0}")
    public void EnterUsername(String UName){
        enterTextByLabel("Username", UName);
    }

    @Step("Enter Password: {0} and Confirm Password: {1}")
    public void EnterPassword(String Pass, String ConfirmPass) {
        wait.waitForElementToBeClickable(Password, 10);
        Password.sendKeys(Pass);
        log.info("Enter Password:" + Pass);

        wait.waitForElementToBeClickable(ConfirmPassword, 10);
        ConfirmPassword.sendKeys(ConfirmPass);
        log.info("Enter Confirm Password:" + ConfirmPass);
    }

    @Step("Click on the save button")
    public void ClickOnSaveButton(){
        clickButtonByText("Save");
        log.info("Click on save button");
    }

    @Step("Click on Employee list tab")
    public void ClickOnEmplyList() throws InterruptedException {
        Thread.sleep(7000);
        wait.waitForElementToBeClickable(EmpListopt, 10);
        EmpListopt.click();
        log.info("Click on Employee list tab");
    }

    @Step("Enter Employee id")
    public void EnterEmpID(String EmplyID) throws InterruptedException {
        Thread.sleep(2000);
        wait.waitForElementToBeVisible(EmployeeIDD, 10);
        EmployeeIDD.sendKeys(EmplyID);
        log.info("Enter Employee id:" + EmplyID);
    }

    @Step("Enter Employee Name: {0}")
    public void EmployeeNameField(String EmplyName) throws InterruptedException {
        wait.waitForElementToBeVisible(EmployeeNamefl, 10);
        Thread.sleep(5000);
        EmployeeNamefl.sendKeys(EmplyName);
        EmployeeNamefl.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Enter Employee Name:" + EmplyName);
    }

    @Step("Click on Search button")
    public void ClickOnSearchButtonn() {
        wait.waitForElementToBeClickable(SearchButtn, 10);
        SearchButtn.click();
        log.info("Click on Search button");
    }

    @Step("Click on Edit button button")
    public void ClickOnEditBtn() {
        wait.waitForElementToBeClickable(EditButton, 10);
        EditButton.click();
        log.info("Click on Edit button button");
    }

    @Step("Click on Job option")
    public void ClickOnJobOpn() {
        wait.waitForElementToBeClickable(JobOption, 10);
        JobOption.click();
        log.info("Click on Job option");
    }

//    @Step("Select Job Title: {0}")
//    public void SelectJobTitle(String SelectedJobTitle) throws InterruptedException {
//        Thread.sleep(3000);
//        wait.waitForElementToBeClickable(JobTitle, 10).click();
//
//        // Select the option
//        WebElement SelectedOption = wait.waitForElementToBeClickableBy(
//                By.xpath("//div[@role='listbox']//span[text()='" + SelectedJobTitle + "']"), 10);
//
//        SelectedOption.click();
//        System.out.println("Selected Job Title: " + SelectedOption);
//    }

    @Step("Select the Job Title dropdown value: {0}")
    public void SelectJobTitle(String SelectedJobTitle){
        selectDropdownByLabel("Job Title", SelectedJobTitle);
        log.info("Click on User Job Title Dropdown");
        log.info("Select the 'QA Engineer' option from the User role dropdown");
    }

    @Step("Click on Save button to update the user information")
    public void ClickonSaveBtn() throws IOException {
        clickButtonByText("Save");
        log.info("Click on Save button to update the user information");

//        File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(Screenshot, new File("New File.png"));
    }
}
