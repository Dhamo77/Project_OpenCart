package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountInformationPage extends BasePage{
    public MyAccountInformationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#input-firstname")
    private WebElement firstNameBox;
    @FindBy(css = "#input-lastname")
    private WebElement lastNameBox;
    @FindBy(css = "#input-email")
    private WebElement emailBox;

    public String getFirstNameValue(){
        return firstNameBox.getAttribute("value");
    }
    public String getLastNameValue(){
        return lastNameBox.getAttribute("value");
    }
    public String getEmailValue(){
        return emailBox.getAttribute("value");
    }
}
