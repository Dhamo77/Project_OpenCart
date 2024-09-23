package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-email")
    WebElement emailBox;
    @FindBy(css = "#input-password")
    WebElement passwordBox;
    @FindBy(xpath = "(//*[@class='btn btn-primary'])[2]")
    WebElement loginButton;
    @FindBy(xpath = "(//*[@href='https://demo.opencart.com/en-gb?route=account/forgotten'])[1]")
    WebElement forgottenPasswordLink;
    @FindBy(xpath = "//*[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;
    @FindBy(xpath = "(//*[@class='btn btn-primary'])[1]")
    WebElement newCustomerLink;

    /**
     Action methods
     **/
    public void enterEmailId(String email){
        emailBox.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordBox.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void forgottenPasswordLink(){
        forgottenPasswordLink.click();
    }
    public String getWarningMessage(){
        return warningMessage.getText();
    }
    public void navigateToRegistrationPage(){
        newCustomerLink.click();
    }
}
