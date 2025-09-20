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
    @FindBy(xpath = "//label[text()='Leave Type']/../following-sibling::div//div[text()='-- Select --']")
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

    // Find the Confirm Button after add leave for employee
    @FindBy(xpath = "//button[text()=' Confirm ']")
    WebElement ConfirmButton;

    // Find User leave List from the Leave Tab,
    @FindBy(xpath = "//div[@class='oxd-table']/div[@class='oxd-table-body']")
    List<WebElement> ListOfLeave;

    // Find the result text element
    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[@class='oxd-text oxd-text--span']")
    WebElement resultTxt;

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
        EmployeeNAme.sendKeys(EMPName);
        Thread.sleep(5000);
        EmployeeNAme.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Enter Employee Name:" + EMPName);
    }

//    public void SelectLeaveType(String ExpectedLeave) throws InterruptedException {
//        wait.waitForVisibilityOfAllElements(LeaveType, 10);
//        System.out.println("Number of leave type:" + LeaveType.size());
//
//        boolean found = false;
//        for (WebElement listOfLeave : LeaveType) {
//            System.out.println("All Leave type:" + listOfLeave);
//            if (listOfLeave.getText().equalsIgnoreCase(ExpectedLeave)) {
//                listOfLeave.click();
//                Thread.sleep(4000);
//                System.out.println("Leave type '" + ExpectedLeave + "' found and selected!");
//                break;
//            }
//        }
//        if (!found) {
//            System.out.println("Leave type '" + ExpectedLeave + "' not found in the list!");
//        }
//    }

    public void SelectLeaveType(String LeaveType) {
        selectDropdownByLabel("Leave Type", LeaveType);
    }

    public void SelectLeavePeriod(String LeavePeriod) {
        selectDropdownByLabel("Leave Period", LeavePeriod);
    }

//    public void SelectLeavePeriod(String ExpectedPeriod) throws InterruptedException {
//        wait.waitForVisibilityOfAllElements(LeavePeriod, 10);
//        System.out.println("Number of Leave Period:" + LeavePeriod.size());
//
//        boolean found = false;
//        for (WebElement listOfLeavePrd : LeavePeriod) {
//            System.out.println("All Leave Period:" + listOfLeavePrd);
//            if (listOfLeavePrd.getText().equalsIgnoreCase(ExpectedPeriod)) {
//                listOfLeavePrd.click();
//                Thread.sleep(4000);
//                System.out.println("Leave Period '" + ExpectedPeriod + "' found and selected!");
//                break;
//            }
//        }
//        if (!found) {
//            System.out.println("Leave Period '" + ExpectedPeriod + "' not found in the list!");
//        }
//    }

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

    public void ClickOnConfirmBtn() {
        wait.waitForElementToBeClickable(ConfirmButton, 10);
        ConfirmButton.click();
        log.info("Click on Confirm Button button");
    }

    public void GetResultText() throws InterruptedException {
        Thread.sleep(3000);
        wait.waitForElementToBeVisible(resultTxt, 10);
        System.out.println("Leave result:" + resultTxt.getText());
    }

    public void ListOFLeave() {
        wait.waitForVisibilityOfAllElements(ListOfLeave, 10);
        System.out.println("Total leave:" + ListOfLeave.size());

        for (WebElement listt : ListOfLeave) {
            System.out.println("Leave created result:" + listt.getText());
        }


    }
}
