package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class POC02_AdminPage {
    WebDriver driver;
    WebDriverWait wait;

    public POC02_AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
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
        wait.until(ExpectedConditions.elementToBeClickable(AdminTab));
        AdminTab.click();
    }

    public void ClickOnAddBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(AddBtn));
        AddBtn.click();
    }

    public String GetAdminPageURL() {
        return driver.getCurrentUrl();
    }

    public String GetAddUserPageURL() {
        return driver.getCurrentUrl();
    }

    public void ClickOnUserRoleDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(UserRole));
        UserRole.click();
    }

    public void clickOnAdminOpt() {
        wait.until(ExpectedConditions.elementToBeClickable(AdminOpt));
        AdminOpt.click();
    }

    public void ClickOnStatusDropDown() {
        wait.until(ExpectedConditions.elementToBeClickable(StatusDropD));
        StatusDropD.click();
    }

    public void ClickOnEnableOpt() {
        wait.until(ExpectedConditions.elementToBeClickable(EnableOpt));
        EnableOpt.click();
    }

    public void EnterPasword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(Passwrd));
        Passwrd.sendKeys(pass);
    }

    public void EnterEmployeeName(String EnpName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(EmployeeNm));
        EmployeeNm.sendKeys(EnpName);
        Thread.sleep(12000);
        EmployeeNm.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

    }

    public void EnterUsername(String UsrName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(UserNam));
        Thread.sleep(3000);
        UserNam.sendKeys(UsrName);
    }

    public void EnterConfirmPassword(String Conpass) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ConfimPass));
        Thread.sleep(3000);
        ConfimPass.sendKeys(Conpass);
    }

    public void ClickOnSaveButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        Thread.sleep(5000);
        SaveButton.click();
        Thread.sleep(5000);
    }

    public void EnterUserNmForSearch(String UserNameAd) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(UserNa));
        UserNa.sendKeys(UserNameAd);
        Thread.sleep(2000);
    }

    public void ClickOnSearchBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(SearchBtn));
        SearchBtn.click();
        Thread.sleep(3000);
        SearchBtn.click();
    }

    public String UserList() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfAllElements(ListOfUsers));
        System.out.println("Total User:" + ListOfUsers.size());

        StringBuilder sb = new StringBuilder();
        for (WebElement List : ListOfUsers) {
            sb.append(List.getText()).append("\n");
        }
        return sb.toString();
    }

    public void DeleteUser() {
        wait.until(ExpectedConditions.elementToBeClickable(DeleteIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DeleteBtn)).click();
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
        wait.until(ExpectedConditions.visibilityOf(NoResultText));
        return NoResultText.getText();
    }

    public void ClickOnUserRoleDropD() {
        wait.until(ExpectedConditions.elementToBeClickable(UserRole)).click();
        wait.until(ExpectedConditions.elementToBeClickable(AdminOpt)).click();

    }
}
