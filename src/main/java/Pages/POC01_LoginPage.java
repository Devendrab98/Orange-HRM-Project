package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class POC01_LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public POC01_LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
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


    public void EnterUsername(String usernm) {
        wait.until(ExpectedConditions.visibilityOf(Username));
        Username.sendKeys(usernm);
    }

    public void EnterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOf(Password));
        Password.sendKeys(pass);
    }

    public void ClickOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
        loginbtn.click();
    }

    public void GetTitle() {
        wait.until(ExpectedConditions.visibilityOf(Title));
        System.out.println("Home page title: " + Title.getText());
    }

    public void ClickOnProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(Profile));
        Profile.click();
    }

    public void ClickOnLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(Logout));
        Logout.click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void InvalidLogin(String Usernamee, String PassWord) {
        wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(Usernamee);
        wait.until(ExpectedConditions.visibilityOf(Password)).sendKeys(PassWord);
        wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();
        wait.until(ExpectedConditions.visibilityOf(InvalidErrorMsg));
        System.out.println("Error message is: " + InvalidErrorMsg.getText());

    }
}

