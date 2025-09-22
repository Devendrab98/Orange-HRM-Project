package Pages;

import Utils.WaitUtils;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

@Slf4j
public class POC01_LoginPage {

    WebDriver driver;
    WaitUtils wait;

    public POC01_LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
        log.info("Login Page initialized successfully.");
    }

    // Find Username
    @FindBy(xpath = "//input[@name='username']")
    WebElement Username;

    // Find Password
    @FindBy(name = "password")
    WebElement Password;

    // Find Login Button
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbtn;

    // Find Dashboard text
    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement Title;

    // Find Profile dropdown Element
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement Profile;

    // Find Logout Element
    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']//a[text()='Logout']")
    WebElement Logout;

    // Find Username
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement InvalidErrorMsg;

    @Step("Enter UserName: {arg0}")
    public void EnterUsername(String usernm) {
        wait.waitForElementToBeVisible(Username, 10);
        Username.sendKeys(usernm);
        log.info("Enter User Name:"+usernm);
    }

    @Step("Enter UserName: {arg0}")
    public void EnterPassword(String pass) {
        wait.waitForElementToBeVisible(Password, 10);
        Password.sendKeys(pass);
        log.info("Enter Password:"+pass);
    }

    @Step("Click on Login button")
    public void ClickOnLoginButton() {
        wait.waitForElementToBeClickable(loginbtn, 10);
        loginbtn.click();
        log.info("Click on login button");
    }

    @Step("Get page title")
    public void GetTitle() {
        wait.waitForElementToBeVisible(Title, 10);
        System.out.println("Home page title: " + Title.getText());
    }

    @Step("Click on Profile")
    public void ClickOnProfile() {
        wait.waitForElementToBeClickable(Profile, 10);
        Profile.click();
        log.info("Click on login Profile icon");
    }

    @Step("Click on Logout Option")
    public void ClickOnLogout() {
        wait.waitForElementToBeClickable(Logout, 10);
        Logout.click();
        log.info("Click on Logout button");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Try invalid login with Username: {arg0} and Password: {arg1}")
    public void InvalidLogin(String Usernamee, String PassWord) {
        wait.waitForElementToBeVisible(Username, 10).sendKeys(Usernamee);
        wait.waitForElementToBeVisible(Password, 10).sendKeys(PassWord);
        wait.waitForElementToBeClickable(loginbtn, 10).click();
        wait.waitForElementToBeVisible(InvalidErrorMsg, 10);
        System.out.println("Error message is: " + InvalidErrorMsg.getText());

    }
}

