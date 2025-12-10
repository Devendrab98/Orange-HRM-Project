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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Slf4j
public class POM02_AdminPage extends BasePageUtils {
    private  WebDriver driver;
    private  WaitUtils wait;

    public POM02_AdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
        log.info("Admin Page initialized successfully.");
    }

    // ===== Locators =====

    // Find AdminTab Element
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement AdminTab;

    // Find Add button Element
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement AddBtn;

    // Add User > Find User Role element
    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[text()='-- Select --']")
    private WebElement UserRole;

    // User Role dropdown => Select Admin, //span[text()='Admin'] ,  //div[@role='listbox']//span[normalize-space()='Admin']
    @FindBy(xpath = "//div[@role='listbox']//span[normalize-space()='Admin']")
    private WebElement AdminOpt;

    // Find Status dropdown element
    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[text()='-- Select --']")
    private WebElement StatusDropD;

    // Status Dropdown => Select Enable value
    @FindBy(xpath = "//div[@role='listbox']//span[text()='Enabled']")
    private WebElement EnableOpt;

    // Find Password field element
    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div//input[@type='password']")
    private WebElement Passwrd;

    // Find Employee name element
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement EmployeeNm;

    // Find Username Element
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    private WebElement UserNam;

    // Find Confirm Password Element
    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div//input[@type='password']")
    private WebElement ConfimPass;

    // Find Save button Element
    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement SaveButton;

    // Find Username Element on Admin page
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    private WebElement UserNa;

    // Find the Search button Element on Admin page
    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement SearchBtn;

    // Find Created User List from Admin Tab, //div[@class='oxd-table']/div[@class='oxd-table-body'], //div[@role='table']/div[@role='row']
    @FindBy(xpath = "//div[@class='oxd-table']/div[@class='oxd-table-body']")
    private List<WebElement> ListOfUsers;

    // Find the element of Delete icon
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    private WebElement DeleteIcon;

    // Find the element of Delete button from delete user popup
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    private WebElement DeleteBtn;

    // Find the no result text element after delete the user
    @FindBy(xpath = "//span[text()='No Records Found']")
    private WebElement NoResultText;

    // Fetch the list => Ignore for now
    @FindBy(xpath = "//div[text()='-- Select --']")
    private List<WebElement> SelectDropdown;

    // ===== Actions =====

    @Step("Click on the Admin tab")
    public void ClickOnAdmin() throws InterruptedException {
        Thread.sleep(200);
        driver.navigate().refresh();
        wait.waitForElementToBeClickable(AdminTab, WaitUtils.TIMEOUT);
        AdminTab.click();
        log.info("Click on Admin Tab");
    }

    @Step("Click on Add button from admin tab")
    public void ClickOnAddBtn() {
        wait.waitForElementToBeClickable(AddBtn, WaitUtils.TIMEOUT);
        AddBtn.click();
        log.info("Click on Add Button");
    }

    @Step("Fetch the Admin page Url")
    public String GetAdminPageURL() {
        return driver.getCurrentUrl();
    }

    @Step("Fetch the Admin page Url")
    public String GetAddUserPageURL() {
        return driver.getCurrentUrl();
    }

    public void ClickOnUserRoleDropDown() {
        wait.waitForElementToBeClickable(UserRole, 10);
        UserRole.click();
    }

    @Step("Select the User Role dropdown value: {0}")
    public void ClickOnUserRoleDropDown(String UserRoleValue){
        selectDropdownByLabel("User Role", UserRoleValue);
        log.info("Click on User Role Dropdown");
        log.info("Select the 'Admin' option from the User role dropdown");
    }

    public void clickOnAdminOpt() {
        wait.waitForElementToBeClickable(AdminOpt, 10);
        AdminOpt.click();
    }

    public void ClickOnStatusDropDown() {
        wait.waitForElementToBeClickable(StatusDropD, 10);
        StatusDropD.click();

    }

    @Step("Select the Status dropdown value: {0}")
    public void ClickOnStatusDropDown(String StatusValue){
        selectDropdownByLabel("Status",StatusValue);
        log.info("Click on Status Dropdown");
        log.info("Select the 'Enable' option from the status dropdown");
    }

    public void ClickOnEnableOpt() {
        wait.waitForElementToBeClickable(EnableOpt, 10);
        EnableOpt.click();
    }

//    public void EnterPasword(String pass) {
//        wait.waitForElementToBeVisible(Passwrd, 10);
//        Passwrd.sendKeys(pass);
//        log.info("Enter Password:"+pass);
//    }

    @Step("Enter Password: {0}")
    public void EnterPasword(String Password){
        enterTextByLabel("Password", Password);
    }

    @Step("Enter Employee name: {0}")
    public void EnterEmployeeName(String EnpName) throws InterruptedException {
        wait.waitForElementToBeVisible(EmployeeNm, WaitUtils.TIMEOUT);
        EmployeeNm.clear();
        EmployeeNm.sendKeys(EnpName);
//        Thread.sleep(12000);
//        EmployeeNm.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
//        log.info("Select the Employee name:"+EnpName);

        // Wait for auto-suggest list instead of Thread.sleep(12000)
        WebDriverWait dropdownWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        dropdownWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']")));

        Thread.sleep(2000);
        EmployeeNm.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Select the Employee name:"+EnpName);

    }

//    public void EnterUsername(String UsrName) throws InterruptedException {
//        wait.waitForElementToBeVisible(UserNam, 10);
//        Thread.sleep(3000);
//        UserNam.sendKeys(UsrName);
//        log.info("Enter User name:"+UsrName);
//    }

    @Step("Enter User Name: {0}")
    public void EnterUsername(String UsrName) throws InterruptedException {
        Thread.sleep(2000);
        enterTextByLabel("Username", UsrName);
    }

//    public void EnterConfirmPassword(String Conpass) throws InterruptedException {
//        wait.waitForElementToBeVisible(ConfimPass, 10);
//        Thread.sleep(3000);
//        ConfimPass.sendKeys(Conpass);
//        log.info("Enter Confirm Password:"+Conpass);
//    }

    @Step("Enter Confirm Password: {0}")
    public void EnterConfirmPassword(String Conpass) throws InterruptedException {
        enterTextByLabel("Confirm Password", Conpass);
        log.info("Enter Confirm Password");
    }

//    public void ClickOnSaveButton() throws InterruptedException {
//        wait.waitForElementToBeClickable(SaveButton, 10);
//        Thread.sleep(5000);
//        SaveButton.click();
//        Thread.sleep(5000);
//        log.info("Click on the save button to create user");
//    }

    @Step("Click on the save button to create user")
    public void ClickOnSaveButton() throws InterruptedException {
        clickButtonByText("Save");
        log.info("Click on the save button to create user");

//        wait.waitForVisibilityOfAllElements(ListOfUsers, WaitUtils.TIMEOUT);
    }

//    @Step("Enter Created User Name: {0}")
//    public void EnterUserNmForSearch(String UserNameAd) throws InterruptedException {
//        wait.waitForElementToBeVisible(UserNa, 10);
//        UserNa.sendKeys(UserNameAd);
//        Thread.sleep(2000);
//        log.info("Enter the created user name:"+UserNameAd);
//    }

    @Step("Enter Created User Name: {0}")
    public void EnterUserNmForSearch(String UserNameAd) throws InterruptedException {
        Thread.sleep(2000);
        enterTextByLabel("Username", UserNameAd);
        log.info("Enter the created user name: {}", UserNameAd);
    }

    @Step("Click on search button")
    public void ClickOnSearchBtn() throws InterruptedException {
        Thread.sleep(2000);
        clickButtonByText("Search");
        log.info("Click on search button");
    }

    @Step("Fetch the user list")
    public String UserList() throws InterruptedException {
        wait.waitForVisibilityOfAllElements(ListOfUsers, WaitUtils.TIMEOUT);
        System.out.println("Total User:" + ListOfUsers.size());

        StringBuilder sb = new StringBuilder();
        for (WebElement List : ListOfUsers) {
            sb.append(List.getText()).append("\n");
        }
        return sb.toString();
    }

    @Step("Clicked on the Delete icon")
    public void ClickOnDeleteIcon() {
        wait.waitForElementToBeClickable(DeleteIcon, WaitUtils.TIMEOUT).click();
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

    @Step("User Deleted Successfully.")
    public void DeleteUrs(){
        clickButtonByText("Yes, Delete");
        log.info("User Deleted Successfully.");
    }

    @Step("Print no result text")
    public String PrintNoResult() {
        wait.waitForElementToBeVisible(NoResultText, WaitUtils.TIMEOUT);
        String text = NoResultText.getText();
        log.info("No result text: {}", text);
        return text;
    }
}
