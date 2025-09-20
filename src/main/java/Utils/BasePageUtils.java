package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePageUtils {

    WebDriver driver;
    WaitUtils wait;

    public BasePageUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    // Generic: enter text by label name
    public void enterTextByLabel(String labelText, String value) {
        String xpath = "//label[text()='" + labelText + "']/../following-sibling::div//input";
        WebElement inputField = wait.waitForElementToBeVisibleByLocator(By.xpath(xpath), 10);
        inputField.sendKeys(value);
        System.out.println("Entered text '" + value + "' in field: " + labelText);
    }

    // Generic: select dropdown value by label
    public void selectDropdownByLabel(String labelText, String optionToSelect) {
        String dropdownXpath = "//label[text()='" + labelText + "']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]";
        WebElement dropdown = wait.waitForElementToBeClickableBy(By.xpath(dropdownXpath), 10);
        dropdown.click();

        String optionsXpath = "//div[@role='listbox']//div[@role='option']";
        List<WebElement> options = wait.waitForPresenceOfAllElementsLocatedBy(By.xpath(optionsXpath), 10);

        boolean found = false;
        for (WebElement opt : options) {
            if (opt.getText().equalsIgnoreCase(optionToSelect)) {
                opt.click();
                found = true;
                System.out.println("Dropdown '" + labelText + "' selected: " + optionToSelect);
                break;
            }
        }

        if (!found) {
            System.out.println("Option '" + optionToSelect + "' not found under dropdown: " + labelText);
        }
    }

    // Generic: click button by visible text
    public void clickButtonByText(String buttonText) {
        String xpath = "//button[normalize-space()='" + buttonText + "']";
        WebElement button = wait.waitForElementToBeClickableBy(By.xpath(xpath), 10);
        button.click();
        System.out.println("Clicked on button: " + buttonText);
    }

}
