package Pages;

import Utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class POM01_LoginPage {

    WebDriver driver;
    WaitUtils wait;

    public POM01_LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
        log.info("Login Page initialized successfully.");
    }

    // Find Username
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    // Find Password
    @FindBy(name = "password")
    private WebElement passwordField;

    // Find Login Button
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginbtn;

    // Find Dashboard text
    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement Title;

    // Find Profile dropdown Element
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement Profile;

    // Find Logout Element
    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']//a[text()='Logout']")
    private WebElement Logout;

    // Find Username
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    private WebElement InvalidErrorMsg;

    // --- Actions (Public) ---

    @Step("Enter UserName:{0}")
    public void EnterUsername(String usernm) {
        wait.waitForElementToBeVisible(usernameField, WaitUtils.TIMEOUT);
        usernameField.clear();
        usernameField.sendKeys(usernm);
        log.info("Entered User Name:"+usernm);
    }

    @Step("Enter Password:{0}")
    public void EnterPassword(String pass) {
        wait.waitForElementToBeVisible(passwordField, WaitUtils.TIMEOUT);
        passwordField.clear();
        passwordField.sendKeys(pass);
        log.info("Entered Password:"+pass);
    }

    @Step("Click on Login button")
    public void ClickOnLoginButton() {
        wait.waitForElementToBeClickable(loginbtn, WaitUtils.TIMEOUT);
        loginbtn.click();
        log.info("Clicked on login button");
    }

    @Step("Get page title")
    public String GetTitle() {
        wait.waitForElementToBeVisible(Title, WaitUtils.TIMEOUT);
        return Title.getText();
    }

    @Step("Click on Profile")
    public void ClickOnProfile() {
        wait.waitForElementToBeClickable(Profile, WaitUtils.TIMEOUT);
        Profile.click();
        log.info("Click on login Profile icon");
    }

    @Step("Clicked on Logout Option")
    public void ClickOnLogout() {
        wait.waitForElementToBeClickable(Logout, WaitUtils.TIMEOUT);
        Logout.click();
        log.info("Clicked on Logout button");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Get Invalid Login Error Message")
    public String getErrorMessage(){

        wait.waitForElementToBeVisible(InvalidErrorMsg, WaitUtils.TIMEOUT);
        String text = InvalidErrorMsg.getText();
        log.info("Error Message captured: "+ text);
        return text;
    }

    @Step("Login with invalid Credentials username:{0} and password:{1}")
    public void InvalidLogin(String user, String pass){
        EnterUsername(user);
        EnterPassword(pass);
        ClickOnLoginButton();
    }
}

