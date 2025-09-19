package Pages;

import Utils.WaitUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
@Slf4j
public class POC02_AdminPage {
    WebDriver driver;
    WaitUtils wait;

    public POC02_AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
        log.info("Admin Page initialized successfully.");
    }

    // Find AdminTab Element
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement AdminTab;

    // Find Add button Element
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement AddBtn;

    // Add User > Find User Role element
    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[text()='-- Select --']")
    WebElement UserRole;

    // User Role dropdown => Select Admin, //span[text()='Admin'] ,  //div[@role='listbox']//span[normalize-space()='Admin']
    @FindBy(xpath = "//div[@role='listbox']//span[normalize-space()='Admin']")
    WebElement AdminOpt;

    // Find Status dropdown element
    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[text()='-- Select --']")
    WebElement StatusDropD;

    // Status Dropdown => Select Enable value
    @FindBy(xpath = "//div[@role='listbox']//span[text()='Enabled']")
    WebElement EnableOpt;

    // Find Password field element
    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div//input[@type='password']")
    WebElement Passwrd;

    // Find Employee name element
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement EmployeeNm;

    // Find Username Element
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    WebElement UserNam;

    // Find Confirm Password Element
    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div//input[@type='password']")
    WebElement ConfimPass;

    // Find Save button Element
    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement SaveButton;

    // Find Username Element on Admin page
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    WebElement UserNa;

    // Find the Search button Element on Admin page
    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement SearchBtn;

    // Find Created User List from Admin Tab, //div[@class='oxd-table']/div[@class='oxd-table-body'], //div[@role='table']/div[@role='row']
    @FindBy(xpath = "//div[@class='oxd-table']/div[@class='oxd-table-body']")
    List<WebElement> ListOfUsers;

    // Find the element of Delete icon
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement DeleteIcon;

    // Find the element of Delete button from delete user popup
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    WebElement DeleteBtn;

    // Find the no result text element after delete the user
    @FindBy(xpath = "//span[text()='No Records Found']")
    WebElement NoResultText;

    // Fetch the list => Ignore for now
    @FindBy(xpath = "//div[text()='-- Select --']")
    List<WebElement> SelectDropdown;


    public void ClickOnAdmin() {
        wait.waitForElementToBeClickable(AdminTab, 10);
        AdminTab.click();
        log.info("Click on Admin Tab");
    }

    public void ClickOnAddBtn() {
        wait.waitForElementToBeClickable(AddBtn, 10);
        AddBtn.click();
        log.info("Click on Add Button");
    }

    public String GetAdminPageURL() {
        return driver.getCurrentUrl();
    }

    public String GetAddUserPageURL() {
        return driver.getCurrentUrl();
    }

    public void ClickOnUserRoleDropDown() {
        wait.waitForElementToBeClickable(UserRole, 10);
        UserRole.click();
        log.info("Click on User Role Dropdown");
    }

    public void clickOnAdminOpt() {
        wait.waitForElementToBeClickable(AdminOpt, 10);
        AdminOpt.click();
        log.info("Select the 'Admin' option from the User role dropdown");

    }

    public void ClickOnStatusDropDown() {
        wait.waitForElementToBeClickable(StatusDropD, 10);
        StatusDropD.click();
        log.info("Click on Status Dropdown");

    }

    public void ClickOnEnableOpt() {
        wait.waitForElementToBeClickable(EnableOpt, 10);
        EnableOpt.click();
        log.info("Select the 'Enable' option from the status dropdown");

    }

    public void EnterPasword(String pass) {
        wait.waitForElementToBeVisible(Passwrd, 10);
        Passwrd.sendKeys(pass);
        log.info("Enter Password:"+pass);
    }

    public void EnterEmployeeName(String EnpName) throws InterruptedException {
        wait.waitForElementToBeVisible(EmployeeNm, 10);
        EmployeeNm.sendKeys(EnpName);
        Thread.sleep(12000);
        EmployeeNm.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Select the Employee name:"+EnpName);
    }

    public void EnterUsername(String UsrName) throws InterruptedException {
        wait.waitForElementToBeVisible(UserNam, 10);
        Thread.sleep(3000);
        UserNam.sendKeys(UsrName);
        log.info("Enter User name:"+UsrName);
    }

    public void EnterConfirmPassword(String Conpass) throws InterruptedException {
        wait.waitForElementToBeVisible(ConfimPass, 10);
        Thread.sleep(3000);
        ConfimPass.sendKeys(Conpass);
        log.info("Enter Confirm Password:"+Conpass);
    }

    public void ClickOnSaveButton() throws InterruptedException {
        wait.waitForElementToBeClickable(SaveButton, 10);
        Thread.sleep(5000);
        SaveButton.click();
        Thread.sleep(5000);
        log.info("Click on the save button to create user");
    }

    public void EnterUserNmForSearch(String UserNameAd) throws InterruptedException {
        wait.waitForElementToBeVisible(UserNa, 10);
        UserNa.sendKeys(UserNameAd);
        Thread.sleep(2000);
        log.info("Enter the created user name:"+UserNameAd);
    }

    public void ClickOnSearchBtn() throws InterruptedException {
        wait.waitForElementToBeClickable(SearchBtn, 10);
        SearchBtn.click();
        Thread.sleep(3000);
        SearchBtn.click();
        log.info("Click on search button");
    }

    public String UserList() throws InterruptedException {
        Thread.sleep(3000);
        wait.waitForVisibilityOfAllElements(ListOfUsers, 10);
        System.out.println("Total User:" + ListOfUsers.size());

        StringBuilder sb = new StringBuilder();
        for (WebElement List : ListOfUsers) {
            sb.append(List.getText()).append("\n");
        }
        return sb.toString();
    }

    public void DeleteUser() {
        wait.waitForElementToBeClickable(DeleteIcon, 10).click();
        wait.waitForElementToBeClickable(DeleteBtn, 10).click();
        log.info("User deleted successfully");
//        wait.until(ExpectedConditions.visibilityOf(NoResultText));
//        String actualText = NoResultText.getText();
//        String ExpectedText = "No Records Found";
//
//        if (actualText.equals(ExpectedText)) {
//            System.out.println("No Result text is found & matched:" + actualText);
//        } else {
//            System.out.println("Text is not matched. Expected: " + ExpectedText + ", but got: " + actualText);
//        }
    }

    public String PrintNoResult() {
        wait.waitForElementToBeVisible(NoResultText, 10);
        return NoResultText.getText();
    }

    public void ClickOnUserRoleDropD() {
        wait.waitForElementToBeClickable(UserRole, 10).click();
        wait.waitForElementToBeClickable(AdminOpt, 10).click();

    }
}
