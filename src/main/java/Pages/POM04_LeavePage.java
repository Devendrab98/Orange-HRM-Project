package Pages;

import Utils.WaitUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class POM04_LeavePage {

    WebDriver driver;
    WaitUtils wait;

    public POM04_LeavePage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
        log.info("PIM Page initialized successfully.");
    }

    // Find Leave tab element
    @FindBy(xpath = "//span[text()='Leave']")
    WebElement LeaveTab;

    // Find Entitlements dropdown element
    @FindBy(xpath = "//span[text()='Entitlements ']")
    WebElement Entitlements;

    // Find Add Entitlements dropdown element
    @FindBy(xpath = "//a[text()='Add Entitlements']")
    WebElement AddEntitlements;

    // Find Employee name element
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement EmployeeNAme;

    // Find Leave Type element
    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[text()='-- Select --']")
    List<WebElement> LeaveType;

    // Find LeavePeriod element
    @FindBy(xpath = "//label[text()='Leave Period']/../following-sibling::div//div[text()='-- Select --']")
    List<WebElement> LeavePeriod;

    // Find EntitlementValue element
    @FindBy(xpath = "//label[text()='Entitlement']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    WebElement EntitlementValue;

    // Find the save button element
    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement SaVeButtonn;

    public void ClickOnLeaveTab() {
        wait.waitForElementToBeClickable(LeaveTab, 10);
        LeaveTab.click();
        log.info("Click on leave tab");
    }

    public void ClickOnEntitlementsOpn() {
        wait.waitForElementToBeClickable(Entitlements, 10);
        Entitlements.click();
        log.info("Click on Entitlements Option");
    }

    public void ClickOnAddEntitlementsOpn() {
        wait.waitForElementToBeClickable(AddEntitlements, 10);
        AddEntitlements.click();
        log.info("Click on Add Entitlements Option");
    }

    public void EnterEmployeeNAme(String EMPName) throws InterruptedException {
        wait.waitForElementToBeVisible(EmployeeNAme, 10);
        Thread.sleep(5000);
        EmployeeNAme.sendKeys(EMPName);
        EmployeeNAme.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Enter Employee Name:" + EMPName);
    }

    public void SelectLeaveType(String ExpectedLeave) {
        wait.waitForVisibilityOfAllElements(LeaveType, 10);
        System.out.println("Number of leave type:" + LeaveType.size());

        boolean found = false;
        for (WebElement listOfLeave : LeaveType) {
            System.out.println("All Leave type:" + listOfLeave.getText());
            if (listOfLeave.getText().equalsIgnoreCase(ExpectedLeave)) {
                listOfLeave.click();
                System.out.println("Leave type '" + ExpectedLeave + "' found and selected!");
                break;
            }
        }
        if (!found) {
            System.out.println("Leave type '" + ExpectedLeave + "' not found in the list!");
        }
    }

    public void SelectLeavePeriod(String ExpectedPeriod) {
        wait.waitForVisibilityOfAllElements(LeavePeriod, 10);
        System.out.println("Number of Leave Period:" + LeavePeriod.size());

        boolean found = false;
        for (WebElement listOfLeavePrd : LeavePeriod) {
            System.out.println("All Leave Period:" + listOfLeavePrd.getText());
            if (listOfLeavePrd.getText().equalsIgnoreCase(ExpectedPeriod)) {
                listOfLeavePrd.click();
                System.out.println("Leave Period '" + ExpectedPeriod + "' found and selected!");
                break;
            }
        }
        if (!found) {
            System.out.println("Leave Period '" + ExpectedPeriod + "' not found in the list!");
        }
    }

    public void EnterEntitlementValue(int Number) {
        wait.waitForElementToBeVisible(EntitlementValue, 10);
        EntitlementValue.sendKeys(String.valueOf(Number));
        log.info("Enter the Entitlement Value:" + Number);
    }

    public void ClickOnSaveButton() {
        wait.waitForElementToBeClickable(SaVeButtonn, 10);
        SaVeButtonn.click();
        log.info("Click on save button");
    }
}
