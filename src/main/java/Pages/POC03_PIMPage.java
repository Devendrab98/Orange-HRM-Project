package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class POC03_PIMPage {
    WebDriver driver;
    WebDriverWait wait;

    public POC03_PIMPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Find PIM tab element
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement PimTab;

    // Find Add button Element
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement AddButton;

    // Find PIM tab tile element
    @FindBy(xpath = "//h6[text()='PIM']")
    WebElement PIMTabTitle;

    // Find Employee Full First Name field element
    @FindBy(name = "firstName")
    WebElement EmpFirstName;

    // Find Employee Middle Name field element
    @FindBy(name = "middleName")
    WebElement MiddleName;

    // Find Employee Last Name field element
    @FindBy(name = "lastName")
    WebElement LastName;

    // Find Employee ID field element on Create employee page
    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    WebElement EmpID;

    // Find the save button element
    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement SaveButtonn;

    // Find Employee list option element
    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement EmpListopt;

    // Find Employee ID field element on Employee list page
    @FindBy(xpath = "//label[@class='oxd-label']/../following-sibling::div//input[@class='oxd-input oxd-input--active']")
    WebElement EmployeeIDD;

    // Find the Search button Element on PIM > Employee list page
    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement SearchButtn;

    // Find the Employee name field element to search created user
    @FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input[@placeholder='Type for hints...']")
    WebElement EmployeeName;


    public void ClickOnPimTab() {
        wait.until(ExpectedConditions.elementToBeClickable(PimTab));
        PimTab.click();
    }

    public void ClickOnAddBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(AddButton));
        AddButton.click();
    }

    public void GetPimTabTitle() {
        wait.until(ExpectedConditions.visibilityOf(PIMTabTitle));
        System.out.println("PIM page title: " + PIMTabTitle.getText());
    }

    public void EnterFirstName(String FName) {
        wait.until(ExpectedConditions.visibilityOf(EmpFirstName));
        EmpFirstName.sendKeys(FName);
    }

    public void EnterMiddleName(String MName) {
        wait.until(ExpectedConditions.visibilityOf(MiddleName));
        MiddleName.sendKeys(MName);
    }

    public void EnterLastName(String LName) {
        wait.until(ExpectedConditions.visibilityOf(LastName));
        LastName.sendKeys(LName);
    }

    public void EnterEmployeeID(String EmployeeID) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(EmpID));
        EmpID.sendKeys(Keys.CONTROL+ "a", Keys.BACK_SPACE);
        EmpID.sendKeys(EmployeeID);
    }

    public void ClickonSaveButtonn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(SaveButtonn));
        SaveButtonn.click();
        Thread.sleep(2000);
    }

    public void ClickOnEmplyList(){
        wait.until(ExpectedConditions.elementToBeClickable(EmpListopt));
        EmpListopt.click();
    }

    public void EnterEmpID(String EmplyID) throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(EmployeeIDD));
        EmployeeIDD.sendKeys(EmplyID);
    }

    public void ClickOnSearchButtonn() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchButtn));
        SearchButtn.click();
    }
}
