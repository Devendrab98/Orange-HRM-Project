package Pages;

import Utils.BasePageUtils;
import Utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class POM04_LeavePage extends BasePageUtils {

    WebDriver driver;
    WaitUtils wait;

    public POM04_LeavePage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
        log.info("PIM Page initialized successfully.");
    }

    // Find Leave tab element
    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement LeaveTab;

    // Find Entitlements dropdown element
    @FindBy(xpath = "//span[text()='Entitlements ']")
    private WebElement Entitlements;

    // Find Add Entitlements dropdown element
    @FindBy(xpath = "//a[text()='Add Entitlements']")
    private WebElement AddEntitlements;

    // Find Employee name element
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement EmployeeNAme;

    // Find Leave Type element
    @FindBy(xpath = "//label[text()='Leave Type']/../following-sibling::div//div[text()='-- Select --']")
    private List<WebElement> LeaveType;

    // Find LeavePeriod element
    @FindBy(xpath = "//label[text()='Leave Period']/../following-sibling::div//div[text()='-- Select --']")
    private List<WebElement> LeavePeriod;

    // Find EntitlementValue element
    @FindBy(xpath = "//label[text()='Entitlement']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    private WebElement EntitlementValue;

    // Find the save button element
    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement SaVeButtonn;

    // Find the Confirm Button after add leave for employee
    @FindBy(xpath = "//button[text()=' Confirm ']")
    private WebElement ConfirmButton;

    // Find User leave List from the Leave Tab,
    @FindBy(xpath = "//div[@class='oxd-table']/div[@class='oxd-table-body']")
    private List<WebElement> ListOfLeave;

    // Find the result text element
    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[@class='oxd-text oxd-text--span']")
    private WebElement resultTxt;

    @Step("Click on the leave tab")
    public void ClickOnLeaveTab() {
        wait.waitForElementToBeClickable(LeaveTab, WaitUtils.TIMEOUT);
        LeaveTab.click();
        log.info("Click on leave tab");
    }

    @Step("Click on Entitlements Option")
    public void ClickOnEntitlementsOpn() {
        wait.waitForElementToBeClickable(Entitlements, WaitUtils.TIMEOUT);
        Entitlements.click();
        log.info("Click on Entitlements Option");
    }

    @Step("Click on Add Entitlements Option")
    public void ClickOnAddEntitlementsOpn() {
        wait.waitForElementToBeClickable(AddEntitlements, WaitUtils.TIMEOUT);
        AddEntitlements.click();
        log.info("Click on Add Entitlements Option");
    }

    @Step("Enter Employee Name: {0}")
    public void EnterEmployeeNAme(String EMPName) throws InterruptedException {
        wait.waitForElementToBeVisible(EmployeeNAme, WaitUtils.TIMEOUT);
        EmployeeNAme.sendKeys(EMPName);
        Thread.sleep(5000);
        EmployeeNAme.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Enter Employee Name:" + EMPName);
    }

    @Step("Select Leave type: {0}")
    public void SelectLeaveType(String LeaveType) {
        selectDropdownByLabel("Leave Type", LeaveType);
    }

    @Step("Select Leave Period: {0}")
    public void SelectLeavePeriod(String LeavePeriod) {
        selectDropdownByLabel("Leave Period", LeavePeriod);
    }

    @Step("Enter the Entitlement Value: {0}")
    public void EnterEntitlementValue(int Number) {
        wait.waitForElementToBeVisible(EntitlementValue, WaitUtils.TIMEOUT);
        EntitlementValue.sendKeys(String.valueOf(Number));
        log.info("Enter the Entitlement Value:" + Number);
    }

    //    public void ClickOnSaveButton() {
//        wait.waitForElementToBeClickable(SaVeButtonn, 10);
//        SaVeButtonn.click();
//        log.info("Click on save button");
//    }
    @Step("Click on the save button")
    public void ClickOnSaveButton() {
        clickButtonByText("Save");
        log.info("Click on save button");
    }

//    public void ClickOnConfirmBtn() {
//        wait.waitForElementToBeClickable(ConfirmButton, 10);
//        ConfirmButton.click();
//        log.info("Click on Confirm Button button");
//    }

    @Step("Confirm Button")
    public void ClickOnConfirmBtn() {
        clickButtonByText("Confirm");
        log.info("Click on Confirm Button");
    }

    @Step("Get Result Text")
    public void GetResultText() throws InterruptedException {
        Thread.sleep(3000);
        wait.waitForElementToBeVisible(resultTxt, WaitUtils.TIMEOUT);
        System.out.println("Leave result:" + resultTxt.getText());
    }

    @Step("Fetch the Leave List")
    public void ListOFLeave() throws InterruptedException {
        wait.waitForVisibilityOfAllElements(ListOfLeave, WaitUtils.TIMEOUT);
        System.out.println("Total leave:" + ListOfLeave.size());

        for (WebElement listt : ListOfLeave) {
            System.out.println("Leave created result:" + listt.getText());
        }
    }
}
